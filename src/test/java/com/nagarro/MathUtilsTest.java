package com.nagarro;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;

@SuppressWarnings("unused")
class MathUtilsTest {


	private MathUtils mathUtils;
	
	
	@BeforeEach
	void initEach() {
		mathUtils = new MathUtils();
	}

//	class AddTest {
//		@Test
//		void testAddingTwoPositives() {
//			assertEquals(2, mathUtils.add(1, 1), 
//					"Add method should return the sum of two numbers");
//		}
//		
//		@Test
//		void testAddingTwoNegatives() {
//			assertEquals(-2, mathUtils.add(-1, -1), 
//					"Add method should return the sum of two numbers");
//		}
//		
//		@Test
//		void testAddingAPositiveAndANegative() {
//			assertEquals(0, mathUtils.add(-1, 1), 
//					"Add method should return the sum of two numbers");
//		}
//	}
	@Test
	void testadd() {
		assertAll(
				new Executable() {
					public void execute() throws Throwable {
						assertEquals(2, mathUtils.add(1, 1));
					}
				},
				new Executable() {
					public void execute() throws Throwable {
						assertEquals(-2, mathUtils.add(-1, -1));
					}
				},
				new Executable() {
					public void execute() throws Throwable {
						assertEquals(0, mathUtils.add(-1, 1));
					}
				}
				);
	}
	
	
	@Test
	void testsub() {
		assertAll(
				new Executable() {
					public void execute() throws Throwable {
						assertEquals(0, mathUtils.sub(1, 1));
					}
				},
				new Executable() {
					public void execute() throws Throwable {
						assertEquals(0, mathUtils.sub(-1, -1));
					}
				},
				new Executable() {
					public void execute() throws Throwable {
						assertEquals(-2, mathUtils.sub(-1, 1));
					}
				}
				);
	}
	@Test 
	void testMultiply() {
		assertAll(
				new Executable() {
					public void execute() throws Throwable {
						assertEquals(0, mathUtils.mul(1, 0));
					}
				},
				new Executable() {
					public void execute() throws Throwable {
						assertEquals(1, mathUtils.mul(1, 1));
					}
				},
				new Executable() {
					public void execute() throws Throwable {
						assertEquals(6, mathUtils.mul(2, 3));
					}
				}
				);
	}
	
	
	@Test
	void testDivide() {
		assertThrows(ArithmeticException.class, new Executable() {
			public void execute() throws Throwable {
				mathUtils.divi(1, 0); 
			}
		}, 
				"Divide should throw ArithmeticException when denominator is zero");
	}
	

}
