package de.workshops.bookshelf.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class BookService {

    private final BookRepository bookRepository;

    List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    Book getSingleBook(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }
}
