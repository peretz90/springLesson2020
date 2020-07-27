package by.peretz.spring.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Animal {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Setter(AccessLevel.NONE)
  private Long id;

  @NotEmpty
  @NonNull
  private String species;
  @NotEmpty
  @NonNull
  private String sex;
  @NotEmpty
  @NonNull
  private String name;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate birth;
  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;

  private boolean isDeleted = false;
}
