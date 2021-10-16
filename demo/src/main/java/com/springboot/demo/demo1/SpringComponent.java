package com.springboot.demo.demo1;

import org.springframework.stereotype.Component;

@Component("scomponent")
public class SpringComponent {
	public String getMMessage() {
		return "hello fab";
	}

}
