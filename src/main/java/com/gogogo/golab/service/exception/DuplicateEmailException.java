package com.gogogo.golab.service.exception;

public class DuplicateEmailException extends RuntimeException{

  public DuplicateEmailException(String message) {
    super(message);
  }
}
