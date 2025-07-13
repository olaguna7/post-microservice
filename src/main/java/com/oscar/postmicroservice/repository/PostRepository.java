package com.oscar.postmicroservice.repository;

import com.oscar.postmicroservice.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
