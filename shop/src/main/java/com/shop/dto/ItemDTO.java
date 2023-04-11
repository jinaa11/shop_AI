package com.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
  private int id;
  private String name;
  private int price;
  private String imgname; //imgname
  private Date rdate;

  // 화면에서 파일 올라올 때만 사용하는 변수
  private MultipartFile img;
}
