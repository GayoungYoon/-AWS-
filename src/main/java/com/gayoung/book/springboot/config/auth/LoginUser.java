package com.gayoung.book.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
/** 어노테이션이 부착될 수 있는 타입을 지정
 *  type = Parameter이므로 메소드의 파라미터로 선언된 객체에서만 사용할 수 있음
 *  그 외 constructor, method, field, annotation, local variable, package
 * */
@Retention(RetentionPolicy.RUNTIME)
/**LoginUser라는 파일을 어노테이션 클래스로 정의함. LoginUser라는 어노테이션을 이제 사용할 수 있음.*/
public @interface LoginUser {
}
