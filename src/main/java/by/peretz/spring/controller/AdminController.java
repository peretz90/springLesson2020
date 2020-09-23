package by.peretz.spring.controller;

import by.peretz.spring.domain.Role;
import by.peretz.spring.domain.User;
import by.peretz.spring.servises.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class AdminController {

  public final UserService userService;

  @PreAuthorize("hasAuthority('ADMIN')")
  @GetMapping
  public String userList(Model model){
    model.addAttribute("users", userService.users());
    return "users";
  }

  @PreAuthorize("hasAuthority('ADMIN')")
  @GetMapping("{user}")
  public String userEditForm(@PathVariable User user, Model model){
    model.addAttribute("user", user);
    model.addAttribute("roles", Role.values());
    return "user_edit";
  }

  @PreAuthorize("hasAuthority('ADMIN')")
  @PostMapping
  public String userSave(
      @RequestParam String username,
      @RequestParam Map<String, String> form,
      @RequestParam("userId") User user
  ){
    userService.saveUser(user, username, form);
    return "redirect:/users";
  }


}
