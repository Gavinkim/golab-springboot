package com.gogogo.golab.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Table
@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idx;

  @Column(nullable = false,length = 50)
  private String name;

  @Setter
  @Column(nullable = false,length = 250)
  private String password;

  @Column(nullable = false,length = 100,unique = true)
  private String email;

  @Builder
  public User(Long idx, String name, String password, String email) {
    this.idx = idx;
    this.name = name;
    this.password = password;
    this.email = email;
  }
}
