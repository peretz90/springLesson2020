package by.peretz.spring.servises;

import by.peretz.spring.domain.Animal;
import by.peretz.spring.repository.AnimalRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalService {

  public final AnimalRepo animalRepo;

  public void addAnimal(Animal animal) {
    animalRepo.save(animal);
  }

  public List<Animal> findAllAnimal() {
    Iterable<Animal> animals = animalRepo.findAll();
    List<Animal> animalList = new ArrayList<>();
    animals.forEach(animalList::add);
    return animalList;
  }


  public void removeAnimal(Animal animal) {

    if(animal != null) {
      animal.setDeleted(true);
      animalRepo.save(animal);
    }
  }

  public void repairAnimal(Animal animal) {


    if(animal != null) {
      animal.setDeleted(false);
      animalRepo.save(animal);
    }
  }



}
