package com.shop.controller;

import com.github.pagehelper.PageInfo;
import com.shop.dto.CartsDTO;
import com.shop.service.CartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartsController {
  String dir = "/cart/";

  @Autowired
  CartsService service;

  // left와 center 영역 변경
  //@RequestMapping("")
  public String cart(Model model, String id) {
    // left가 없으면 main의 left를 붙임
    model.addAttribute("center", dir + "center");
    model.addAttribute("left", dir + "left");
    return "main";
  }

  @RequestMapping("/addcartimpl")
  public String addcartimpl(Model model, CartsDTO carts) throws Exception {
    System.out.println(carts);
     service.register(carts);
    return "redirect:/cart?id=" +carts.getCust_id();
  }

  @GetMapping("")
  public String getpage(@RequestParam(required = false, defaultValue = "1") int pageNum, Model model, String id) throws Exception {
    List<CartsDTO> mycarts = null;
    mycarts = service.cartsall(id);
    PageInfo<CartsDTO> p = new PageInfo<>(service.cartsallpage(pageNum, id), 3);
    model.addAttribute("carts", p);
    model.addAttribute("mycarts", mycarts);
    model.addAttribute("center", dir + "getpage");

    return "/main";
  }

  @RequestMapping("/deleteimpl")
  public String deleteimpl(Model model, int id, String cid) throws Exception {
    try {
      service.remove(id);
    } catch (Exception e) {
     e.printStackTrace();
    }
    return "redirect:/cart?id="+ cid;
  }
}
