package com.fireitup.grillhub.entities;

import com.fireitup.grillhub.enums.MeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Meat {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String typeOfCut;
  private Double weightInKg;
  private Double internalTemp;
  private Double ambientTemp;

  @Enumerated(EnumType.STRING)
  private MeatType meatType;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "meat_id")
  private Set<Meal> meals;

}
