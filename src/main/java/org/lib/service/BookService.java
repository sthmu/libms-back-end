package org.lib.service;

import org.lib.Entity.BookEntity;
import org.lib.dto.Book;

import java.util.List;

public interface BookService {
    void addBook(Book book);

    List<BookEntity> getBooks();

    boolean deleteBook(Long id);

    Book getBookById(Long id);
}
