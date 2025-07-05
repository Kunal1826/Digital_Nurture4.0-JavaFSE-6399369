package com.cognizant.LibraryManagement;


import com.cognizant.LibraryManagement.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		BookService bookService = ctx.getBean(BookService.class);
		bookService.addBook();

	}

}
