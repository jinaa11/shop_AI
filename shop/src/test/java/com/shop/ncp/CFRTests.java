package com.shop.ncp;

import com.shop.util.CFRCUtil;
import com.shop.util.CFRUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class CFRTests {
	@Value("${imglocation}")
	String imgpath;
	@Test
	void contextLoads() throws ParseException {
		String imgname = "jo.jpg";
		String result = CFRUtil.getText(imgpath, imgname);
		System.out.println("result = " + result);

		Map<String, String> map = null;
		try {
			map = CFRUtil.getFaceInfo(result);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		System.out.println("map = " + map);
	}
}
