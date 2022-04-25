package mk.finki.ukim.mk.lab2web.repository;

import mk.finki.ukim.mk.lab2web.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    void deleteByName(String name);
    @Query("update Book book set book.availableCopies=:availableCopies where book.id=:id")
    @Modifying
    void updateAvailableCopies(Long id, int availableCopies);
}
