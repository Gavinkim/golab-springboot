package com.gogogo.golab.service.board;

import com.gogogo.golab.domain.board.Board;
import com.gogogo.golab.domain.board.BoardRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{

  private final BoardRepository boardRepository;

  @Transactional(readOnly = false)
  @Override
  public void save(BoardDto boardDto){
    boardRepository.save(boardDto.toEntity());
  }

  @Transactional(readOnly = false)
  @Override
  public void modify(BoardDto boardDto){
    Board board = boardRepository.findByIdx(boardDto.getIdx()).orElseThrow();
    board.setContent(boardDto.getContent());
    board.setTitle(boardDto.getTitle());
    boardRepository.save(board);
  }

  @Transactional(readOnly = false)
  @Override
  public void remove(Long idx){
    boardRepository.deleteById(idx);
  }

  @Transactional(readOnly = true)
  @Override
  public Page<Board> list(Pageable pageable) {
    int page = pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() -1;
    int size = pageable.getPageSize();
    pageable = PageRequest.of(page, size);
    return boardRepository.findAll(pageable);
  }

  @Transactional(readOnly = true)
  @Override
  public List<Board> list() {
    return boardRepository.findAll();
  }

  @Transactional(readOnly = true)
  @Override
  public Board getPost(Long idx){
    return boardRepository.findByIdx(idx).orElse(new Board());
  }
}
