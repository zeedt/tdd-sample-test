package com.zeed.tdd;

import com.zeed.tdd.exception.BookNotFoundException;

public interface BookRepository {

    Book createBook(Book book);

    Book getById(String id) throws BookNotFoundException;
}
