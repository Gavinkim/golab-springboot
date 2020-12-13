package com.gogogo.golab.api.user;

import com.gogogo.golab.common.ResponseDto;
import com.gogogo.golab.service.user.UserDto;
import com.gogogo.golab.service.user.UserService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping
  public ResponseEntity<ResponseDto> getAllUser(){
    return new ResponseEntity<>(ResponseDto.ok(userService.list()), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<ResponseDto> save(@RequestBody @Valid UserDto userDto){
    userService.save(userDto);
    return new ResponseEntity<>(ResponseDto.ok(),HttpStatus.CREATED);
  }

}
