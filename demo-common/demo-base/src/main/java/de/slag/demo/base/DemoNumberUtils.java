package de.slag.demo.base;

import java.util.Optional;

public final class DemoNumberUtils {

	private DemoNumberUtils() {

	}

	public static boolean isCompleteleyDivisibleBy(Integer divident, Integer divisor) {
		Optional.ofNullable(divident).orElseThrow(() -> new DemoException("divident is null"));
		Optional.ofNullable(divisor).orElseThrow(() -> new DemoException("divisor is null"));

		return divident % divisor == 0;
	}

}