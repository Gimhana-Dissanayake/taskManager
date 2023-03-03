package com.todo.taskManager.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Todo implements Serializable {

  @Id
  @GeneratedValue
  private Long id;

  private String todoTitle;
  private String username;
  private String description;
  private String targetDate;
  private boolean done;

  public Todo() {}

  public Todo(
    Long id,
    String todoTitle,
    String username,
    String description,
    String targetDate,
    boolean done
  ) {
    this.id = id;
    this.todoTitle = todoTitle;
    this.username = username;
    this.description = description;
    this.targetDate = targetDate;
    this.done = done;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTodoTitle() {
    return todoTitle;
  }

  public void setTodoTitle(String todoTitle) {
    this.todoTitle = todoTitle;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getTargetDate() {
    return targetDate;
  }

  public void setTargetDate(String targetDate) {
    this.targetDate = targetDate;
  }

  public boolean getDone() {
    return done;
  }

  public void setDone(boolean done) {
    this.done = done;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (id ^ (id >>> 32));
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Todo other = (Todo) obj;
    if (id != other.id) return false;
    return true;
  }
}
