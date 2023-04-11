package com.shop.item;

import com.shop.dto.CustDTO;
import com.shop.dto.ItemDTO;
import com.shop.service.CustService;
import com.shop.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SelectAllTests {
	@Autowired
	ItemService service;
	@Test
	void contextLoads() {
		List<ItemDTO> list = null;
		try {
			list = service.get();
			for(ItemDTO i : list) {
				System.out.println(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("입력 시 오류");
		}
	}
}