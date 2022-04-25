package mk.finki.ukim.mk.lab2web.repository;

import mk.finki.ukim.mk.lab2web.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
}
