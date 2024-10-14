package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import com.cg.service.CalculatorService;
public class CalculatorServiceTest {
  // @Test
	@ParameterizedTest
	//@CsvSource( value = {"5,5,10","6,7,13","7,7,14"})
	@CsvFileSource(files = "nums.csv",numLinesToSkip = 1)
	public void testAdd(int x,int y, int z) {
		CalculatorService c=new CalculatorService();
		assertEquals(z, c.add(x, y));
	}
   @Test
  	public void testDiv() {
  		CalculatorService c=new CalculatorService();
  		assertEquals(10, c.div(50, 5));
  	}
   @Test
 	public void testDivNegative() {
 		CalculatorService c=new CalculatorService();
 	    Exception e=assertThrows(RuntimeException.class, ()-> c.div(6, 0));
 	    assertEquals("Cant divide by zero", e.getMessage());
 	}
}
