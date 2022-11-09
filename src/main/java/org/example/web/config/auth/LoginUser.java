package org.example.web.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)  // 어노테이션이 생성될 수 있는 위치, PARAMETER는 메서드의 파라미터로 선언된 객체서만 사용
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {   //@interface -> 어노테이션 클래스로 지정
}
