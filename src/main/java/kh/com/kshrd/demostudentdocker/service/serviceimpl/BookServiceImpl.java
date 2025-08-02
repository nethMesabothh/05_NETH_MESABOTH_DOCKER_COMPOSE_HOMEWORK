package kh.com.kshrd.demostudentdocker.service.serviceimpl;

import kh.com.kshrd.demostudentdocker.dto.request.BookRequest;
import kh.com.kshrd.demostudentdocker.model.Book;
import kh.com.kshrd.demostudentdocker.repository.BookRepository;
import kh.com.kshrd.demostudentdocker.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book createBook(BookRequest request) {
        Book book = Book.builder()
                .title(request.getTitle())
                .author(request.getAuthor())
                .description(request.getDescription())
                .build();
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow();
    }

    @Override
    public Book updateBookById(Long bookId, BookRequest request) {
        Book book = Book.builder()
                .id(bookId)
                .title(request.getTitle())
                .author(request.getAuthor())
                .description(request.getDescription())
                .build();
        return bookRepository.save(book);
    }

    @Override
    public void deleteBookById(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
