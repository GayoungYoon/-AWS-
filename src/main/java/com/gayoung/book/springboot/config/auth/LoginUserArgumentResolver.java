package com.gayoung.book.springboot.config.auth;

import com.gayoung.book.springboot.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Component
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {
    private final HttpSession httpSession;

    /**HandlerMethodArgumentResolver :
     * 조건에 맞는 경우 메소드가 있다면 Han~의 구현체가 지정한 값으로 해당 메소드의 파라미터를 바로 넘길 수 있음.
     * implement method : resolveArgument
     * */

    @Override
    public boolean supportsParameter(MethodParameter parameter){
        boolean isLoginUserAnnotation = parameter.getParameterAnnotation(LoginUser.class) !=null ;
        //파라미터에 @LoginUser 어노테이션이 붙어있는지
        boolean isUserClass = SessionUser.class.equals(parameter.getParameterType());
        // 클래스 타입이 SessionUser 인지


        return isLoginUserAnnotation&&isUserClass;
        //컨트롤러 메소드의 특정 파라미터를 지원하는지 판단
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
       //파라미터에 전달할 객체를 생성. 여기서는 세션 객체
        return httpSession.getAttribute("user");
    }

}
