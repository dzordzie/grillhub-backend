package com.fireitup.grillhub.auth;

import com.fireitup.grillhub.config.CustomException;
import com.fireitup.grillhub.config.JwtService;
import com.fireitup.grillhub.entities.User;
import com.fireitup.grillhub.enums.Role;
import com.fireitup.grillhub.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public void register(RegisterRequestDTO request) throws CustomException {

    if (this.userRepository.existsByEmail(request.getEmail())) {
      throw new CustomException("Email is already in use");
    }

    User user = User.builder()
        .username(request.getUsername())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(Role.USER)
        .build();
    userRepository.save(user);
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getEmail(),
            request.getPassword()
        )
    );
    User user = userRepository.findByEmail(request.getEmail())
        .orElseThrow();
    String jwtToken = jwtService.generateToken(Map.of("role", user.getRole()), user);
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  }
}
