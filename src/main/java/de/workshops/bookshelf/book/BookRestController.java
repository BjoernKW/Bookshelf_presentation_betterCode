package de.workshops.bookshelf.book;

import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
@Validated
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:3000" })
public class BookRestController {

    private final BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{isbn}")
    public Book getSingleBook(@PathVariable @NotBlank String isbn) {
        return bookService.getSingleBook(isbn);
    }
}
