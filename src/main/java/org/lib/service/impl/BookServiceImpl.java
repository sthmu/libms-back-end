package org.lib.service.impl;

import org.lib.Entity.BookEntity;
import org.lib.dto.Book;
import org.lib.repository.BookRepository;
import org.lib.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
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

    @Override
    public ResponseEntity<String> addAllBooks(Iterable<Book> bookList) {
        try{
        List<BookEntity> entities=new ArrayList<>();
        for(Book bookinLIst:bookList){
            entities.add(modelMapper.map(bookinLIst,BookEntity.class));
        }
        Iterable<BookEntity> response=bookRepository.saveAll(entities);
        return ResponseEntity.ok().body("{\"message\":\"Added All\"}");
    } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"An error occurred while saving\"}");
    }
    }
}



