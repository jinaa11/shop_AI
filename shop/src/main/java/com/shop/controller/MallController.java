package com.shop.controller;

import com.github.pagehelper.PageInfo;
import com.shop.dto.MallDTO;
import com.shop.service.MallService;
import com.shop.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/mall")
public class MallController {
  String dir = "/mall/";

  @Value("${imglocation}")
  String custdir;

  @Autowired
  MallService service;

  // left와 center 영역 변경
  @RequestMapping("")
  public String mall(Model model) {
    model.addAttribute("left", dir + "left");
    model.addAttribute("center", dir + "center");
    return "main";
  }

  @RequestMapping("/add")
  public String add(Model model) {
    model.addAttribute("left", dir + "left");
    model.addAttribute("center", dir + "add");
    return "main";
  }

  @GetMapping("/getpage")
  public String getpage(@RequestParam(required = false, defaultValue = "1") int pageNum, Model model) throws Exception {
    PageInfo<MallDTO> p = new PageInfo<>(service.getPage(pageNum), 5);
    model.addAttribute("mall", p);
    model.addAttribute("left", dir + "left");
    model.addAttribute("center", dir + "getpage");

    return "/main";
  }

  @RequestMapping("/detail")
  public String detail(Model model, int id) {
    MallDTO obj = null;
    try {
      obj = service.get(id);
      model.addAttribute("dmall", obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    model.addAttribute("left", dir + "left");
    model.addAttribute("center", dir + "detail");

    return "main";
  }

  @RequestMapping("/addimpl")
  public String addimpl(Model model, MallDTO obj) {
    System.out.println("입력받은 내용 :" + obj);
    if (obj.getImg().isEmpty()) {
      obj.setImgname("default.jpg");
    } else {
      String imgname = obj.getImg().getOriginalFilename();
      obj.setImgname(imgname);
    }
    obj.setRdate(LocalDateTime.now());
    System.out.println("입력받은 내용에 추가한 내용 :" + obj);
    try {
      FileUploadUtil.saveFile(obj.getImg(), custdir);
      service.register(obj);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "redirect:getpage";
  }

  @RequestMapping("/updateimpl")
  public String updateimpl(Model model, MallDTO mall) throws Exception {
    if(mall.getImg().getOriginalFilename().equals("")) {
      service.modify(mall);
    } else {
      String newimgname = mall.getImg().getOriginalFilename();
      FileUploadUtil.saveFile(mall.getImg(), custdir);
      mall.setImgname(newimgname);
      service.modify(mall);
    }
    return "redirect:/mall/detail?id=" + mall.getId();
  }

  @RequestMapping("/deleteimpl")
  public String deleteimpl(Model model, int id) {
    try {
      service.remove(id);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return "redirect:/mall/getpage";
  }
}