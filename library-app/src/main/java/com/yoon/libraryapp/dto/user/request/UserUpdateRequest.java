package com.yoon.libraryapp.dto.user.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserUpdateRequest {

  private Long id;
  private String name;

}
