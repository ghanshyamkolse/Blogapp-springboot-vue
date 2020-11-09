package com.coreco.blogapp.controllers;

import java.util.ArrayList;
import java.util.List;

import com.coreco.blogapp.models.Post;
import com.coreco.blogapp.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class PostController {
  @Autowired
  PostRepository postRepository;

  @GetMapping(value = "/test")
  public String getMethodName() {
    return "ok tested";
  }

  @GetMapping(value = "/Post")
  public ResponseEntity<List<Post>> getPosts() {
    try {
      List<Post> _Post = new ArrayList<Post>();

      postRepository.findAll().forEach(_Post::add);

      if (_Post.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(_Post, HttpStatus.OK);
    } catch (Exception e) {

      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }

  @GetMapping(value = "/Post/{id}")
  public Post getMethodName(@RequestParam(required = false) String param) {
    return new Post();
  }

  @PostMapping(value = "/Post", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<Post> addPost(@RequestBody Post entity) {
    try {
      Post _Post = postRepository.save(entity);
      System.out.println(_Post);

      return new ResponseEntity<>(_Post, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }

  @PutMapping(value = "Post/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post entity) {
    try {
      Post _Post = null;
      if (postRepository.existsById(id)) {
        _Post = postRepository.save(entity);
      }

      return new ResponseEntity<>(_Post, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
