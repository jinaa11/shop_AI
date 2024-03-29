package com.shop.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shop.dto.MallDTO;
import com.shop.frame.MyService;
import com.shop.mapper.MallMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MallService implements MyService<Integer, MallDTO> {

  @Autowired
  MallMapper mapper;

  @Override
  public void register(MallDTO mallDTO) throws Exception {
    mapper.insert(mallDTO);
  }

  @Override
  public void modify(MallDTO mallDTO) throws Exception {
    mapper.update(mallDTO);
  }

  @Override
  public void remove(Integer id) throws Exception {
    mapper.delete(id);
  }

  @Override
  public MallDTO get(Integer id) throws Exception {
    return mapper.select(id);
  }

  @Override
  public List<MallDTO> get() throws Exception {
    return mapper.selectall();
  }

  public Page<MallDTO> getPage(int pageNo) throws Exception {
    PageHelper.startPage(pageNo, 5);
    return mapper.getPage();
  }
}

