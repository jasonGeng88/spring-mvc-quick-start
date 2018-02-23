package com.jason.example.validator;

import com.jason.example.bean.Trade;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author gengjie
 * @date 2018/2/23
 */
public class MyTradeValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz == Trade.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "buySell", "buySell cannot be empty");

		Trade trade = (Trade) target;

		if (trade.getBuyCurrency() != null && trade.getBuyCurrency().length() > 5) {
			errors.rejectValue("buyCurrency", "buyCurrency is too long");
		}
	}
}
