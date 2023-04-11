package com.shop.controller;

import com.shop.dto.CustDTO;
import com.shop.dto.NCPDTO;
import com.shop.service.CustService;
import com.shop.util.CFRUtil;
import com.shop.util.FileUploadUtil;
import com.shop.util.OCRUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class NCPController {
  @Value("${imglocation}")
  String imgpath; // c:/projectimg/img

  @RequestMapping("/ocr")
  public String ocr(Model model) {
    model.addAttribute("center", "ocr");
    return "main";
  }

  @RequestMapping("/ocr2")
  public String ocr2(Model model) {
    model.addAttribute("center", "ocr2");
    return "main";
  }

  @RequestMapping("/ocrimpl")
  public String ocrimpl(Model model, NCPDTO ncpdto) {
    String imgname = ncpdto.getImg().getOriginalFilename();
    // 화면에서 파일 올라오면 저장
    FileUploadUtil.saveFile(ncpdto.getImg(), imgpath);
    String result = OCRUtil.getText(imgpath, imgname);

    // AI Service와 연동
    Map<String, String> map = null;
    try {
      map = OCRUtil.getCompanyinfo(result);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    model.addAttribute("imgname", imgname);
    model.addAttribute("name", map.get("name"));
    model.addAttribute("num", map.get("num"));
    model.addAttribute("center", "ocrimpl");

    return "main";
  }


  @RequestMapping("/ocrimpl2")
  public String ocrimpl2(Model model, NCPDTO ncpdto) {
    String imgname = ncpdto.getImg().getOriginalFilename();
    // 화면에서 파일 올라오면 저장
    FileUploadUtil.saveFile(ncpdto.getImg(), imgpath);
    String result = OCRUtil.getText(imgpath, imgname);

    // AI Service와 연동
    Map<String, String> map = null;
    try {
      map = OCRUtil.getCompanyinfo(result);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    model.addAttribute("imgname", imgname);
    model.addAttribute("name", map.get("name"));
    model.addAttribute("num", map.get("num"));
    model.addAttribute("center", "ocrimpl2");

    return "main";
  }

  @RequestMapping("/cfrimpl")
  public String cfrimpl(Model model, String imgname) throws Exception {
    String result = CFRUtil.getText(imgpath, imgname);
    Map<String, String> map = CFRUtil.getFaceInfo(result);

    model.addAttribute("gender", map.get("gender"));
    model.addAttribute("age", map.get("age"));
    model.addAttribute("emotion", map.get("emotion"));
    model.addAttribute("pose", map.get("pose"));
    model.addAttribute("imgname", imgname);

    model.addAttribute("center", "cfrimpl");
    return "main";
  }

}