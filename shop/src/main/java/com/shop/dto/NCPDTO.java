package com.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NCPDTO {
  // 화면에서 파일 올라올 때만 사용하는 변수
  private MultipartFile img;
}
