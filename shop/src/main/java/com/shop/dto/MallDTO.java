package com.shop.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MallDTO {
  private int id;
  private String name;
  private String address;
  private String imgname; // 파일 이름
  private LocalDateTime rdate;
  private String ownername;
  private String phonenumber;

  private MultipartFile img; // 이미지 파일
}