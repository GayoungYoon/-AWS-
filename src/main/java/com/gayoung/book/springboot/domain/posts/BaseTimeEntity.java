package com.gayoung.book.springboot.domain.posts;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass /** 공통필드를 부모 클래스에 넣어놓고 자식은 상속받아서 사용.
                      JPA Entity 클래스들이 BaseTimeEntity를 상속할경우 필드들로 칼럼으로 인식하도록 함.*/
@EntityListeners(AuditingEntityListener.class) /** Auditing 기능을 포함*/
public abstract class BaseTimeEntity {
    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
