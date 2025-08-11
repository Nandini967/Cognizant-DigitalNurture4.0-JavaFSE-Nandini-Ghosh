package com.library.service;

import com.library.repository.BookRepository;
import com.library.utility.LoggerUtility;

public class BookService {
    private BookRepository bookRepository;
    private LoggerUtility logger;

    // Constructor injection for LoggerUtility
    public BookService(LoggerUtility logger) {
        this.logger = logger;
    }

    // Setter injection for BookRepository
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void serve() {
        logger.log("BookService is starting...");
        System.out.println("BookService is active.");
        bookRepository.printRepo();
    }
}
