package com.shop.item;

import com.shop.dto.CustDTO;
import com.shop.dto.ItemDTO;
import com.shop.service.CustService;
import com.shop.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UpdateTests {
	@Autowired
	ItemService service;
	@Test
	void contextLoads() {
		ItemDTO obj = new ItemDTO(106, "shirt106", 30000, "shirt.jpg", null, null);
		try {
			service.modify(obj);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("수정 시 오류");
		}
	}
}
