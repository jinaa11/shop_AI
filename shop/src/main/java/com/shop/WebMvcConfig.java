package com.shop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
  //uploadPath 프로퍼티값을 읽어온다
  @Value("${uploadpath}")
  String uploadPath; // c:/projectimg/img

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    // uploadPath를 html에서는 img라는 이름으로 사용함
    registry.addResourceHandler("/img/**").addResourceLocations(uploadPath);
    //로컬컴퓨터에 저장된 파일을 읽어올 root경로
  }
}
