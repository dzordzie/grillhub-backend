package com.fireitup.grillhub.services;

import com.fireitup.grillhub.repositories.MeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MeatServiceImpl implements MeatService {

  private final MeatRepository meatRepository;

}
