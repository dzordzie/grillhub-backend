package com.fireitup.grillhub.auth;

import com.fireitup.grillhub.config.CustomException;
import com.fireitup.grillhub.config.JwtService;
import com.fireitup.grillhub.entities.RefreshToken;
import com.fireitup.grillhub.entities.User;
import com.fireitup.grillhub.enums.Role;
import com.fireitup.grillhub.repositories.RefreshTokenRepository;
import com.fireitup.grillhub.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;
  private final RefreshTokenRepository refreshTokenRepository;

  public void register(RegisterRequestDTO request) throws CustomException {

    if (this.userRepository.existsByEmail(request.getEmail())) {
      throw new CustomException("Email is already in use");
    }

    if (this.userRepository.existsByUsername(request.getUsername())) {
      throw new CustomException("Username is already in use");
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
            request.getUsername(),
            request.getPassword()
        )
    );
    User user = userRepository.findByUsername(request.getUsername())
        .orElseThrow(() -> new CustomException("User not found"));

    String accessToken = jwtService.generateAccessToken(user);
    String refreshToken = jwtService.generateRefreshToken(user);

    refreshTokenRepository.save(new RefreshToken(user, refreshToken));

    return AuthenticationResponse.builder()
        .accessToken(accessToken)
        .refreshToken(refreshToken)
        .build();
  }

  public AuthenticationResponse refreshToken(RefreshTokenRequest request) {
    String refreshToken = request.getRefreshToken();
    RefreshToken storedToken = refreshTokenRepository.findByToken(refreshToken)
        .orElseThrow(() -> new CustomException("Invalid refresh token"));

    if (jwtService.isTokenExpired(refreshToken)) {
      throw new CustomException("Refresh token has expired");
    }

    User user = storedToken.getUser();
    String newAccessToken = jwtService.generateAccessToken(user);
    String newRefreshToken = jwtService.generateRefreshToken(user);

    storedToken.setToken(newRefreshToken);
    refreshTokenRepository.save(storedToken);

    return AuthenticationResponse.builder()
        .accessToken(newAccessToken)
        .refreshToken(newRefreshToken)
        .build();
  }
}
