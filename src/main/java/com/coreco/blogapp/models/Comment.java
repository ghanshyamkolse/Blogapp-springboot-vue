package com.coreco.blogapp.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Comment {
  @Id
  Long id;
  Long postId;
  String text;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getPostId() {
    return postId;
  }

  public void setPostId(Long postId) {
    this.postId = postId;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  @Override
  public String toString() {
    return "Comment [id=" + id + ", postId=" + postId + ", text=" + text + "]";
  }
}
