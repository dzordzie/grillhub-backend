package com.fireitup.grillhub.repositories;

import com.fireitup.grillhub.entities.Meat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeatRepository extends JpaRepository<Meat, Long> {

}
