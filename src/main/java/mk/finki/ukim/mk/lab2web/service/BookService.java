package mk.finki.ukim.mk.lab2web.service;

import mk.finki.ukim.mk.lab2web.domain.Author;
import mk.finki.ukim.mk.lab2web.domain.Book;
import mk.finki.ukim.mk.lab2web.domain.dto.BookDto;
import mk.finki.ukim.mk.lab2web.domain.enums.Category;
import mk.finki.ukim.mk.lab2web.repository.AuthorRepository;
import mk.finki.ukim.mk.lab2web.repository.BookRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Book findById(Long id){
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.orElse(null);
    }

    @Transactional
    public Optional<Book> save(String name, Category category, Long authorId, int availableCopies) {
        Author author = authorRepository.findById(authorId).orElse(null);
        this.bookRepository.deleteByName(name);
        Book book = new Book(name, category, author, availableCopies);
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    public Optional<Book> save(BookDto bookDto) {
        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElse(null);

        this.bookRepository.deleteByName(bookDto.getName());
        Book book = new Book(bookDto.getName(), bookDto.getCategory(), author, bookDto.getAvailableCopies());
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    public void deleteById(Long id){
        bookRepository.deleteById(id);
    }

    public Optional<Book> edit(Long id, String name, Category category, Long authorId, int availableCopies) {

        Book book = this.findById(id);

        book.setName(name);
        book.setAvailableCopies(availableCopies);
        book.setCategory(category);

        Author author = authorRepository.findById(authorId).orElse(null);
        book.setAuthor(author);

        this.bookRepository.save(book);
        return Optional.of(book);

    }

    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book = this.bookRepository.findById(id).orElse(null);

        book.setName(bookDto.getName());
        book.setAvailableCopies(bookDto.getAvailableCopies());
        book.setCategory(bookDto.getCategory());

        Author author = this.authorRepository.findById(bookDto.getAuthor()).orElse(null);
        book.setAuthor(author);

        this.bookRepository.save(book);
        return Optional.of(book);
    }


    @Transactional
    public void updateAvailableCopies(Long id,int availableCopies) {
        if(availableCopies >= 0) {
            bookRepository.updateAvailableCopies(id, availableCopies);
        }
    }
}
