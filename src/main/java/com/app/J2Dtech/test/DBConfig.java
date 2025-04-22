package com.app.J2Dtech.test;

public class DBConfig implements SampleClone{

	String url;
	String env;
	String password;
	String userName;

	public DBConfig(String url, String env, String password, String userName) {
		super();
		this.url = url;
		this.env = env;
		this.password = password;
		this.userName = userName;
	}
	
	
	
	

	@Override
	public DBConfig clone()  {
		return new DBConfig(this.url,this.env,this.password,this.userName);
	}





	@Override
	public String toString() {
		return "DBConfig [url=" + url + ", env=" + env + ", password=" + password + ", userName=" + userName + "]";
	}



	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
