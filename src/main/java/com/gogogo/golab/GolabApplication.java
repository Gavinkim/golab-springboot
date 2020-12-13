package com.gogogo.golab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class GolabApplication {

  public static void main(String[] args) {
    SpringApplication.run(GolabApplication.class, args);
  }

//  @Bean
//  public CommandLineRunner runner(BoardRepository boardRepository) throws Exception {
//    boardRepository.deleteAll();
//    return (args -> {
//      IntStream.rangeClosed(1,100).forEach(index ->
//          boardRepository.save(Board.builder()
//              .title(String.format("%s-%s",index,"Test"))
//              .content(String.format("%s-%s",index,"This is content."))
//              .build()));
//    });
//  }
}
