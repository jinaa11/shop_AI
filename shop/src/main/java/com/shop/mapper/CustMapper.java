package com.shop.mapper;

import com.github.pagehelper.Page;
import com.shop.dto.CustDTO;
import com.shop.frame.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CustMapper extends MyMapper<String, CustDTO> {
//  List에 담는 대신 Page에 담음
  Page<CustDTO> getPage() throws Exception;
}
