package com.fireitup.grillhub.auth;

import com.fireitup.grillhub.dtos.SuccessMessageDTO;
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

  @PostMapping("/registration")
  public ResponseEntity<SuccessMessageDTO> register(@Valid @RequestBody RegisterRequestDTO request) {
    this.authenticationService.register(request);
    return ResponseEntity.ok(new SuccessMessageDTO("Registration was successful"));
  }

  @PostMapping("/login")
  public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
    return ResponseEntity.ok(this.authenticationService.authenticate(request));
  }

}
