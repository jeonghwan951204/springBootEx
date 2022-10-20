package org.example.web;

import org.example.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // 컨트롤러를 json으로 반환
public class HelloController {

    @GetMapping("/hello")   //HttpMethod의 Get 요청을 받음
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount) {
        // @RequestParam : 외부에서 api로 넘긴 파라미터 가져옴, 이름대로 넘긴 값을 받음
        return new HelloResponseDto(name,amount);
    }
}
