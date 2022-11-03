package org.example.web.dto;

import lombok.Getter;
import org.example.web.domain.posts.Posts;

@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    // entity의 필드 중 일부만 사용하기때문에 생성자에 값을 넣어 받음
    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
