package com.company.OfficialCouponSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OfficialCouponSystemApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(OfficialCouponSystemApplication.class, args);
		System.out.println("start");
	}

}
