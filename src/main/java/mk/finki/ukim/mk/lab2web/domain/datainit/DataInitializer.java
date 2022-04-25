package mk.finki.ukim.mk.lab2web.domain.datainit;

import mk.finki.ukim.mk.lab2web.domain.Author;
import mk.finki.ukim.mk.lab2web.domain.Book;
import mk.finki.ukim.mk.lab2web.domain.Country;
import mk.finki.ukim.mk.lab2web.domain.enums.Category;
import mk.finki.ukim.mk.lab2web.repository.AuthorRepository;
import mk.finki.ukim.mk.lab2web.repository.BookRepository;
import mk.finki.ukim.mk.lab2web.repository.CountryRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public DataInitializer(BookRepository bookRepository, AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @PostConstruct
    public void initData() {
        Country country1 = new Country("Serbia","Europe");
        Country country2 = new Country("Australia","Australia");
        Country country3 = new Country("Japan","Asia");
        Country country4 = new Country("DR Kongo","Africa");
        Country country5 = new Country("Canada","North America");
        Country country6 = new Country("Brazil","South America");
        countryRepository.save(country1);
        countryRepository.save(country2);
        countryRepository.save(country3);
        countryRepository.save(country4);
        countryRepository.save(country5);
        countryRepository.save(country6);
        Author author1 = new Author("Marko","Stanojevic",country1);
        Author author2 = new Author("John","Stallone",country2);
        Author author3 = new Author("Jackie","Chan",country3);
        Author author4 = new Author("Shiba","Shinsu",country4);
        Author author5 = new Author("David","Gates",country5);
        Author author6 = new Author("Beatrice","Lopez",country6);
        authorRepository.save(author1);
        authorRepository.save(author2);
        authorRepository.save(author3);
        authorRepository.save(author4);
        authorRepository.save(author5);
        authorRepository.save(author6);
        bookRepository.save(new Book("Euro trip", Category.CLASSICS, author1,6));
        bookRepository.save(new Book("Australia trip", Category.DRAMA, author2, 10));
        bookRepository.save(new Book("Asia trip", Category.NOVEL, author3, 14));
        bookRepository.save(new Book("Africa trip", Category.HISTORY, author4, 3));
        bookRepository.save(new Book("North America trip", Category.FANTASY, author5, 17));
        bookRepository.save(new Book("South America trip", Category.THRILLER, author6, 22));
        bookRepository.save(new Book("LOTR", Category.BIOGRAPHY, author1, 9));
        bookRepository.save(new Book("GOT", Category.THRILLER, author6, 16));
    }
}
