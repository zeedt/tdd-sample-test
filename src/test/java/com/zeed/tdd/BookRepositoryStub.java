package com.zeed.tdd;

import com.zeed.tdd.exception.BookNotFoundException;

import java.util.HashMap;
import java.util.UUID;

public class BookRepositoryStub implements BookRepository {

    final HashMap<String, Book> bookStore;

    public BookRepositoryStub() {
        this.bookStore = new HashMap<>();
        Book book = new Book();
        book.setId("stub-id-1");
        book.setTitle("Title 1");
        book.setAuthor("Author 1");
        this.bookStore.put("stub-id-1", book);
    }

    @Override
    public Book createBook(Book book) {
        book.setId(UUID.randomUUID().toString());
        bookStore.put(book.getId(), book);
        return book;
    }

    @Override
    public Book getById(String id) throws BookNotFoundException {
        Book book = bookStore.get(id);
        if (book == null)
            throw new BookNotFoundException("Book not found");
        return book;
    }
}
