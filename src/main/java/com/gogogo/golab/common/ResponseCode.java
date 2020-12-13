package com.gogogo.golab.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCode {
  OK(2000,"OK"),
  INTERNAL_SERVER_ERROR(5000,"Internal server error."),
  EXTERNAL_CONNECTION_ERROR(4003,"connection error."),
  NOT_FOUND(4004,"Not found."),
  ALREADY_EXISTS(4005,"Already exists.");

  private int code;
  private String message;
}
