package com.gogogo.golab.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseDto<T> {
  private int code;
  private String message;
  @JsonInclude(Include.NON_NULL)
  private T data;
  @JsonInclude(Include.NON_NULL)
  private PageInfo pageInfo;

  @Builder
  public ResponseDto(int code,String message,T data,PageInfo pageInfo) {
    this.pageInfo = pageInfo;
    this.code = code;
    this.data = data;
    this.message = message;
  }

  public static <T> ResponseDto<T> create(ResponseCode code, T data){
    return ResponseDto.<T>builder()
        .code(code.getCode())
        .message(code.getMessage())
        .data(data)
        .build();
  }

  public static <T> ResponseDto<T> create(ResponseCode code, T data,PageInfo pageInfo){
    return ResponseDto.<T>builder()
        .code(code.getCode())
        .message(code.getMessage())
        .data(data)
        .pageInfo(pageInfo)
        .build();
  }

  public static ResponseDto create(ResponseCode code){
    return ResponseDto.builder()
        .code(code.getCode())
        .message(code.getMessage())
        .build();
  }

  public static ResponseDto error(ResponseCode code){
    return create(code);
  }

  public static <T> ResponseDto<T> ok(T data){
    return create(ResponseCode.OK,data);
  }

  public static <T> ResponseDto<T> ok(T data,PageInfo pageInfo){
    return create(ResponseCode.OK,data,pageInfo);
  }

  public static ResponseDto ok(){
    return create(ResponseCode.OK);
  }
}
