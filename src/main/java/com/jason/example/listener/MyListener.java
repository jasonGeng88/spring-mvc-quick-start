package com.jason.example.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.RequestHandledEvent;

/**
 * @author gengjie
 * @date 2018/2/22
 */
@Component
public class MyListener {

	@EventListener
	public void handleEvent(RequestHandledEvent e) {
		System.out.println("-- RequestHandledEvent --");
		System.out.println(e);
	}
}
