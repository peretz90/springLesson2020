package by.peretz.spring.repository;

import by.peretz.spring.domain.Animal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepo extends CrudRepository<Animal, Long> {
}
