package com.ixo.movieinfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;




class IxoMovieInfoApplicationTests {

	String exceptedName = "Miku";
	
	@BeforeAll
	public static void init() {
		System.out.println("This will call once before all method.");
	}
	
	@BeforeEach
	public void beforeEachTest() {
		System.out.println("This will run before each Test case.");
	}
	
	@Test
	@DisplayName("First Test Method")
//	@Timeout(value = 2, unit = TimeUnit.SECONDS)
	public void checkNameTest() throws InterruptedException {
		System.out.println("Inside first test case");
		assertEquals(exceptedName, "Miku");
//		Thread.sleep(3000);
	}
	
	@Test
	public void checkIntValue() {
		
		System.out.println("Inside second test case");
		int a = 6;
		int b = 10;
		
		int expectedResult = 16;
		
		assertEquals(expectedResult, a + b);
				
	}
	
	@AfterAll
	public static void cleanUp() {
		System.out.println("This will call after all test cases");
	}

}
