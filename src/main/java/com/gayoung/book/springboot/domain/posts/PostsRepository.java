package com.gayoung.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<posts,Long> {
    /**
     * JpaRepository extends 후 <Entity Class, PK Type>를 상속하면
     * 기본적인 CRUD메소드가 자동으로 생성됨.
     * Entity & EntityRepository는 함께 위치 해야됨.
     * */

    @Query("SELECT p FROM posts p ORDER BY p.id DESC")
    List<posts> findAllDesc();
}
