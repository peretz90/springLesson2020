package by.peretz.spring.controller;

import by.peretz.spring.domain.Animal;
import by.peretz.spring.repository.AnimalRepo;
import by.peretz.spring.servises.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/animals")
@RequiredArgsConstructor
public class AnimalController {

  public final AnimalRepo animalRepo;

  public final AnimalService animalService;

  @GetMapping
  public String getAnimals(
      @RequestParam(required = false, name = "editAnimal") Long id,
      @RequestParam(name = "removeId", required = false, defaultValue = "") Long removeId,
      @RequestParam(name = "repairId", required = false) Long repairId,
      Model model
  ) {
    model.addAttribute("animals", animalService.findAllAnimal());
    if (id != null) {
      if(animalService.animalFromDb(id) == null) {
        model.addAttribute("animalError", "Animal not found");
      } else {
        model.addAttribute("animal", animalService.animalFromDb(id));
      }
    }

    if (removeId != null) {
      animalService.removeAnimal(removeId);
      return "redirect:/animals";
    }

    if (repairId != null) {
      animalService.repairAnimal(repairId);
      return "redirect:/animals";
    }

    return "animals";
  }

  @PostMapping
  public String addAnimal(
      @Valid Animal animal,
      BindingResult bindingResult,
      Model model
  ) {
    if (bindingResult.hasErrors()) {
      Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
      model.mergeAttributes(errorsMap);
      model.addAttribute("animal", animal);
      model.addAttribute("animals", animalService.findAllAnimal());
      return "animals";
    } else {
      animalService.addAnimal(animal);
      return "redirect:/animals";
    }
  }
}
