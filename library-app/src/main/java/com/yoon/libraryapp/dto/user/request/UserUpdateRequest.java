package com.yoon.libraryapp.dto.user.request;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserUpdateRequest {

  private Long id;
  private String name;

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
