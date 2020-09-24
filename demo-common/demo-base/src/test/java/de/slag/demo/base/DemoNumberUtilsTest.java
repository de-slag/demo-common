package de.slag.demo.base;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class DemoNumberUtilsTest {

	@Test
	void testIsCompleteleyDivisibleBy() {
		assertTrue(BaseNumberUtils.isCompleteleyDivisibleBy(4, 2));
		assertFalse(BaseNumberUtils.isCompleteleyDivisibleBy(5, 2));
		assertThrows(BaseException.class, () -> BaseNumberUtils.isCompleteleyDivisibleBy(4, (Integer) null));
		assertThrows(BaseException.class, () -> BaseNumberUtils.isCompleteleyDivisibleBy(null, 2));

		assertTrue(BaseNumberUtils.isCompleteleyDivisibleBy(4, 4, 2));
		assertFalse(BaseNumberUtils.isCompleteleyDivisibleBy(4, 2, 3));
		assertThrows(BaseException.class, () -> BaseNumberUtils.isCompleteleyDivisibleBy(null, 4, 2));
	}
	
	@Test
	void testIsCompleteleyDivisibleByNulls() {		
		assertThrows(BaseException.class, () -> BaseNumberUtils.isCompleteleyDivisibleBy(4, (Integer[]) null));
	}
	
	@Test
	void testIsInteger() {
		assertTrue(BaseNumberUtils.isInteger(BigDecimal.valueOf(5)));
		assertFalse(BaseNumberUtils.isInteger(BigDecimal.valueOf(2.5)));
		
	}

}