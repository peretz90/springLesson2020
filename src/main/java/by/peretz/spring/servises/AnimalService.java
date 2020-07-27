package by.peretz.spring.servises;

import by.peretz.spring.domain.Animal;
import by.peretz.spring.repository.AnimalRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalService {

  public final AnimalRepo animalRepo;

  public void addAnimal(Animal animal) {
    if (animal.getCreatedDate() == null) {
      animal.setCreatedDate(LocalDateTime.now());
    }
    animal.setUpdatedDate(LocalDateTime.now());
    animalRepo.save(animal);
  }

  public List<Animal> findAllAnimal() {
    Iterable<Animal> animals = animalRepo.findAll();
    List<Animal> animalList = new ArrayList<>();
    animals.forEach(animalList::add);
    return animalList;
  }

}
