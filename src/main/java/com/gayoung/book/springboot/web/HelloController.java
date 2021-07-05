package com.gayoung.book.springboot.web;
import com.gayoung.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //return Json
public class HelloController {

    @GetMapping("/hello") // Http Method인 Get 의 요청을 받을 수 있는 API 생성
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name")String name, @RequestParam("amount")int amount){
        return new HelloResponseDto(name, amount);
    }

}
