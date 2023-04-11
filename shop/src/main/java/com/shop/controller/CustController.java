package com.shop.controller;

import com.github.pagehelper.PageInfo;
import com.shop.dto.CustDTO;
import com.shop.service.CustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/cust")
public class CustController {
  String dir = "/cust/";

  @Autowired
  CustService service;

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

  @RequestMapping("/addimpl")
  public String addimpl(Model model, CustDTO cust) {
    try {
      service.register(cust);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return "redirect:/cust/getpage";
  }

  @RequestMapping("/get")
  public String get(Model model) {
    List<CustDTO> list = null;
    try {
      list = service.get();
      model.addAttribute("clist", list);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    model.addAttribute("left", dir + "left");
    model.addAttribute("center", dir + "get");

    return "main";
  }

  @GetMapping("/getpage")
  public String getpage(@RequestParam(required = false, defaultValue = "1") int pageNum, Model model) throws Exception {
    // paging 처리할 때는 PageInfo에 담음
    PageInfo<CustDTO> p = new PageInfo<>(service.getPage(pageNum), 8);
    model.addAttribute("users", p);
    model.addAttribute("left", dir+"left");
    model.addAttribute("center", dir+"getpage");

    return "/main";
  }

  @RequestMapping("/detail")
  public String detail(Model model, String id) {
    CustDTO obj = null;
    try {
      obj = service.get(id);
      model.addAttribute("dcust", obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    model.addAttribute("left", dir + "left");
    model.addAttribute("center", dir + "detail");

    return "main";
  }

  @RequestMapping("/updateimpl")
  public String updateimpl(Model model, CustDTO cust) {
    try {
      service.modify(cust);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return "redirect:/cust/detail?id=" + cust.getId();
  }

  @RequestMapping("/deleteimpl")
  public String deleteimpl(Model model, String id) {
    try {
      service.remove(id);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return "redirect:/cust/getpage";
  }
}
