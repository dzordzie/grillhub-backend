package com.fireitup.grillhub.repositories;

import com.fireitup.grillhub.entities.Spice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpiceRepository extends JpaRepository<Spice, Long> {
  Spice findByName(String name);
}
