package com.fireitup.grillhub.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Meal {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "meat_id")
  private Meat meat;

  @ManyToOne
  @JoinColumn(name = "rub_name")
  private Rub rub;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User createdBy;

  @CreatedDate
  private LocalDateTime createdAt;

}
