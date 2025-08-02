package kh.com.kshrd.demostudentdocker.repository;

import kh.com.kshrd.demostudentdocker.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
