package com.shop.carts;

import com.shop.dto.CartsDTO;
import com.shop.dto.ItemDTO;
import com.shop.service.CartsService;
import com.shop.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UpdateTests {
	@Autowired
	CartsService service;
	@Test
	void contextLoads() {
		CartsDTO obj = new CartsDTO(116, null, 106, 70, null);
		try {
			service.modify(obj);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("수정 시 오류");
		}
	}
}
