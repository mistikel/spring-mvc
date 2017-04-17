package com.mitrais.trainee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MvcspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcspringApplication.class, args);
	}
	@Bean
	public CommandLineRunner printAll(HelloWorld component){
		// return args -> {
		// 	System.out.println("Hello World");
		// 	String[] beanNames = ctx.getBeanDefinitionNames();
		// 	for(String beanName : beanNames){
		// 		System.out.println(beanName);
		// 	}
		// };
		return args -> {
			component.setMessage("Hello Component");
			component.printMessage();
		};
	}
}
