package com.gayoung.book.springboot.web;

import com.gayoung.book.springboot.config.auth.LoginUser;
import com.gayoung.book.springboot.config.auth.dto.SessionUser;
import com.gayoung.book.springboot.service.posts.PostsService;
import com.gayoung.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        /**model : 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장*/
        model.addAttribute("posts", postsService.findAllDesc());

        //SessionUser user = (SessionUser) httpSession.getAttribute("user");
        // 메소드 파라미터로 @LoginUser 를 받기 때문에 해당 코드로 세션정보를 가져오던코드를 안써도 됨.
        // 어느 컨트롤러에서든 @LoginUser 만 사용하면 세션 정보를 가져올 수 있게 됨.

        if(user!=null){
            model.addAttribute("userName", user.getName());
        }

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

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }

}

