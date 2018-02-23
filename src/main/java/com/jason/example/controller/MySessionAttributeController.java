package com.jason.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * @author gengjie
 * @date 2018/2/22
 */
@Controller
@RequestMapping("/sessionAttribute")
@SessionAttributes("random")
public class MySessionAttributeController {

	@ModelAttribute("random")
	public int attributeRandom(){
		return new Random().nextInt(100);
	}

	@RequestMapping("/test")
	public String test(@ModelAttribute("random") int random,
		  @SessionAttribute("sessionStartTime") LocalDateTime sessionStartTime, Model model){
		System.out.println(sessionStartTime);
		model.addAttribute("msg", random);
		//return  the name of our jsp page.
		return "my-page";
	}
}
