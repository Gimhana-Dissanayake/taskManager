package com.todo.taskManager.exception.domain;

public class TodoNotFoundException extends Exception {

  public TodoNotFoundException(String message) {
    super(message);
  }
}
