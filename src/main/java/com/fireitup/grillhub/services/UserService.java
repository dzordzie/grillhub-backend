package com.fireitup.grillhub.services;

import com.fireitup.grillhub.dtos.UserPostsDTO;
import com.fireitup.grillhub.dtos.UserProfileDTO;

public interface UserService {
  UserProfileDTO getUserProfileById(Long id);

  UserPostsDTO getUserPostsById(Long id);
}
