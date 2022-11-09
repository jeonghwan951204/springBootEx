package org.example.web.config.auth.dto;

import lombok.Getter;
import org.example.web.domain.user.User;

import java.io.Serializable;

/**
 * User 클래스를 사용하지 않고 dto를 따로 만드는 이유
 * 1. 바로 사용할 경우 직렬화를 구현하지 않았다고 에러
 * 2. 직렬화를 구현해 사용해도 엔티티이기 때문에 위험부담이 크다
 */
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
