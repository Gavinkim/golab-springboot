package com.gogogo.golab.domain.user;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
  Optional<User> findByIdx(Long idx);
  long countByEmail(String email);
}
