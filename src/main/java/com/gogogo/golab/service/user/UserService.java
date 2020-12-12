package com.gogogo.golab.service.user;

import com.gogogo.golab.domain.user.User;
import java.util.List;

public interface UserService {
  public User getUser(Long idx);
  public List<User> list();
  public void save(UserDto userDto);
  public void delete(Long idx);
  public void modify(UserDto userDto);
}
