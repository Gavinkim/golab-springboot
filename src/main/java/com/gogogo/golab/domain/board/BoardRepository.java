package com.gogogo.golab.domain.board;

import com.gogogo.golab.domain.GolabJpaRepository;
import java.util.Optional;


public interface BoardRepository extends GolabJpaRepository<Board,Long>, BoardCustomRepository {

  Optional<Board> findByIdx(Long idx);

}
