package com.self.study.domain.posts;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given - 게시글 저장
        String title = "테스트 글 제목";
        String content = "테스트 글 내용";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("hyj")
                .build());

        //when - 전체 조회
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    //JPA Auditing 테스트
    @Test
    public void BaseTimeEntity_등록() {
        //given
        //현재 시간을 설정해서 저장
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder()
                .title("제목")
                .content("내용")
                .author("작성자")
                .build());

        //when
        //전제 조회
        List<Posts> postsList = postsRepository.findAll();

        //then
        //현재 시간보다 등록 시간이 후인지 확인
        Posts posts = postsList.get(0);
        System.out.println("현재 시간 = " + now);
        System.out.println("생성 시간 = " + posts.getCreatedDate());
        System.out.println("수정 시간= " + posts.getModifiredDate());
        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiredDate()).isAfter(now);
    }
}
