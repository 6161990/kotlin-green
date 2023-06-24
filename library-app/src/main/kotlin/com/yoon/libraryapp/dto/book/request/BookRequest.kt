package com.yoon.libraryapp.dto.book.request;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BookRequest {

  private String name;

  public String getName() {
    return name;
  }
}
