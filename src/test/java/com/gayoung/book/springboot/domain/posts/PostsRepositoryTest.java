package com.gayoung.book.springboot.domain.posts;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class) /**이 어노테이션이 없으면 Repository.save같은 CRUD 테스트 불간*/
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup(){
        /**Junit 단위 테스트가 끝날 때마다 수행되는 메소드
         * 보통은 배포 전 전체 테스트를 수행할 때 테스트간 데이터 침범을 막기 위해 사용
         * 여러테스트가 동시에 수행되면 테스트용 데이터 베이스인 H2에 데이터가 그대로 남아
         * 다음 테스트에 영향을 줄 수 있음.
         */

        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        String title = "테스트게시글";
        String content ="테스트 본문";

        postsRepository.save(posts.builder().title(title).content(content).author("going@gmail.com").build());
        /**JpaRepository를 상속하는 인터페이스 이기 때문에 별도의 함수를 선언하지 않아도
         * CRUD 메소드가 제공된다고 했다.
         * Repository.save는 insert/ update ( Merge) 를 수행해주는 함수
         * */

        List<posts> postsList = postsRepository.findAll();
        /** findAll은 post테이블에 있는 모든 데이터를 조회해오는 메소드 */

        posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록(){
        //given
        LocalDateTime now = LocalDateTime.of(2021,7,4,0,0,0);
        postsRepository.save(posts.builder().title("title").content("content").author("author").build());

        //when
        List<posts> postsList = postsRepository.findAll();

        //then
        posts posts = postsList.get(0);

        System.out.println(">>>>>>>>createDate=" +posts.getCreatedDate() + ", " +
                "modified date="+ posts.getModifiedDate());

        /**
         * 실행로그 : Hibernate: insert into posts (created_date, modified_date, author, content, title) values (?, ?, ?, ?, ?)
         * */

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);

    }

}
