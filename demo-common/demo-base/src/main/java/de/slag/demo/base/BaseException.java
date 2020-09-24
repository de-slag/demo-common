package de.slag.demo.base;

public class BaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BaseException(String s) {
		super(s);
	}
	
	public BaseException(Throwable t) {
		super(t);
	}

}