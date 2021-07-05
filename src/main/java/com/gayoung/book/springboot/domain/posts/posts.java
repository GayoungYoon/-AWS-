package com.gayoung.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Getter // lombok annotation
@NoArgsConstructor // lombok annotation - 기본 생성자 자동 추가
@Entity // Jpa Annotation : 필수 어노테이션이므로 클래스 가까이에 위치하게 둔다.
// entity : 테이블과 링크될 클래스임을 알려줌. sales_manager table > salesManager.java
public class posts extends BaseTimeEntity{
    @Id // PK annotation
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //PK 생성 규칙 : IDENTITY 옵션을 추가해야만 auto_increment
    private Long id;

    @Column(length=500, nullable = false)
    //안써줘도 무방하지만 옵션을 줘야할 때는 annotation추가.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스를 생성. 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함.
    public posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
