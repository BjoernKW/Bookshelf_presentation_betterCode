package de.workshops.bookshelf.book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    public Book getSingleBook(@PathVariable @NotBlank @Size(min = 10) String isbn) {
        return bookService.getSingleBook(isbn);
    }

    // Uncomment this method to see the effect of the @ExceptionHandler annotation
    // in conjunction with theProblemDetail annotation.
    /*
    @ExceptionHandler(ConstraintViolationException.class)
    public ProblemDetail error(ConstraintViolationException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
        problemDetail.setTitle("Invalid input");
        problemDetail.setType(URI.create("http://localhost:8080/constraint_violation_exception.html"));
        problemDetail.setProperty("timestamp", Instant.now());

        return problemDetail;
    }
    */
}
