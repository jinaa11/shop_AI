package com.shop.controller;

import com.shop.dto.NCPDTO;
import com.shop.util.CFRUtil;
import com.shop.util.FileUploadUtil;
import com.shop.util.OCRUtil;
import com.shop.util.WeatherUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class WeatherController {
  @RequestMapping("/weather")
  public String weather(Model model) {
    model.addAttribute("center", "weather");
    return "main";
  }

  @RequestMapping("/weatherimpl")
  public String weatherimpl(Model model, String loc) throws Exception {
    String result = WeatherUtil.getWeatherInfo(loc);
    model.addAttribute("result", result);
    model.addAttribute("center", "weather");
    return "main";
  }
}