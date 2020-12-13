package com.gogogo.golab.service.user;

import com.gogogo.golab.domain.user.User;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {

  private Long idx;

  @NotNull
  @NotEmpty
  @NotBlank
  @Size(max = 50,min = 3)
  private String name;

  @NotNull
  @NotEmpty
  @NotBlank
  private String password;

  @NotNull
  @NotEmpty
  @NotBlank
  @Email
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
