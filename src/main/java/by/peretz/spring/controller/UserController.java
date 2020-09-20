package by.peretz.spring.controller;

import by.peretz.spring.domain.User;
import by.peretz.spring.servises.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class UserController {

  public final UserService userService;

  @GetMapping("/user")
  public String editUser(
      @AuthenticationPrincipal User user,
      Model model
  ) {
    model.addAttribute("user", user);
    return "user";
  }

  @GetMapping("/user/password")
  public String password() {
    return "password";
  }

  @PostMapping("/user/password")
  public String editUser(
      @RequestParam(name = "oldPassword", defaultValue = "", required = false) String oldPassword,
      @RequestParam(name = "newPassword", defaultValue = "", required = false) String newPassword,
      @RequestParam(name = "confirmPassword", defaultValue = "", required = false) String confirmPassword,
      Model model,
      @AuthenticationPrincipal User user) {

    Map<String, String> errorMap = userService.changePassword(oldPassword, newPassword, confirmPassword, user);
    if (errorMap.isEmpty()) {
      return "redirect:/logout";
    }
    model.mergeAttributes(errorMap);
    return "password";
  }
}
