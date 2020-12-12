package com.gogogo.golab.api.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCode {
  OK(200,"OK"),
  NOT_FOUND(404,"Not found."),
  INTERNAL_SERVER_ERROR(500,"Internal server error.");

  private int code;
  private String message;
}
