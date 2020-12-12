package com.gogogo.golab.domain.board;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BoardRepository extends JpaRepository<Board,Long> {

  Optional<Board> findByIdx(Long idx);

}
