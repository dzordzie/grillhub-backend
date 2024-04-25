package com.fireitup.grillhub.services;

import com.fireitup.grillhub.dtos.UserPostsDTO;
import com.fireitup.grillhub.dtos.UserProfileDTO;
import com.fireitup.grillhub.exceptions.UserNotFoundException;
import com.fireitup.grillhub.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final DTOConvertService dtoConvertService;

  @Override
  public UserProfileDTO getUserProfileById(Long id) {
    return userRepository.findUserById(id)
        .map(dtoConvertService::userToUserProfileDTO)
        .orElseThrow(() -> new UserNotFoundException(id));
  }

  @Override
  public UserPostsDTO getUserPostsById(Long id) {
    return userRepository.findUserById(id)
        .map(dtoConvertService::userToUserPostsDTO)
        .orElseThrow(() -> new UserNotFoundException(id));
  }
}
