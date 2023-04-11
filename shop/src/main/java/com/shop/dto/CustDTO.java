package com.shop.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class CustDTO {
  private String id;
  private String pwd;
  private String name;
}