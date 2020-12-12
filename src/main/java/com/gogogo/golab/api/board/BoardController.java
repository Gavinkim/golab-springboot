package com.gogogo.golab.api.board;

import com.gogogo.golab.api.common.ResponseDto;
import com.gogogo.golab.service.board.BoardDto;
import com.gogogo.golab.service.board.BoardService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/board")
@RequiredArgsConstructor
public class BoardController {

  private final BoardService boardService;

  @PostMapping
  public ResponseEntity<ResponseDto> save(@RequestBody @Valid BoardDto boardDto){
    boardService.save(boardDto);
    return new ResponseEntity<>(ResponseDto.ok(), HttpStatus.CREATED);
  }
}
