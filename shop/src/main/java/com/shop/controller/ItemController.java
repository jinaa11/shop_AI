package com.shop.controller;

import com.github.pagehelper.PageInfo;
import com.shop.dto.CustDTO;
import com.shop.dto.ItemDTO;
import com.shop.dto.MallDTO;
import com.shop.service.ItemService;
import com.shop.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {
  String dir = "/item/";
  @Value("${imglocation}")
  String custdir;

  @Autowired
  ItemService service;

  // left와 center 영역 변경
  @RequestMapping("")
  public String cust(Model model) {
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

  @RequestMapping("/get")
  public String get(Model model) {
    try {
      List<ItemDTO> itemList = service.get();
      model.addAttribute("itemList", itemList);
    } catch (Exception e) {
      e.printStackTrace();
    }
    model.addAttribute("left", dir + "left");
    model.addAttribute("center", dir + "get");
    return "main";
  }

  @GetMapping("/getpage")
  public String getPage(@RequestParam(required = false, defaultValue = "1") int pageNum, Model model) throws Exception {
    PageInfo<ItemDTO> p = new PageInfo<>(service.getPage(pageNum), 5);
    model.addAttribute("items", p);
    model.addAttribute("left", dir + "left");
    model.addAttribute("center", dir + "getpage");

    return "main";
  }

  @RequestMapping("/addimpl")
  public String addimpl(Model model, ItemDTO obj) {
    // obj : price, name, img
    // img에서 이름을 꺼내 객체 생성
    String imgname = obj.getImg().getOriginalFilename();
    obj.setImgname(imgname);

    try {
      // 서버에 업로드 된 이미지 저장
      FileUploadUtil.saveFile(obj.getImg(), custdir);
      service.register(obj);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "redirect:getpage";
  }

  @RequestMapping("/updateimpl")
  public String updateimpl(Model model, ItemDTO obj) throws Exception {
    System.out.println("obj = " + obj);

    // 새 이미지가 없으면
    if (obj.getImg().getOriginalFilename().equals("")) {
      // 기존 이미지 이름으로 update
      service.modify(obj);
    } else {
      String newimgname = obj.getImg().getOriginalFilename();
      // 새 이미지 저장
      FileUploadUtil.saveFile(obj.getImg(), custdir);
      // 새 이미지 이름으로 update
      obj.setImgname(newimgname);
      service.modify(obj);
    }
    return "redirect:/item/detail?id=" + obj.getId();
  }

  @RequestMapping("/deleteimpl")
  public String deleteimpl(Model model, int id) {
    try {
      service.remove(id);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return "redirect:getpage";
  }

  @RequestMapping("/detail")
  public String detail(Model model, int id) {
    ItemDTO obj = null;
    try {
      obj = service.get(id);
      model.addAttribute("ditem", obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    model.addAttribute("left", dir + "left");
    model.addAttribute("center", dir + "detail");

    return "main";
  }
  @RequestMapping("/addcart")
  public String addcart(Model model, int id) {
    ItemDTO obj = null;
    try {
      obj = service.get(id);
      model.addAttribute("ditem", obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    model.addAttribute("left", dir + "left");
    model.addAttribute("center", dir + "addcart");

    return "main";
  }
}