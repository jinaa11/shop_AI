package com.shop.mapper;

import com.github.pagehelper.Page;
import com.shop.dto.CartsDTO;
import com.shop.frame.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CartsMapper extends MyMapper<Integer, CartsDTO> {
  public List<CartsDTO> cartsall(String cust_id) throws Exception;
  public Page<CartsDTO> cartsallpage(String cust_id) throws Exception;

}
