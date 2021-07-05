package com.gayoung.book.springboot.web.dto;

import com.gayoung.book.springboot.domain.posts.posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public posts toEntity(){
        return posts.builder().title(title).content(content).author(author).build();
    }
}
