package com.jason.example.controller;

import com.jason.example.bean.Trade;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.format.number.NumberStyleFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * @author gengjie
 * @date 2018/2/23
 */
@Controller
@RequestMapping(value = "/initBinder")
public class MyInitBinderController {

	@InitBinder("msg")
	public void customizeBinding1(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor("---", true));
	}

	@InitBinder("path")
	public void customizeBinding2(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor("--", true));
	}

	@InitBinder
	public void customizeBinding3(WebDataBinder binder) {
		NumberStyleFormatter numberFormatter = new NumberStyleFormatter();
		numberFormatter.setPattern("#,###,###,###.##");
		binder.addCustomFormatter(numberFormatter, "price");
	}

	//	RequestParam, PathVariable 参数受到 initBinder 的修改
	@RequestMapping(value = "/test1/{path}", method = RequestMethod.GET)
	public String test1(@PathVariable(value = "path") String path, @RequestParam("msg") String msg, Model model) {
		System.out.println("msg:" + msg);
		System.out.println("path:" + path);
		model.addAttribute("msg", String.format("msg:%s, path:%s", msg, path));
		return "my-page";
	}

	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public String test2(Model model) {
		//不会受 initBinder 影响
		Trade trade = new Trade();
		trade.setPrice(new BigDecimal(1231231));
		model.addAttribute("trade", trade);
		return "trade-bind";
	}
}
