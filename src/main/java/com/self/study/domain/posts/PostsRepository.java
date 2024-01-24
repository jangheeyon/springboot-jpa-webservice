package com.self.study.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JpaRepository<Entity 클래스, PK 타입>을 상속하면 시본 CRUD 메서드 자동 생성
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
