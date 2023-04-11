package com.shop.cust;

import com.shop.dto.CustDTO;
import com.shop.service.CustService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UpdateTests {
	@Autowired
	CustService custService;
	@Test
	void contextLoads() {
		CustDTO obj = new CustDTO("jina22", "3333", "jina");
		try {
			custService.modify(obj);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("수정 시 오류");
		}
	}
}
