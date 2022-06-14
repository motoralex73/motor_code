package com.example.motor_bank.repo;

import com.example.motor_bank.model.Post;
import org.springframework.data.repository.CrudRepository; //работа с таблицами

public interface PostRepository extends CrudRepository<Post, Long> {
}
