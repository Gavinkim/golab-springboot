package com.gogogo.golab.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ObjectUtils;

@Slf4j
public class Utils extends ObjectUtils {

  public static String randomAlphanumeric(int count){
    return String.format("%s", RandomStringUtils.randomAlphanumeric(count)).toUpperCase();
  }

  public static String randomNumeric(int count){
    return String.format("%s", RandomStringUtils.randomNumeric(count));
  }

  public static boolean isNotEmpty(Object obj){
    return !isEmpty(obj);
  }

  public static Date localDateTimeTodate(LocalDateTime localDateTime){
    return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
  }

  public static LocalDateTime dateToLocalDateTime(Date date){
    return date.toInstant().atZone(ZoneId.systemDefault())
        .toLocalDateTime();
  }

  public static boolean isBlank(String src){
    return StringUtils.isBlank(src);
  }

}
