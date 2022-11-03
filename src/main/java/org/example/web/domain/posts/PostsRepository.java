package org.example.web.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository를 상속하면 기본적인 CRUD 메서드는 자동 추가
public interface PostsRepository extends JpaRepository<Posts,Long> {
}
