package by.peretz.spring.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
  ADMIN,
  USER,
  DOCTOR;

  @Override
  public String getAuthority() {
    return name();
  }
}
