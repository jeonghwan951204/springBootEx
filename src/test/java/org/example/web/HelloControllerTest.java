package org.example.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//테스트 진행 시 Junit에 내장된 실행자 외 다른 실행자도 실행 스프링부트 테스트와 Junit사이를 연결
@ExtendWith(SpringExtension.class)  //RunWith 어노테이션 대신 Junit5에서 변경
//web에 집중한 테스트 어노테이션 컨트롤러만 사용가능
@WebMvcTest(controllers = HelloController.class)
class HelloControllerTest {

    // 스프링이 관리하는 빈 주입
    @Autowired
    // 웹 API를 테스트할 때 사용
    private MockMvc mvc;

    @Test
    void hello가_리턴() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())   // MockResultMachers에서 리턴값을 맞춰봄
                .andExpect(content().string("hello"));
    }

    @Test
    void helloDtoReturn() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(MockMvcRequestBuilders.get("/hello/dto")
                .param("name",name).param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",equalTo(name)))
                .andExpect(jsonPath("$.amount",equalTo(amount)));
    }

}
