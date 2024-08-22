package com.fireitup.grillhub.services;

import com.fireitup.grillhub.dtos.RubDTO;
import com.fireitup.grillhub.dtos.RubInMealsDTO;
import com.fireitup.grillhub.entities.Rub;
import com.fireitup.grillhub.entities.Spice;
import com.fireitup.grillhub.exceptions.RubNotFoundException;
import com.fireitup.grillhub.repositories.RubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RubServiceImpl implements RubService {

  private final RubRepository rubRepository;
  private final DTOConvertService dtoConvertService;

  @Override
  public List<RubDTO> getAllRubs() {
    List<Rub> allRubs = rubRepository.findAllRubs();
    List<RubDTO> allRubsDto = new ArrayList<>();
    for (Rub rub : allRubs) {
      allRubsDto.add(dtoConvertService.rubToDTO(rub));
    }
    return allRubsDto;
  }

  @Override
  public RubInMealsDTO getRubInMealsById(Long id) {
    return rubRepository.findRubById(id)
        .map(dtoConvertService::rubInMealsToDTO)
        .orElseThrow(() -> new RubNotFoundException(id));
  }
}
