package mk.finki.ukim.mk.lab2web.service;

import mk.finki.ukim.mk.lab2web.domain.Author;
import mk.finki.ukim.mk.lab2web.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    public Author findById(Long id){
        return authorRepository.findById(id).orElse(null);
    }
    public List<Author> findAll(){
        return authorRepository.findAll();
    }
}
