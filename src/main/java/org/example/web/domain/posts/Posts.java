package org.example.web.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.web.domain.BaseTimeEntity;

import javax.persistence.*;
/*
* setter는 Entity에서는 선언하지 않음
* 값 변경이 필요하면 목적과 의도를 나타낸 메서드 생성
* 생성자를 통해 값을 넣는다
* */

@Getter
@NoArgsConstructor      // 기본 생성자 추가
// 테이블과 링크될 클래스를 나타냄
// 이 경우 클래스이름은 언더스코어 네이밍으로 테이블명명
@Entity
public class Posts extends BaseTimeEntity {

    @Id // PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // 생성규칙을 나타냄 IDENTITY 옵션을 추가해 auto increment가 됨
    private Long id;

    @Column(length = 500,nullable = false)  //Column 굳이 추가하지 않아도 되지만 기본값외에 설정할 게 있으면 추가 후 설정
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder        // 빌더 패턴 생성, 생성자 상단에 선언하면 생성자에 포함한 필드만 포함
    public Posts(String title, String content,String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
