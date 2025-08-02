package kh.com.kshrd.demostudentdocker.service;

import kh.com.kshrd.demostudentdocker.dto.request.BookRequest;
import kh.com.kshrd.demostudentdocker.model.Book;

import java.util.List;

public interface BookService {

    Book createBook(BookRequest request);

    List<Book> getAllBooks();

    Book getBookById(Long bookId);

    Book updateBookById(Long bookId, BookRequest request);

    void deleteBookById(Long bookId);

}
