package mk.finki.ukim.mk.lab2web.repository;

import mk.finki.ukim.mk.lab2web.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
