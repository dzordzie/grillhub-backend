package com.fireitup.grillhub.services;

import com.fireitup.grillhub.repositories.RubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RubServiceImpl implements RubService {

  private final RubRepository rubRepository;

}
