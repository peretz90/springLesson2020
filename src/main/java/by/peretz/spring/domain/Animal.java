package by.peretz.spring.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
//@RequiredArgsConstructor
@NoArgsConstructor
public class Animal extends AbstractEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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

  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate birth;

  @ManyToOne
  private User animalOwner;
}
