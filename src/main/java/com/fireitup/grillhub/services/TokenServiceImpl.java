package com.fireitup.grillhub.services;

import com.fireitup.grillhub.auth.RefreshTokenRequest;
import com.fireitup.grillhub.entities.RefreshToken;
import com.fireitup.grillhub.repositories.RefreshTokenRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {

  private final RefreshTokenRepository refreshTokenRepository;

  @Override
  public Optional<RefreshToken> findRefreshToken(String token) {
    return refreshTokenRepository.findByToken(token);
  }

  @Override
  public void saveRefreshToken(RefreshToken refreshToken) {
    refreshTokenRepository.save(refreshToken);
  }

  @Override
  @Transactional
  public void deleteRefreshToken(String token) {
    refreshTokenRepository.deleteByToken(token);
  }

}
