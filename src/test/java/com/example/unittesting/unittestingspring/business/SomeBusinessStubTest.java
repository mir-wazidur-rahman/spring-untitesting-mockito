package com.example.unittesting.unittestingspring.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.unittesting.unittestingspring.data.SomeDataService;

class SomeDataServiceStub implements SomeDataService {

	@Override
	public int[] retrieveAllData() {
		// TODO Auto-generated method stub
		return new int[] {1,2,3,4};
	}
	
}

class SomeDataServiceEmptyStub implements SomeDataService {

	@Override
	public int[] retrieveAllData() {
		// TODO Auto-generated method stub
		return new int[] {};
	}
	
}

class SomeBusinessStubTest {

	@Test
	void calculateSumUsingDataService_basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceStub());
		int acutalresult = business.calculateSumUsingDataService();
		int expectedResult = 10;
		assertEquals(expectedResult, acutalresult);
	}
	
	@Test
	void calculateSumUsingDataService_emptyArray() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceEmptyStub());
		int acutalresult = business.calculateSumUsingDataService();
		int expectedResult = 0;
		assertEquals(expectedResult, acutalresult);
	}

}
