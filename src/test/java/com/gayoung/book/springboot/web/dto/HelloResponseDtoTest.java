package com.gayoung.book.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void lombok_test(){
        String name ="test";
        int amount =1000;

        HelloResponseDto dto = new HelloResponseDto(name,amount);

        assertThat(dto.getName()).isEqualTo(name); // 검증라이브러리의 검증 메소드
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
