package com.gogogo.golab.service.user;

import com.gogogo.golab.domain.user.User;
import com.gogogo.golab.domain.user.UserRepository;
import com.gogogo.golab.exception.DuplicateEmailException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Transactional(readOnly = true)
  @Override
  public User getUser(Long idx) {
    return userRepository.findByIdx(idx).orElseThrow();
  }

  @Transactional(readOnly = true)
  @Override
  public List<User> list() {
    return userRepository.findAll();
  }

  @Transactional(readOnly = false)
  @Override
  public void save(UserDto userDto) {
    long isExist = userRepository.countByEmail(userDto.getEmail());
    if(isExist>0){
      throw new DuplicateEmailException("Already Exists");
    }
    userRepository.save(userDto.toEntity());
  }

  @Override
  public void delete(Long idx) {
    userRepository.deleteById(idx);
  }

  @Override
  public void modify(UserDto userDto) {
    User user = userRepository.findByIdx(userDto.getIdx()).orElseThrow();
    user.setPassword(userDto.getPassword());
    userRepository.save(user);
  }
}
