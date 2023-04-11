package com.shop.mapper;

import com.shop.dto.ShopDTO;
import com.shop.frame.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ShopMapper extends MyMapper<String, ShopDTO> {
  public List<ShopDTO> selectWithMenu(String id) throws Exception;
}