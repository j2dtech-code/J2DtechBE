package com.app.J2Dtech.test;

public class PaymentFactory {
	
	public static Payment getInstanceOfPayment(String type) {
		if(type.equals("CreditCard")) {
			return new CreditCard();
		} else if(type.equals("NetBanking")) {
			return new NetBanking();
		} else {
			return null;
		}
	}

}
