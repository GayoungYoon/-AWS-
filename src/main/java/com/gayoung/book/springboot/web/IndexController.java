package com.gayoung.book.springboot.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "index";
        /**머스테치 스타터 덕분에 컨트롤러에서 문자열을 반활할 떄 앞의 경로와
         * 파일의 확장자는 자동으로 지정됨.
         * 앞의 경로 : src/main/resource/templates
         * 확장자 : .mustache
         * >> index만 반환해줘도 URL 요청의 결과의 타입과 값을 지정하는 ViewResolver에게
         * src/main/resource/templates/index.mustache가 전달된다.
         * */
    }

    @GetMapping("/posts/save") /**index.mustache에서 글을 등록하는 버튼의 레퍼런스와 일치*/
    public String postsSave(){
        return "posts-save";
    }
}

