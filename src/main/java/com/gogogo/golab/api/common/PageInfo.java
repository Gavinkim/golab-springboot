package com.gogogo.golab.api.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageInfo {
  private int page; //현재 페이지
  private int size; //페이지에 출력할 개수
  private int totalPage;//총 페이지 개수
  private long totalElements; //전체 개수
}
