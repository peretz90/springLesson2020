package by.peretz.spring.controller;

import by.peretz.spring.domain.Animal;
import by.peretz.spring.servises.AnimalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/animals")
public class AnimalController {

  public final AnimalService animalService;

  public AnimalController(AnimalService animalService) {
    this.animalService = animalService;
  }

  @GetMapping
  public String getAnimals(Model model) {
    model.addAttribute("animals", animalService.findAllAnimal());
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
