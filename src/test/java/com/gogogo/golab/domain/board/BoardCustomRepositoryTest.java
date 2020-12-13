package com.gogogo.golab.domain.board;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardCustomRepositoryTest {

  @Autowired
  private BoardRepository boardRepository;

  @Test
  @DisplayName("search key 테스트")
  public void searchKeyTest(){
    boardRepository.search("gavin");
  }
}