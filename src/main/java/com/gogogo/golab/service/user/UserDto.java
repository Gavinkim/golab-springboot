package com.gogogo.golab.service.user;

import com.gogogo.golab.domain.user.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {

  private Long idx;
  private String name;
  private String password;
  private String email;

  @Builder
  public UserDto(Long idx, String name, String password, String email) {
    this.idx = idx;
    this.name = name;
    this.password = password;
    this.email = email;
  }

  public User toEntity(){
    return User.builder()
        .name(name)
        .email(email)
        .password(password)
        .build();
  }
}
