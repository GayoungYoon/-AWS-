package com.gayoung.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<posts,Long> {
    /**
     * JpaRepository extends 후 <Entity Class, PK Type>를 상속하면
     * 기본적인 CRUD메소드가 자동으로 생성됨.
     * Entity & EntityRepository는 함께 위치 해야됨.
     * */
}
