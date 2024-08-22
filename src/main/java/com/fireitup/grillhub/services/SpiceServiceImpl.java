package com.fireitup.grillhub.services;

import com.fireitup.grillhub.dtos.SpiceDTO;
import com.fireitup.grillhub.entities.Spice;
import com.fireitup.grillhub.repositories.SpiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpiceServiceImpl implements SpiceService {

  private final SpiceRepository spiceRepository;

  @Override
  public void addNewSpice(SpiceDTO spiceDTO) {
    Spice newSpice = new Spice();
    newSpice.setName(spiceDTO.getName());
    newSpice.setWeightInGrams(spiceDTO.getWeightInGrams());
    spiceRepository.save(newSpice);
  }
}
