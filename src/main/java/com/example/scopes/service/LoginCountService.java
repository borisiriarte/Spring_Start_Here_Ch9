package com.example.scopes.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope
@Data
public class LoginCountService {
  private int count;

  public void increment() {
    count++;
  }
}
