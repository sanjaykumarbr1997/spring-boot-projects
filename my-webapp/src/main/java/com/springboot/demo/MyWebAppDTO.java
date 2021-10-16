package com.springboot.demo;


public class MyWebAppDTO {
	
	private String name;
	private String age;
	private String mobile;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public MyWebAppDTO(String name, String age, String mobile) {
		super();
		this.name = name;
		this.age = age;
		this.mobile = mobile;
	}
	
	
	

}
