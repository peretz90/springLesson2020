package by.peretz.spring.servises;

import by.peretz.spring.domain.Role;
import by.peretz.spring.domain.User;
import by.peretz.spring.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService {

  public final UserRepo userRepo;

  public boolean addUser(User user) {
      user.setRoles(Collections.singleton(Role.USER));
      user.setActive(true);
      userRepo.save(user);
      return true;
  }

}
