package com.coreco.blogapp.repositories;

import com.coreco.blogapp.models.Comment;

import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long>{

}
