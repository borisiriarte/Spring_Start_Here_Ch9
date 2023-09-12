package com.example.scopes.model;


import com.example.scopes.service.LoggedUserManagementService;
import com.example.scopes.service.LoginCountService;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
@Data
public class LoginProcessor {
  private final LoggedUserManagementService loggedUserManagementService;
  private final LoginCountService loginCountService;

  private String username;
  private String password;

  public LoginProcessor(LoggedUserManagementService loggedUserManagementService, LoginCountService loginCountService) {
    this.loggedUserManagementService = loggedUserManagementService;
    this.loginCountService = loginCountService;
  }

  public Boolean login(){
    loginCountService.increment();

    String username = this.getUsername();
    String password = this.getPassword();

    boolean loginResult = false;

    if("boris".equals(username) && "password".equals(password)) {
      loginResult = true;
      loggedUserManagementService.setUsername(username);
    }
    /*return "boris".equals(username) && "password".equals(password);*/
    return loginResult;
  }

}
