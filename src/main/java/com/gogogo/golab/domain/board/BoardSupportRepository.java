package com.gogogo.golab.domain.board;


import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class BoardSupportRepository extends QuerydslRepositorySupport {
  private final static QBoard board = QBoard.board;

  public BoardSupportRepository() {
    super(Board.class);
  }

  @Transactional
  public List<Board> getBoardListWithSearchKey(String q){
    return from(board)
        .where(BoardPredicate.search(q))
        .fetch();
  }

}
