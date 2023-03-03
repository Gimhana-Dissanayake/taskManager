package com.todo.taskManager;

import com.todo.taskManager.constant.FileConstant;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class TaskManagerApplication {

  public static void main(String[] args) {
    SpringApplication.run(TaskManagerApplication.class, args);
    new File(FileConstant.USER_FOLDER).mkdirs();
  }

  @Bean
  public CorsFilter corsFilter() {
    UrlBasedCorsConfigurationSource uBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();

    CorsConfiguration corsConfiguration = new CorsConfiguration();
    corsConfiguration.setAllowCredentials(true);

    List<String> ls = new ArrayList<String>();

    ls.add("http://localhost:4200");
    ls.add("http://localhost:3000");

    corsConfiguration.setAllowedOrigins(ls);
    // corsConfiguration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
    corsConfiguration.setAllowedHeaders(
      Arrays.asList(
        "Origin",
        "Access-Control-Allow-Origin",
        "Content-Type",
        "Accept",
        "Jwt-Token",
        "Authorization",
        "Origin, Accept",
        "X-Requested-With",
        "Access-Control-Request-Method",
        "Access-Control-Request-Headers"
      )
    );

    corsConfiguration.setExposedHeaders(
      Arrays.asList(
        "Origin",
        "Content-Type",
        "Accept",
        "Jwt-Token",
        "Authorization",
        "Access-Control-Allow-Origin",
        "Access-Control-Allow-Origin",
        "Access-Control-Allow-Credentials"
      )
    );

    corsConfiguration.setAllowedMethods(
      Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")
    );

    uBasedCorsConfigurationSource.registerCorsConfiguration(
      "/**",
      corsConfiguration
    );

    return new CorsFilter(uBasedCorsConfigurationSource);
  }

  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
