package com.shop.carts;

import com.shop.dto.CartsDTO;
import com.shop.dto.CustDTO;
import com.shop.service.CartsService;
import com.shop.service.CustService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SelectAllTests {
	@Autowired
	CartsService service;
	@Test
	void contextLoads() {
		List<CartsDTO> list = null;
		try {
			list = service.get();
			for(CartsDTO c : list) {
				System.out.println(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("입력 시 오류");
		}
	}
}