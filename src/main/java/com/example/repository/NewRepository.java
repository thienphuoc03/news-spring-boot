package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.News;

@Repository
public interface NewRepository extends JpaRepository<News, Long> {

}
