package de.slag.demo.base;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DemoNumberUtilsTest {

	@Test
	void testIsCompleteleyDivisibleBy() {
		assertTrue(DemoNumberUtils.isCompleteleyDivisibleBy(4, 2));
		assertFalse(DemoNumberUtils.isCompleteleyDivisibleBy(5, 2));
		assertThrows(DemoException.class, () -> DemoNumberUtils.isCompleteleyDivisibleBy(4, null));
		assertThrows(DemoException.class, () -> DemoNumberUtils.isCompleteleyDivisibleBy(null, 2));
	}

}