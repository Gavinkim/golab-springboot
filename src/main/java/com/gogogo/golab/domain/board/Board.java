package com.gogogo.golab.domain.board;

import com.gogogo.golab.domain.BaseTimeEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@NoArgsConstructor
@Entity
@Table
@ToString
public class Board extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idx;

  @Setter
  @Column(name = "title",nullable = false)
  private String title;

  @Setter
  @Column(name = "content",length = 2000,nullable = false)
  private String content;

  @Builder
  public Board(Long idx,String title, String content) {
    this.idx = idx;
    this.title = title;
    this.content = content;
  }
}
