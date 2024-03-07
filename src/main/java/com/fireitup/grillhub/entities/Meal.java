package com.fireitup.grillhub.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
  @JoinColumn(name = "rub_id")
  private Rub rub;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User createdBy;

  private LocalDateTime createdAt = LocalDateTime.now();


}
