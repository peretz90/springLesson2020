package by.peretz.spring.validation;

import by.peretz.spring.repository.UserRepo;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UniqueEmailValidation implements ConstraintValidator<UniqueEmail, String> {

  public final UserRepo userRepo;


  @Override
  public void initialize(UniqueEmail constraintAnnotation) {

  }

  @Override
  public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
    return userRepo.findByEmail(s) == null;
  }
}
