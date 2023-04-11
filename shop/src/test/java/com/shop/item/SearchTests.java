package com.shop.item;

import com.shop.dto.ItemDTO;
import com.shop.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SearchTests {
	@Autowired
	ItemService service;
	@Test
	void contextLoads() {
		List<ItemDTO> list = null; // 데이터베이스(obj)에서 받을 준비
		try {
			list = service.search("%s%");
			for(ItemDTO obj : list) {
				System.out.println("obj = " + obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("입력 시 오류");
		}
	}
}