package com.shop.ncp;

import com.shop.util.CFRCUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CFRCTests {
	@Value("${imglocation}")
	String imgpath;
	@Test
	void contextLoads() throws Exception {
		String imgname = "kang01.jpg";
		String result = CFRCUtil.getText(imgpath, imgname);
		System.out.println("result = " + result);

		String faceInfo = CFRCUtil.getFaceInfo(result);
		System.out.println("faceInfo = " + faceInfo);
	}

}
