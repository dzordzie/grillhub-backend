package com.fireitup.grillhub.auth;

import com.fireitup.grillhub.dtos.SuccessMessageDTO;
import com.fireitup.grillhub.services.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService authenticationService;
  private final TokenService tokenService;

  @PostMapping("/registration")
  public ResponseEntity<SuccessMessageDTO> register(@Valid @RequestBody RegisterRequestDTO request) {
    this.authenticationService.register(request);
    return ResponseEntity.ok(new SuccessMessageDTO("Registration was successful"));
  }

  @PostMapping("/login")
  public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
    return ResponseEntity.ok(this.authenticationService.authenticate(request));
  }

  @PostMapping("/logout")
  public ResponseEntity<Void> logout(@RequestBody RefreshTokenRequest request) {
    System.out.println(request);
    String refreshToken = request.getRefreshToken();
    System.out.println(refreshToken);
    if (refreshToken != null) {
      tokenService.deleteRefreshToken(refreshToken);
    }

    return ResponseEntity.noContent().build();
  }

  @PostMapping("/refresh-token")
  public ResponseEntity<AuthenticationResponse> refreshToken(@RequestBody RefreshTokenRequest request) {
    return ResponseEntity.ok(this.authenticationService.refreshToken(request));
  }

}
