package com.fireitup.grillhub.services;

import com.fireitup.grillhub.repositories.SpiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpiceServiceImpl implements SpiceService {

  private final SpiceRepository spiceRepository;
  
}
