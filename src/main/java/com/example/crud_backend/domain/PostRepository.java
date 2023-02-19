package com.example.crud_backend.domain;

import org.springframework.data.jpa.repository.JpaRepository;
public interface PostRepository extends JpaRepository<Posts, Long> {
}
