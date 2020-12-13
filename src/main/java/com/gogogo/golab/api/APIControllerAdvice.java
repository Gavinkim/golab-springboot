package com.gogogo.golab.api;

import com.gogogo.golab.common.ResponseCode;
import com.gogogo.golab.common.ResponseDto;
import com.gogogo.golab.exception.ConnectionException;
import com.gogogo.golab.exception.DuplicateEmailException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class APIControllerAdvice {
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex){
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getAllErrors()
        .forEach(c -> errors.put(((FieldError) c).getField(), c.getDefaultMessage()));
    return ResponseEntity.badRequest().body(errors);
  }

  @ExceptionHandler(DuplicateEmailException.class)
  public ResponseEntity<ResponseDto> duplicateEmail(){
    return ResponseEntity.badRequest().body(ResponseDto.error(ResponseCode.ALREADY_EXISTS));
  }

  @ExceptionHandler(ConnectionException.class)
  public ResponseEntity<ResponseDto> connectionFail(){
    return ResponseEntity.badRequest().body(ResponseDto.error(ResponseCode.EXTERNAL_CONNECTION_ERROR));
  }
}
