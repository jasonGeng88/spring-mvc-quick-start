package com.jason.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author gengjie
 * @date 2018/2/22
 */
@Controller
@RequestMapping("/modelAttribute")
public class MyModelAttributeController {

	@ModelAttribute("a")
	public String attributeA(){
		return "attributeA";
	}

	@RequestMapping("/test")
	@ResponseBody
	public String test(@ModelAttribute("a") String a, Model model){
		System.out.println(model);
		return a;
	}
}
