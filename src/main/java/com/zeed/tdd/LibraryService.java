package com.zeed.tdd;

import com.zeed.tdd.exception.BookNotFoundException;

public class LibraryService {

    final BookRepository bookRepository;

    public LibraryService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        return bookRepository.createBook(book);
    }

    public Book getBookById(String id) throws BookNotFoundException {
        return bookRepository.getById(id);
    }
}
