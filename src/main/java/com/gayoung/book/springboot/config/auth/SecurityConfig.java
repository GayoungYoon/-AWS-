package com.gayoung.book.springboot.config.auth;

import com.gayoung.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customUserTypesOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().headers().frameOptions().disable()/**h2-console화면을 사용하기 위해 disable시킴*/
                .and().authorizeRequests() /**URL별 권한 관리를 설정하는 옵션의 시작점. 얘를 설정해줘야만 antMatchers 옵션 사용가능*/
                .antMatchers("/","/css/**","/images/**","/js/**","/h2-console/**").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                    /** antMatchers :
                     *  - 권한 관리 대상을 지정하는 옵션.
                     *  - URL, HTTP 메소드별로 관리가 가능
                     *  - "/" 로 시작하는 주소는 전체 열람 권한
                     *  - "/api"로 시작하는 주소는 User 권한을 가진 사람들만 열람 가능
                    */
                .anyRequest().authenticated() /**설정된 값들 이외의 나머지 URL*/
                .and().logout().logoutSuccessUrl("/") /**logout 성공시 /로 이동*/
                .and().oauth2Login() /**로그인 설정의 ㅈㄴ입점*/
                .userInfoEndpoint() /**로그인 성공 이후 사용자 정보를 가져올 때의 설정들을 담당*/
                .userService(customUserTypesOAuth2UserService);
                  /**로그인 성공시 후속조치를 진행할 UserService 인터페이스의 구현체를 등록.
                   * 리소스 서버(소셜 서비스 등)에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능 명시
                   * */
    }
}
