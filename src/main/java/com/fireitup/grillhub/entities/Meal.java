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

  @Lob
  @Column(columnDefinition="MEDIUMTEXT")
  private String imageBase64;

  private LocalDateTime createdAt;

  @PrePersist
  protected void onCreate() {
    if (createdAt == null) {
      createdAt = LocalDateTime.now();
    }
  }

  public String getFormattedCreatedAt() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd. MMMM yyyy - HH:mm");
    return createdAt.format(formatter);
  }

}
