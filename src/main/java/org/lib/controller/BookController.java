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


    //@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getall")
    public Iterable<BookEntity> getBooks(){return bookService.getBooks();}

    @GetMapping("/get/{id}")
    public Book getBook(@PathVariable Long id){
        return bookService.getBookById(id);
    }

    //@CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteBook(@PathVariable Long id){
         return bookService.deleteBook(id)?ResponseEntity.ok().body("{\"message\": \"Deleted\"}"):
                 ResponseEntity.notFound().build();
    }
    @GetMapping("search/{id}")
    public Book getBookById(@PathVariable Long id){
        return bookService.getBookById(id);

    }
    @PostMapping("/addall")
    public ResponseEntity<String> addAll(@RequestBody Iterable<Book> bookList){
        return bookService.addAllBooks(bookList);
    }

    @DeleteMapping("/deleteall")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAll(){
         bookService.deleteAll();
    }


}
