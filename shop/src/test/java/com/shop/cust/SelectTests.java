package com.shop.cust;

import com.shop.dto.CustDTO;
import com.shop.dto.ItemDTO;
import com.shop.service.CustService;
import com.shop.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SelectTests {
	@Autowired
	CustService service;
	@Test
	void contextLoads() {
		CustDTO obj = null; // 데이터베이스(obj)에서 받을 준비
		try {
			obj = service.get("id01");
			System.out.println("obj = " + obj);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("입력 시 오류");
		}
	}
}
