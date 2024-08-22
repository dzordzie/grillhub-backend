package com.fireitup.grillhub.services;

import com.fireitup.grillhub.entities.RefreshToken;

import java.util.Optional;

public interface TokenService {

  public Optional<RefreshToken> findRefreshToken(String token);

  public void saveRefreshToken(RefreshToken refreshToken);

  public void deleteRefreshToken(String token);
}
