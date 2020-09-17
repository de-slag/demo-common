package de.slag.demo.base;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DemoNumberUtilsTest {

	@Test
	void testIsCompleteleyDivisibleBy() {
		assertTrue(DemoNumberUtils.isCompleteleyDivisibleBy(4, 2));
		assertFalse(DemoNumberUtils.isCompleteleyDivisibleBy(5, 2));
		assertThrows(DemoException.class, () -> DemoNumberUtils.isCompleteleyDivisibleBy(4, (Integer) null));
		assertThrows(DemoException.class, () -> DemoNumberUtils.isCompleteleyDivisibleBy(null, 2));

		assertTrue(DemoNumberUtils.isCompleteleyDivisibleBy(4, 4, 2));
		assertFalse(DemoNumberUtils.isCompleteleyDivisibleBy(4, 2, 3));
		assertThrows(DemoException.class, () -> DemoNumberUtils.isCompleteleyDivisibleBy(null, 4, 2));
	}
	
	@Test
	void testIsCompleteleyDivisibleByNulls() {		
		assertThrows(DemoException.class, () -> DemoNumberUtils.isCompleteleyDivisibleBy(4, (Integer[]) null));
	}

}