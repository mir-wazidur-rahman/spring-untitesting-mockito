package com.example.unittesting.unittestingspring.business;

import com.example.unittesting.unittestingspring.data.SomeDataService;

public class SomeBusinessImpl {
	
	private SomeDataService someDataService;
	
	
	
	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}

	public int calculateSum(int[] data) {
		int sum = 0;
		for (int val : data) sum += val;
		
		return sum;
	}
	
	public int calculateSumUsingDataService() {
		int sum = 0;
		int[] data  = someDataService.retrieveAllData();
		for (int val : data) sum += val;
		
		return sum;
	}
	
}
