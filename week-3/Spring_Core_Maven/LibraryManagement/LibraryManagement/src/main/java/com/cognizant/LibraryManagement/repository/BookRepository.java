package com.cognizant.LibraryManagement.repository;

import org.springframework.stereotype.Repository;

@Repository //using for exercise 6(annotation configuration)
public class BookRepository {
    public void save() {
        System.out.println("by Annotations");//using for exercise 6(annotation configuration)
        System.out.println("BookRepository: saving book to DB.");
    }
}
