package com.gogogo.golab.domain.board;

import com.gogogo.golab.service.board.BoardDto;
import java.util.List;

public interface BoardCustomRepository {
  public List<BoardDto> search(String q );
}
