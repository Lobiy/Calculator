package YLobanov;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

class CalculatorTest {
	
	@SuppressWarnings("deprecation")
	@Rule
	public ExpectedException thrown= ExpectedException.none();

	@Test
	void testArabicSum() throws Exception {
		assertEquals("3", Calculator.resolver("1 + 2"));
	}
	
	@Test
	void testArabicSubstract() throws Exception {
		assertEquals("-1", Calculator.resolver("10 - 11"));
	}
	
	@Test
	void testArabicMultiply() throws Exception {
		assertEquals("20", Calculator.resolver("10 * 2"));
	}
	
	@Test
	void testArabicDivision() throws Exception {
		assertEquals("5", Calculator.resolver("10 / 2"));
	}
	
	@Test
	void testRomanSum() throws Exception {
		assertEquals("XI", Calculator.resolver("I + X"));
	}
	
	@Test
	void testRomanSubstract() throws Exception {
		assertEquals("I", Calculator.resolver("X - IX"));
	}
	
	@Test
	void testRomanMultiply() throws Exception {
		assertEquals("XC", Calculator.resolver("X * IX"));
	}
	
	@Test
	void testRomanDivision() throws Exception {
		assertEquals("II", Calculator.resolver("X / V"));
	}
	
	@Test
	public void TestForExceptionArabicDivision(){
	    
	    try {
	    	Calculator.resolver("10 / 0");
	    } catch (Exception e) {
	    	thrown.expect(ArithmeticException.class);
	    }
	    
	}
	
	@Test
	public void TestForExceptionDifferentNumbers(){
	    
	    try {
	    	Calculator.resolver("I + 2");
	    } catch (Exception e) {
	    	thrown.expect(Exception.class);
	    }
	    
	}
	
	@Test
	public void TestForExceptionNegativeRomans(){
	    
	    try {
	    	Calculator.resolver("I - X");
	    } catch (Exception e) {
	    	thrown.expect(Exception.class);
	    }
	    
	}
	
	@Test
	public void TestForExceptionRomanZero(){
	    
	    try {
	    	Calculator.resolver("I / VI");
	    } catch (Exception e) {
	    	thrown.expect(Exception.class);
	    }
	    
	}

}
