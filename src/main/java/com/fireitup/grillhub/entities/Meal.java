package com.fireitup.grillhub.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(of = "id")
public class Meal {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @Lob
  @Column(columnDefinition="TEXT")
  private String description;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "meat_id")
  private Meat meat;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "rub_id")
  private Rub rub;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id")
  private User createdBy;

  private LocalDateTime createdAt = LocalDateTime.now();

  public String getFormattedCreatedAt() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd. MMMM yyyy - HH:mm");
    return createdAt.format(formatter);
  }

}
