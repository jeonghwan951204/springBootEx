package org.example.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.web.domain.posts.Posts;

/*
* Entity 클래스와 비슷하지만 Dto를 생성
* Entity 클래스는 Request, Response 클래스로 사용하면 안됨
* 데이터베이스와 직접 맞닿아 있는 핵심 클래스이며 이를 변경하는 것은 많은 비용이 필요하다
* */
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title,String content,String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
