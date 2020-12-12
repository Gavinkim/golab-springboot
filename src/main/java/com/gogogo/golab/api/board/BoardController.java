package com.gogogo.golab.api.board;

import com.gogogo.golab.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/board")
@RequiredArgsConstructor
public class BoardController {

  private final BoardService boardService;
}
