package kh.com.kshrd.demostudentdocker.controller;

import kh.com.kshrd.demostudentdocker.dto.request.BookRequest;
import kh.com.kshrd.demostudentdocker.model.Book;
import kh.com.kshrd.demostudentdocker.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody BookRequest request) {
        Book book = bookService.createBook(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{book-id}")
    public ResponseEntity<Book> getBookById(@PathVariable("book-id") Long bookId) {
        Book book = bookService.getBookById(bookId);
        return ResponseEntity.ok(book);
    }

    @PutMapping("/{book-id}")
    public ResponseEntity<Book> updateBookById(@PathVariable("book-id") Long bookId,
                                               @RequestBody BookRequest request) {
        Book book = bookService.updateBookById(bookId, request);
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/{book-id}")
    public ResponseEntity<String> deleteBookById(@PathVariable("book-id") Long bookId) {
        bookService.deleteBookById(bookId);
        return ResponseEntity.ok("Delete book successfully!");
    }

}
