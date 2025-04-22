package com.app.J2Dtech.test;

public class Client {
	
	public static void main(String[] args) {
		Payment creditCard = PaymentFactory.getInstanceOfPayment("CreditCard");
		creditCard.makePayment();
		Payment netBanking = PaymentFactory.getInstanceOfPayment("NetBanking");
		netBanking.makePayment();
	}

}
