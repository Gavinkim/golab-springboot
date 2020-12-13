package com.gogogo.golab.exception;

public class DuplicateEmailException extends RuntimeException{

  public DuplicateEmailException(String message) {
    super(message);
  }
}
