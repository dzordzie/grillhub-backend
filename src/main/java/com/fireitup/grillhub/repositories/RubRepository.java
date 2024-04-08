package com.fireitup.grillhub.repositories;

import com.fireitup.grillhub.entities.Rub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RubRepository extends JpaRepository<Rub, Long> {
  @Query(value = "SELECT * FROM rub", nativeQuery = true)
  List<Rub> findAllRubs();

  Rub findByName(String name);
}
