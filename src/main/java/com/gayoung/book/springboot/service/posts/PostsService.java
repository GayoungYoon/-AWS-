package com.gayoung.book.springboot.service.posts;

import com.gayoung.book.springboot.domain.posts.PostsRepository;
import com.gayoung.book.springboot.domain.posts.posts;
import com.gayoung.book.springboot.web.dto.PostUpdateRequestDto;
import com.gayoung.book.springboot.web.dto.PostsListResponseDto;
import com.gayoung.book.springboot.web.dto.PostsResponseDto;
import com.gayoung.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostUpdateRequestDto requestDto){
        posts posts = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 없습니다. id =" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id){
        System.out.println("h222222222: " + id);
        posts entity  = postsRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 게시글이 없습니다.id=" +id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true) /** transaction의 범위는 유지하되 조회 기능만 남겨두어 조회 기능 개선*/
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream().map(PostsListResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id){
        posts posts = postsRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 게시글이 없습니다.id=" +id));
        postsRepository.delete(posts); // or postsRepository.deleteById(id);
    }
}
