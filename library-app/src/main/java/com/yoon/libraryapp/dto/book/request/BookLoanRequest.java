package com.yoon.libraryapp.dto.book.request;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BookLoanRequest {

  private String userName;
  private String bookName;

  public String getUserName() {
    return userName;
  }

  public String getBookName() {
    return bookName;
  }
}
