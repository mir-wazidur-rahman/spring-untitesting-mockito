package com.example.unittesting.unittestingspring.business;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.*;

class ListMockTest {

	List<String> mock = mock(List.class);
	
	@Test
	void size_basic() {
		
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}
	
	@Test
	void returnDifferent() {
		
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());
	}
	
	@Test
	public void returnWithParameters() {
		when(mock.get(0)).thenReturn("test has passed");
		assertEquals("test has passed", mock.get(0));
		assertEquals(null, mock.get(1));
	}
	
	@Test
	public void returnWithGenericParameters() {
		when(mock.get(anyInt())).thenReturn("test has passed");
		assertEquals("test has passed", mock.get(1));
//		assertEquals(null, mock.get(1));
	}

	
	@Test
	public void verificationBasics() {
		//SUT
		String value = mock.get(0);
		String value2 = mock.get(1);
		
		//verify
		verify(mock).get(0);
		verify(mock, times(2)).get(anyInt());
		verify(mock, atLeast(2)).get(anyInt());
		verify(mock, atMost(2)).get(anyInt());
		verify(mock, never()).get(2);
	}
	
	@Test
	public void argumentCapturing() {
		//SUT
		mock.add("SomeString");
		
		//verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());
		
		assertEquals("SomeString", captor.getValue());
	}
	
	@Test
	public void multipleArgumentCapturing() {
		//SUT
		mock.add("SomeString");
		mock.add("SomeString2");
		
		//verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock, times(2)).add(captor.capture());
		
		assertEquals("SomeString", captor.getAllValues().get(0));
		assertEquals("SomeString2", captor.getAllValues().get(1));
	}
	
	@Test
	public void mocking() {
		ArrayList<String> arrayListMock = mock(ArrayList.class);
		
		System.out.println(arrayListMock.get(0));//null
		System.out.println(arrayListMock.size());//0
		arrayListMock.add("Test1");
		arrayListMock.add("Test2");
		System.out.println(arrayListMock.size());
		when(arrayListMock.size()).thenReturn(5);
		System.out.println(arrayListMock.size());
	}
	
	@Test
	public void spying() {
		ArrayList<String> arrayListSpy = spy(ArrayList.class);
		arrayListSpy.add("Test0");
		System.out.println(arrayListSpy.get(0));//null
		System.out.println(arrayListSpy.size());//0
		arrayListSpy.add("Test1");
		arrayListSpy.add("Test2");
		System.out.println(arrayListSpy.size());
		when(arrayListSpy.size()).thenReturn(5);
		System.out.println(arrayListSpy.size());
		
		arrayListSpy.add("Test3");
		System.out.println(arrayListSpy.size());
	}
}
