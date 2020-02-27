package com.company.OfficialCouponSystem.util;

public class MyExceptions extends Exception{
	
	private String couponDoesNotExistsException = "coupon does not exist";
	private String couponWithTitleAlreadyExistsException = "coupon with this title already exists";

	public MyExceptions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public MyExceptions(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MyExceptions(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public MyExceptions(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public String getCouponDoesNotExistsException() {
		return couponDoesNotExistsException;
	}

	public String getCouponWithTitleAlreadyExistsException() {
		return couponWithTitleAlreadyExistsException;
	}
	
	
	
	
}
