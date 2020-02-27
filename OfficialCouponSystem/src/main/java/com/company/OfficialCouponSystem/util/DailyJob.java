package com.company.OfficialCouponSystem.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.company.OfficialCouponSystem.beans.Coupon;
import com.company.OfficialCouponSystem.repositories.CouponRepository;

public class DailyJob extends Thread{

	@Autowired
	private CouponRepository couponRepo;
	@Autowired
	private Coupon coupon;
	

	
	public void checkCouponExpiration() {
		while(true) {
			if (new Date().after((coupon.getEndDate()))) {
				couponRepo.delete(coupon);
				try {
					sleep(1000*60*60*24);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
