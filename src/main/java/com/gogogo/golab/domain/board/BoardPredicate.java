package com.gogogo.golab.domain.board;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

public final class BoardPredicate {
  private final static QBoard board = QBoard.board;

  public static Predicate search(String key){
    BooleanBuilder builder = new BooleanBuilder();
    builder.or(board.title.like(key)).or(board.content.like(key));
    return builder;
  }
}
