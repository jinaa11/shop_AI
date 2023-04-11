package com.shop.mapper;

import com.shop.dto.MenuDTO;
import com.shop.frame.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MenuMapper extends MyMapper<Integer, MenuDTO> {
}
