package com.shop.mapper;

import com.github.pagehelper.Page;
import com.shop.dto.MallDTO;
import com.shop.frame.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MallMapper extends MyMapper<Integer, MallDTO> {
  public List<MallDTO> search(String txt) throws Exception;
  public Page<MallDTO> getPage();
}