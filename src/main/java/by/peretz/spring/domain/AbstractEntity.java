package by.peretz.spring.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
abstract class AbstractEntity {

  @CreatedDate
  @Column(updatable = false)
  @DateTimeFormat(pattern = "d.MMMM.yyyy Time: H.m.s")
  private LocalDateTime createdDate;
  @LastModifiedDate
  private LocalDateTime updatedDate;

  private boolean isDeleted = false;

}
