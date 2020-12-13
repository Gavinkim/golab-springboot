package com.gogogo.golab.domain.board;

import com.gogogo.golab.service.board.BoardDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class BoardCustomRepositoryImpl implements BoardCustomRepository {

  private final static QBoard board = QBoard.board;
  private final JPAQueryFactory jpaQueryFactory;

  @Override
  public List<BoardDto> search(String q) {
    return jpaQueryFactory.select(
        Projections.fields(BoardDto.class,
            board.idx,
            board.title,
            board.content,
            board.createdAt,
            board.updatedAt))
        .from(board)
        .where(BoardPredicate.search(q))
        .fetch();
  }
}
