package com.app.J2Dtech.test;

public class PrototypeExmaple {

	public static void main(String[] args) throws CloneNotSupportedException {
	 DBConfig d1=new DBConfig("test.com", "test", "sagar", "sagar@123");
	 
	 DBConfig d2 = (DBConfig) d1.clone();
	 d2.setEnv("UAT");
	 d2.setUrl("UAT.com");
//	 DBConfig d2=new DBConfig("Uat.com", "UAT", "sagar", "sagar@123");
	 System.out.println(d1);
	 System.out.println(d2);

	}

}
