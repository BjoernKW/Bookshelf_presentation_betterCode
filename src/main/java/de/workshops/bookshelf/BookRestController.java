package de.workshops.bookshelf;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookRestController {


    @GetMapping
    public String getAllBooks() {
        return "Some string";
    }

    @GetMapping("/{isbn}")
    public String getSingleBook(@PathVariable String isbn) {
        return isbn;
    }
}
