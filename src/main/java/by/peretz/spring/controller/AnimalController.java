package by.peretz.spring.controller;

import by.peretz.spring.domain.Animal;
import by.peretz.spring.servises.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/animals")
@RequiredArgsConstructor
public class AnimalController {

  public final AnimalService animalService;

  @GetMapping
  public String getAnimals(
      @RequestParam(required = false, name = "editAnimal", defaultValue = "") Animal animal,
      @RequestParam(name = "removeId", required = false, defaultValue = "") Animal removeAnimal,
      @RequestParam(name = "repairId", required = false, defaultValue = "") Animal repairAnimal,
      Model model
  ) {
    model.addAttribute("animals", animalService.findAllAnimal());

    if (animal != null) {
      model.addAttribute("animal", animal);
    }

    if (removeAnimal != null) {
      animalService.removeAnimal(removeAnimal);
      return "redirect:/animals";
    }

    if (repairAnimal != null) {
      animalService.repairAnimal(repairAnimal);
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
