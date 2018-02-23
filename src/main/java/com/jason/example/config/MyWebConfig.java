package com.jason.example.config;

import com.jason.example.interceptor.MyCounterInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.number.NumberStyleFormatter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(value = "com.jason.example")
public class MyWebConfig extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		//commenting next line, setViewClass, as by
		// default the resolver's view is the same
		//viewResolver.setViewClass(JstlView.class);

		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//our customization
		System.out.println("addViewControllers");
	}

	//添加全局formatter
	@Override
	public void addFormatters(FormatterRegistry registry) {
		NumberStyleFormatter numberFormatter = new NumberStyleFormatter();
		numberFormatter.setPattern("#,###,###,###.##");
		registry.addFormatterForFieldType(Number.class, numberFormatter);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MyCounterInterceptor());
	}
}