package com.gogogo.golab.domain.user;

import com.gogogo.golab.domain.GolabJpaRepository;
import java.util.Optional;

public interface UserRepository extends GolabJpaRepository<User,Long> {
  Optional<User> findByIdx(Long idx);
  long countByEmail(String email);
}
