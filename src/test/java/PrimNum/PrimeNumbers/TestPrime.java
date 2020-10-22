package PrimNum.PrimeNumbers;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TestPrime {
	findPrimeNumbers fpn;
	ArrayList<String> actual;
	ArrayList<String> expected;
	
	@Before
	public void setData() {
		fpn = new findPrimeNumbers();
		actual=new ArrayList<String>();
		expected=new ArrayList<String>();
	}
	
	//Verify that the list of Prime numbers between two numbers are displayed
	@Test
	public void TestPrimeRangeValidate() {
		actual.addAll(fpn.calcPrime(2, 12));
		int size=actual.size();
		int num = 0;	
		
		for(int i = 0; i < size; i++) {
			num = Integer.parseInt(actual.get(i));
			for(int j = 2; j <= num/2; ++j) {
				if(num % j == 0) {
					break;
				}
			}
		expected.add(String.valueOf(num));
		}
		assertEquals("Result: ", expected, actual);
	}
	
	// Verify that if Start and End numbers are Prime, they are not omitted
	@Test
	public void TestPrimeStartEndNumValidate() {
		int start = 3;
		int end = 13;
		actual.addAll(fpn.calcPrime(start, end));
		
		int size=actual.size();
		int startNum = 0;	
		int endNum = 0;
		
		startNum = Integer.parseInt(actual.get(0));
		endNum = Integer.parseInt(actual.get(size-1));

		assertEquals("Result: ", startNum, start);
		assertEquals("Result: ", endNum, end);
	}
	
	// Input validation - if anything other than Integer is passed as parameter
	@Test
	public void TestIsInputInteger() {
		assertEquals("Result: ", String.valueOf(fpn.calcPrime(5.46, 14.50)),"[Not an Integer]");
		assertEquals("Result: ", String.valueOf(fpn.calcPrime("10", 13)),"[Not an Integer]");
		assertEquals("Result: ", String.valueOf(fpn.calcPrime(0.05, "21.20")),"[Not an Integer]");
		
	}
	
	// Verify if a number is less than 1
	@Test
	public void TestIsNumLessThanOne() {
		assertEquals("Result: ", String.valueOf(fpn.calcPrime(0, 5)),"[Number less than 1]");
		assertEquals("Result: ", String.valueOf(fpn.calcPrime(-1, 12)),"[Number less than 1]");
		
	}
	
	// Verify if a Prime number is not found in a given range
	@Test
	public void TestPrimeNotFound() {
		assertEquals("Result: ", String.valueOf(fpn.calcPrime(22, 22)),"[No Prime num found]");
		assertEquals("Result: ", String.valueOf(fpn.calcPrime(14, 16)),"[No Prime num found]");
		
	}
	
	// Verify if the Second number is greater than the First
	@Test
	public void TestSecondLessThanFirst() {
		assertEquals("Result: ", String.valueOf(fpn.calcPrime(9, 5)),"[First num less than Second num]");
		assertEquals("Result: ", String.valueOf(fpn.calcPrime(14, 1)),"[First num less than Second num]");
		
	}
	
}
