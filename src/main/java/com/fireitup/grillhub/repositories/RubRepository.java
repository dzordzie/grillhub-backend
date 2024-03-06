package com.fireitup.grillhub.repositories;

import com.fireitup.grillhub.entities.Rub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubRepository extends JpaRepository<Rub, Long> {

}
