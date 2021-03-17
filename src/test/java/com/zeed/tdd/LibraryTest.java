package com.zeed.tdd;

import com.zeed.tdd.exception.BookNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LibraryTest {

    static BookRepository bookRepository;
    static LibraryService libraryService;

    @BeforeAll
    static void beforeAll() {
        bookRepository = new BookRepositoryStub();
        libraryService = new LibraryService(bookRepository);
    }

    @Test
    @DisplayName("Add book to library")
    public void addBookToLibrary() {
        Book book = new Book();
        book.setTitle("Book Title 1");
        book.setAuthor("Author 1");
        Assertions.assertNotNull(libraryService.addBook(book));
    }

    @Test
    @DisplayName("Get Book by ID")
    public void testGetBookById() throws BookNotFoundException {
        Book book = libraryService.getBookById("stub-id-1");
        Assertions.assertNotNull(book, "Book cannot be null");
        Assertions.assertNotNull(book.getId(), "Book ID cannot be null");
    }

    @Test
    @DisplayName("Should not be able to get book with an ID that does not exist")
    public void getBook() {
        Assertions.assertThrows(BookNotFoundException.class, () ->libraryService.getBookById("invalid-id"));
    }

}
