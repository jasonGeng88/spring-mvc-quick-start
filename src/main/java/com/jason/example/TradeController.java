package com.jason.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.Logger;

/**
 * @author gengjie
 * @date 2018/2/22
 */
@Controller
@RequestMapping("trades")
public class TradeController {

	private static final Logger LOGGER = Logger.getLogger(TradeController.class.getName());

	@RequestMapping("paramTest")
	public String handleTradeRequest(@RequestParam("buySell") String buySell,
		  @RequestParam("buyCurrency") String buyCurrency, @RequestParam("sellCurrency") String sellCurrency,
		  Model map) {
		String msg = String
			  .format("trade request. buySell: %s, buyCurrency: %s, sellCurrency: %s", buySell, buyCurrency,
					sellCurrency);
		LOGGER.info(msg);
		map.addAttribute("msg", msg);
		return "my-page2";
	}

	@RequestMapping
	public String handleTradeRequest(Trade trade, Model model) {
		String msg = String.format("trade request. buySell: %s, buyCurrency: %s, sellCurrency: %s", trade.getBuySell(),
			  trade.getBuyCurrency(), trade.getSellCurrency());
		LOGGER.info(msg);
		model.addAttribute("msg", msg);
		return "my-page2";
	}

	@RequestMapping("pathTest/{buySell}/{buyCurrency}/{sellCurrency}")
	public String handleTradeRequest2(@PathVariable("buySell") String buySell,
		  @PathVariable("buyCurrency") String buyCurrency, @PathVariable("sellCurrency") String sellCurrency,
		  Model map) {
		String msg = String
			  .format("trade request. buySell: %s, buyCurrency: %s, sellCurrency: %s", buySell, buyCurrency,
					sellCurrency);
		LOGGER.info(msg);
		map.addAttribute("msg", msg);
		return "my-page2";
	}

	// Binding Request Parameters and Path Variables to Java Backing Objects. In fact the Model object is already populated with our binding object before the handler method is called by Spring.
	@RequestMapping("{buySell}/{buyCurrency}/{sellCurrency}")
	public String handleTradeRequest3(Trade trade, Model model) {
		String msg = String.format("trade request. buySell: %s, buyCurrency: %s, sellCurrency: %s", trade.getBuySell(),
			  trade.getBuyCurrency(), trade.getSellCurrency());
		LOGGER.info(msg);
		model.addAttribute("msg", msg);
		return "my-page2";
	}
}
