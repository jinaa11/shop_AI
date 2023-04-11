package com.shop.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shop.dto.CartsDTO;
import com.shop.frame.MyService;
import com.shop.mapper.CartsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartsService implements MyService<Integer, CartsDTO> {
  @Autowired
  CartsMapper cartsMapper;

  @Override
  public void register(CartsDTO cartsDTO) throws Exception {
    cartsMapper.insert(cartsDTO);
  }

  @Override
  public void modify(CartsDTO cartsDTO) throws Exception {
    cartsMapper.update(cartsDTO);
  }

  @Override
  public void remove(Integer id) throws Exception {
    cartsMapper.delete(id);
  }

  @Override
  public CartsDTO get(Integer id) throws Exception {
    return cartsMapper.select(id);
  }

  @Override
  public List<CartsDTO> get() throws Exception {
    return cartsMapper.selectall();
  }

  public List<CartsDTO> cartsall(String cust_id) throws Exception {
    return cartsMapper.cartsall(cust_id);
  }

  public Page<CartsDTO> cartsallpage(int pageNo, String id) throws Exception {
    PageHelper.startPage(pageNo, 3);
    return cartsMapper.cartsallpage(id);
  }
}
