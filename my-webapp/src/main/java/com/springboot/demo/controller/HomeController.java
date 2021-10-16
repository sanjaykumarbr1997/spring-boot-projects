package com.springboot.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.demo.MyWebAppDTO;

@RestController
public class HomeController {
	
	
	
//	@RequestMapping("home")
//	public ModelAndView display(@ModelAttribute MyWebAppDTO webDTO) {
//		return new ModelAndView("home", "obj", webDTO);
	
	@GetMapping("/display")
	public MyWebAppDTO display() {
		return new MyWebAppDTO("Ravi","34","9999999");
		
	}
	
	
	@GetMapping("/displaylist")
	public List<MyWebAppDTO> getList(){
		
		List<MyWebAppDTO> dtoList = new ArrayList<>();
		dtoList.add(new MyWebAppDTO("Sanjay", "44","978787878"));
		dtoList.add(new MyWebAppDTO("Rahul", "24","99999999"));
		dtoList.add(new MyWebAppDTO("Rajiv", "55", "45455"));
		
		return dtoList;
		
	}

}
