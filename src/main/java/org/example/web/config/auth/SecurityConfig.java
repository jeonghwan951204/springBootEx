package org.example.web.config.auth;

import lombok.RequiredArgsConstructor;
import org.example.web.domain.user.Role;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity      // spring security 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .headers().frameOptions().disable() // h2-console 화면을 사용하기위해 이 옵션들은 disable함
                .and()
                .authorizeHttpRequests()    // url 별 권한 관리를 설정하는 시작점, 이게 있어야만 antMatchers 옵션 사용가능
                .antMatchers("/","/css/**","/images/**","/js/**","/h2-console/**","/profile") //권한관리 대상을 지정, url, http메서드 별로 관리가능
                .permitAll()// / 등 지정된 url들은 전체 열람 권한을 줌
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())// /api/v1/**의 api들은 user권한을 가진 사람만 가능,
                .anyRequest()   // 설정된 값 이외의 나머지 Url
                .authenticated() // 나머지 url 들은 모두 인증된 사용자들에게만 허용(로그인한 사용자)
                .and()
                .logout()
                .logoutSuccessUrl("/") // 로그아웃에 관한 설정, 성공시 /로 이동
                .and()
                .oauth2Login()  // OAuth2 에 관한 설정 시작
                .userInfoEndpoint() // OAuth2 로그인 성공 이후 사용자 정보를 가져올 때의 설정 담당
                .userService(customOAuth2UserService); //소셜 로그인 성공 시 후속 조치를 진행할 인터페이스 구현체 등록
                                                                // 리소스 서버에서 사용자 정보를 가져온 상태에서 추가 진행할 기능 명시
    }
}
