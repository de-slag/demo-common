package de.slag.demo.base;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public final class DemoNumberUtils {

	private DemoNumberUtils() {

	}

	public static boolean isCompleteleyDivisibleBy(Integer divident, Integer... divisors) {
		Optional.ofNullable(divisors).orElseThrow(() -> new DemoException("divisors is null"));
		List<Integer> asList = Arrays.asList(divisors);
		for (Integer divisor : asList) {
			boolean completeleyDivisibleBy = isCompleteleyDivisibleBy(divident, divisor);
			if (!completeleyDivisibleBy) {
				return false;
			}
		}
		return true;
	}

	public static boolean isCompleteleyDivisibleBy(Integer divident, Integer divisor) {
		Optional.ofNullable(divident).orElseThrow(() -> new DemoException("divident is null"));
		Optional.ofNullable(divisor).orElseThrow(() -> new DemoException("divisor is null"));
		return divident % divisor == 0;
	}

	public static boolean isInteger(BigDecimal bigDecimal) {
		try {
			bigDecimal.intValueExact();
		} catch (ArithmeticException e) {
			// ignored
			return false;
		}
		return true;
	}

}