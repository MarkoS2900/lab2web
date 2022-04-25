package mk.finki.ukim.mk.lab2web.web;

import mk.finki.ukim.mk.lab2web.domain.Author;
import mk.finki.ukim.mk.lab2web.domain.Book;
import mk.finki.ukim.mk.lab2web.domain.dto.BookDto;
import mk.finki.ukim.mk.lab2web.service.AuthorService;
import mk.finki.ukim.mk.lab2web.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> findAll() {
        return ResponseEntity.ok().body(this.bookService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(bookService.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.bookService.deleteById(id);
        if (this.bookService.findById(id) == null) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/add")
    public ResponseEntity<Book> save(@RequestBody BookDto bookDto) {
        return this.bookService.save(bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> save(@PathVariable Long id, @RequestBody BookDto bookDto) {
        return this.bookService.edit(id, bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/taken/{id}")
    public ResponseEntity<?> markAsTaken(@PathVariable Long id) {
        Book book = bookService.findById(id);
        bookService.updateAvailableCopies(book.getId(), book.getAvailableCopies() - 1);
        return ResponseEntity.ok().body(book);
    }
    @GetMapping("/authors")
    public List<Author> findAllAuthors() {
        return authorService.findAll();
    }
}
