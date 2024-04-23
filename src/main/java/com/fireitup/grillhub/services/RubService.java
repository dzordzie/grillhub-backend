package com.fireitup.grillhub.services;

import com.fireitup.grillhub.dtos.RubDTO;
import com.fireitup.grillhub.dtos.RubInMealsDTO;

import java.util.List;

public interface RubService {

  List<RubDTO> getAllRubs();

  RubInMealsDTO getRubInMealsById(Long id);

}
