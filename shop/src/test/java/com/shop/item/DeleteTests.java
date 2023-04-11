package com.shop.item;

import com.shop.service.CustService;
import com.shop.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DeleteTests {
	@Autowired
	ItemService service;
	@Test
	void contextLoads() {
		try {
			service.remove(105);
			System.out.println("삭제 완료");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("삭제 시 오류");
		}
	}
}
