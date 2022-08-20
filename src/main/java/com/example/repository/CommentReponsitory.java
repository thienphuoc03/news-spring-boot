package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Comment;

public interface CommentReponsitory extends JpaRepository<Comment, Long> {

}
