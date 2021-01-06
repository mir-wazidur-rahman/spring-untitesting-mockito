package com.example.unittesting.unittestingspring.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SomeBusinessTest {

	@Test
	void calculateSum_basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int acutalresult = business.calculateSum(new int[] {1,2,3,4});
		int expectedResult = 10;
		assertEquals(expectedResult, acutalresult);
	}
	
	@Test
	void calculateSum_emptyArray() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int acutalresult = business.calculateSum(new int[] {});
		int expectedResult = 0;
		assertEquals(expectedResult, acutalresult);
	}

}
