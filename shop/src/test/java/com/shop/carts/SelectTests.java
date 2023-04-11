package com.shop.carts;

import com.shop.dto.CartsDTO;
import com.shop.dto.ItemDTO;
import com.shop.service.CartsService;
import com.shop.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SelectTests {
	@Autowired
	CartsService service;
	@Test
	void contextLoads() {
		CartsDTO obj = null; // 데이터베이스(obj)에서 받을 준비
		try {
			obj = service.get(116);
			System.out.println("obj = " + obj);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("입력 시 오류");
		}
	}
}
