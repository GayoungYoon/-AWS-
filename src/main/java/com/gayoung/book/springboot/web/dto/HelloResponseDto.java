package com.gayoung.book.springboot.web.dto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter //선언된 모든 필드의 get 메소드를 생성
@RequiredArgsConstructor //final 이 있는 필드에 대해 생성자를 생성해줌.
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
