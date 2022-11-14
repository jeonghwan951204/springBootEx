package org.example.web;

import lombok.RequiredArgsConstructor;
import org.example.web.config.auth.LoginUser;
import org.example.web.config.auth.dto.SessionUser;
import org.example.web.dto.PostsResponseDto;
import org.example.web.dto.PostsSaveRequestDto;
import org.example.web.service.posts.PostsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    /**
     * 컨트롤러에서 @LoginUser를 사용하면 세션정보를 가져올 수 있음
     * @param model
     * @param user
     * @return
     */
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        // mustache 스타터로 인해 문자열 앞에 자동으로 src/main/resources/templates가 붙음 경로 다르면 application.yml에 따로 명시
        model.addAttribute("posts", postsService.findAllDesc());
        /* 로그인 성공 시 세션에 유저 정보를 넣게 구현해서 사용 가능, 어노테이션 구현으로 쓰지 않음
        SessionUser user = (SessionUser) httpSession.getAttribute("user"); */

        if(user != null) {  // 세션에 값이 있으면 이름이 나오게 없으면 로그인 버튼이 나옴
            model.addAttribute("loginUserName", user.getName());
        }

        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

}
