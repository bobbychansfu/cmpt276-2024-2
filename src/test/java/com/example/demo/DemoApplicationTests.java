package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.models.Products;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void buyProductTest() {
		Products prod = new Products(12.5, 10);
		prod.buyProduct(2);
		assertEquals(8,prod.getInven());
		prod.buyProduct(3);
		assertEquals(5,prod.getInven());
		// test transaction
	}

	@Test
	void purchaseNegativeProducts() {
		try {
			Products prod = new Products(12.5, 10);
			prod.buyProduct(-2);
			fail();
		} catch (IllegalArgumentException e) {
			
		}
		
	}

}