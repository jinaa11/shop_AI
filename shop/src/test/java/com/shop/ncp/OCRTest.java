package com.shop.ncp;

import com.shop.util.OCRUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OCRTest {
	@Value("${imglocation}")
	String imgpath;
	@Test
	void contextLoads() throws ParseException {
		String imgname1 = "bl02.jpg";
		String imgname2 = "card02.png";

		String result = OCRUtil.getText(imgpath, imgname1);
		System.out.println("result1 = " + result);

		String result2 = OCRUtil.getText(imgpath, imgname2);
		System.out.println("result2 = " + result2);

		JSONParser jsonparser = new JSONParser();
		// 내려온 json String('result')을 자바의 json object으로 변경시켜줌
		JSONObject global = (JSONObject)jsonparser.parse(result);
		// 전체에서 images를 꺼냄
		JSONArray images = (JSONArray) global.get("images");
		// images 배열에서 0번째를 꺼냄 -> object 형태가 됨
		JSONObject jo1 = (JSONObject) images.get(0);

		JSONArray fields = (JSONArray) jo1.get("fields");
		JSONObject obj = (JSONObject) fields.get(0);
		String name = (String)obj.get("inferText");
		System.out.println(name);

		JSONObject title = (JSONObject) jo1.get("title");
		String num = (String)title.get("inferText");
		System.out.println(num);
	}

}
