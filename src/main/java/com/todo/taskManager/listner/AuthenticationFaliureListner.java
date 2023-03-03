package com.todo.taskManager.listner;

import com.todo.taskManager.service.LoginAttemptService;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFaliureListner {

  private LoginAttemptService loginAttemptService;

  @Autowired
  public AuthenticationFaliureListner(LoginAttemptService loginAttemptService) {
    this.loginAttemptService = loginAttemptService;
  }

  @EventListener
  public void onAuthenticationFaliure(
    AuthenticationFailureBadCredentialsEvent event
  ) throws ExecutionException {
    Object principal = event.getAuthentication().getPrincipal();

    if (principal instanceof String) {
      String username = (String) event.getAuthentication().getPrincipal();
      loginAttemptService.addUserToLoginAttempCache(username);
    }
  }
}
