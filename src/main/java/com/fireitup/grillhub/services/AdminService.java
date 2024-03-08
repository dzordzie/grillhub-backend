package com.fireitup.grillhub.services;

import com.fireitup.grillhub.entities.User;
import com.fireitup.grillhub.enums.Role;
import com.fireitup.grillhub.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @Value("${admin.email}")
  private String adminEmail;

  @Value("${admin.name}")
  private String adminName;

  @Value("${admin.password}")
  private String adminPassword;

  public void initialAdmin() {
    if (userRepository.findByUsername(adminName).isEmpty()) {
      User admin = User.builder()
          .username(adminName)
          .email(adminEmail)
          .password(passwordEncoder.encode(adminPassword))
          .role(Role.ADMIN)
          .build();
      userRepository.save(admin);
    }
  }

}
