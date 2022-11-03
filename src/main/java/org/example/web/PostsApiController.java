package org.example.web;

import lombok.RequiredArgsConstructor;
import org.example.web.dto.PostsResponseDto;
import org.example.web.dto.PostsSaveRequestDto;
import org.example.web.dto.PostsUpdateRequestDto;
import org.example.web.service.posts.PostsService;
import org.springframework.web.bind.annotation.*;

/*
* autowired 없이 사용
* 스프링에서 bean을 주입하는 방식은 autowired, setter, 생성자가 있다
* 그 중에 생성자를 가장 권장
* 생성자로 bean 주입 시 RequiredArgsConstructor에서 생성자를 만들어 줌
* 롬복 어노테이션을 사용하면 의존성 관계가 변경되더라도 코드 수정이 필요없다
*
* */
@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    // URL에 {}에 변수를 넣어 사용 pathVariable
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id,requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }
}
