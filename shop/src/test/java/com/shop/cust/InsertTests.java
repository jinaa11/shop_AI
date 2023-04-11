package com.shop.cust;

import com.shop.dto.CustDTO;
import com.shop.service.CustService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InsertTests {
	@Autowired
	CustService custService;
	@Test
	void contextLoads() {
		CustDTO obj = new CustDTO("id15", "pwd10", "james");
		try {
			custService.register(obj);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("입력 시 오류");
		}
	}
}
