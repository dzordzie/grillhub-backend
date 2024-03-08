package com.fireitup.grillhub.repositories;

import com.fireitup.grillhub.entities.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

  @Query(value = "SELECT * FROM meal ORDER BY created_at DESC", nativeQuery = true)
  List<Meal> findAllMeals();

}
