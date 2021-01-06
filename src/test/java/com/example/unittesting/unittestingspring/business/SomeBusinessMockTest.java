package com.example.unittesting.unittestingspring.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.unittesting.unittestingspring.data.SomeDataService;


@ExtendWith(MockitoExtension.class)
public class SomeBusinessMockTest {

	@InjectMocks
	SomeBusinessImpl business = new SomeBusinessImpl();
	
	@Mock
	SomeDataService dataServiceMock;
	
//	@BeforeEach
//	public void before() {
//		business.setSomeDataService(dataServiceMock);
//	}
	
	@Test
	void calculateSumUsingDataService_basic() {
		//retrieveAllData should give new int[]{1,2,3,4}
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3,4});
		assertEquals(10, business.calculateSumUsingDataService());
	}
	
	@Test
	void calculateSumUsingDataService_emptyArray() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(0, business.calculateSumUsingDataService());
	}

	
}
