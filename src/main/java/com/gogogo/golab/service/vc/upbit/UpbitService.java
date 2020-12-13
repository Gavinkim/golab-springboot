package com.gogogo.golab.service.vc.upbit;


import com.gogogo.golab.exception.ConnectionException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class UpbitService {
  private final WebClient upbitWebClient;

  public Mono<String> getApi(String uri) {
    return upbitWebClient.get()
        .uri(uri)
        .retrieve()
        .onStatus(HttpStatus::is4xxClientError,clientResponse -> Mono.error(()->new ConnectionException("upbit connection fail.[4xx]")))
        .onStatus(HttpStatus::is5xxServerError,clientResponse -> Mono.error(()->new ConnectionException("upbit connection fail.[5xx]")))
        .onStatus(HttpStatus::isError,clientResponse -> Mono.error(()->new ConnectionException("upbit connection fail.[error]")))
        .bodyToMono(String.class);
  }
}
