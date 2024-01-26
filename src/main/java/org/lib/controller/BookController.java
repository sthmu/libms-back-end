package org.lib.controller;

import org.lib.Entity.BookEntity;
import org.lib.dto.Book;
import org.lib.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
        public void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }


    @GetMapping("/get")
    public Iterable<BookEntity> getBooks(){return bookService.getBooks();}


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteBook(@PathVariable Long id){
         return bookService.deleteBook(id)?ResponseEntity.ok("Deleted"):
                 ResponseEntity.notFound().build();
    }


    @GetMapping("search/{id}")
    public Book getBookById(@PathVariable Long id){
        return bookService.getBookById(id);

    }

}
