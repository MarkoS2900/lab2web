package mk.finki.ukim.mk.lab2web.domain.dto;

import lombok.Data;
import mk.finki.ukim.mk.lab2web.domain.Author;
import mk.finki.ukim.mk.lab2web.domain.enums.Category;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class BookDto {
    private String name;
    private Category category;
    private Long author;
    int availableCopies;

    public BookDto(String name, Category category, Long author, int availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
