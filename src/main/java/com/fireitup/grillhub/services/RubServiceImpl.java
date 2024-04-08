package com.fireitup.grillhub.services;

import com.fireitup.grillhub.dtos.RubDTO;
import com.fireitup.grillhub.entities.Rub;
import com.fireitup.grillhub.repositories.RubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}
