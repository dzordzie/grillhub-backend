package com.fireitup.grillhub;

import com.fireitup.grillhub.repositories.*;
import com.fireitup.grillhub.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class GrillHubApplication implements CommandLineRunner {

  private final AdminService adminService;

  private final UserRepository userRepository;
  private final MealRepository mealRepository;
  private final MeatRepository meatRepository;
  private final RubRepository rubRepository;
  private final SpiceRepository spiceRepository;

  public static void main(String[] args) {
    SpringApplication.run(GrillHubApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    adminService.initialAdmin();
  }
}
