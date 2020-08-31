package by.peretz.spring.controller;

import by.peretz.spring.domain.User;
import by.peretz.spring.servises.UserService;
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
@RequiredArgsConstructor
@RequestMapping("/registration")
public class RegistrationController {

  public final UserService userService;

  @GetMapping
  public String registration(
    @RequestParam(name = "editUser", required = false, defaultValue = "") User user,
    Model model
    ){
      model.addAttribute("user", user);
      model.addAttribute("users", userService.users());

      return "registration";
  }


  @PostMapping
  public String addUser(
      @Valid User user,
      BindingResult bindingResult,
      Model model
  ) {
    if (bindingResult.hasErrors()) {
      Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
      model.mergeAttributes(errorsMap);
      model.addAttribute("user", user);
      return "registration";
    } else {
      userService.addUser(user);
      return "redirect:/animals";
    }
  }

}
