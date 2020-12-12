package com.gogogo.golab.service.board;

import com.gogogo.golab.domain.board.Board;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardDto {

  private Long idx;
  private String title;
  private String content;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  @Builder
  public BoardDto(Long idx, String title, String content, LocalDateTime createdAt,
      LocalDateTime updatedAt) {
    this.idx = idx;
    this.title = title;
    this.content = content;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }
  @Builder
  public Board toEntity(){
    return Board.builder()
        .title(title)
        .content(content)
        .build();
  }
}
