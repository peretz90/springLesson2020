package by.peretz.spring.controller;

import by.peretz.spring.servises.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class AdminController {

  public final UserService userService;

//  @PreAuthorize("hasAuthority('ADMIN')")
//  @GetMapping("/userlist")


}
