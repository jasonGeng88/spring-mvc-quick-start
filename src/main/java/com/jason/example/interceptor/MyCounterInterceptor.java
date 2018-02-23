package com.jason.example.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

/**
 * @author gengjie
 * @date 2018/2/23
 */
@Component
public class MyCounterInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		  throws Exception {
		HttpSession session = request.getSession(true);
		if (session.getAttribute("sessionStartTime") == null) {
			session.setAttribute("sessionStartTime", LocalDateTime.now());
		}
		return true;
	}
}
