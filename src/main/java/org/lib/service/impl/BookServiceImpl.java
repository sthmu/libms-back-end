package org.lib.service.impl;

import org.lib.Entity.BookEntity;
import org.lib.dto.Book;
import org.lib.repository.BookRepository;
import org.lib.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    ModelMapper modelMapper;

    @Bean
    public void setup() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public void addBook(Book book) {
        BookEntity entity = modelMapper.map(book, BookEntity.class);
        bookRepository.save(entity);
    }

    @Override
    public List<BookEntity> getBooks() {
        return (List<BookEntity>) bookRepository.findAll();
    }


    @Override
    public boolean deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Book getBookById(Long id) {
        Optional<BookEntity> byId=bookRepository.findById(id);
        return modelMapper.map(byId,Book.class);
    }
}



