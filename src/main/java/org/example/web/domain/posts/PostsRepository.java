package org.example.web.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// JpaRepository를 상속하면 기본적인 CRUD 메서드는 자동 추가
public interface PostsRepository extends JpaRepository<Posts,Long> {
    @Query("select p from Posts p order by p.id desc ")
    List<Posts> findAllDesc();
}
