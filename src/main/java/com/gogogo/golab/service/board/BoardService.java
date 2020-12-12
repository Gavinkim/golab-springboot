package com.gogogo.golab.service.board;

import com.gogogo.golab.domain.board.Board;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardService {

  public void save(BoardDto boardDto);
  public void modify(BoardDto boardDto);
  public void remove(Long idx);
  public Page<Board> list(Pageable pageable);
  public List<Board> list();
  public Board getPost(Long idx);

}
