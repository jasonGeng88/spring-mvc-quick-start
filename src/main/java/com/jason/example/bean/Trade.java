package com.jason.example.bean;

import java.math.BigDecimal;

/**
 * @author gengjie
 * @date 2018/2/22
 */
public class Trade {
	private String buySell;

	private String buyCurrency;

	private String sellCurrency;

	private BigDecimal price;

	public String getBuySell() {
		return buySell;
	}

	public void setBuySell(String buySell) {
		this.buySell = buySell;
	}

	public String getBuyCurrency() {
		return buyCurrency;
	}

	public void setBuyCurrency(String buyCurrency) {
		this.buyCurrency = buyCurrency;
	}

	public String getSellCurrency() {
		return sellCurrency;
	}

	public void setSellCurrency(String sellCurrency) {
		this.sellCurrency = sellCurrency;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Trade{" +
			  "buySell='" + buySell + '\'' +
			  ", buyCurrency='" + buyCurrency + '\'' +
			  ", sellCurrency='" + sellCurrency + '\'' +
			  ", price=" + price +
			  '}';
	}
}
