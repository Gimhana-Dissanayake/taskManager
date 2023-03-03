package com.todo.taskManager.service;

import com.todo.taskManager.domain.Todo;
import com.todo.taskManager.exception.domain.TodoNotFoundException;
import com.todo.taskManager.exception.domain.UserNotFoundException;
import java.util.List;

public interface TodoService {
  List<Todo> getTodos(String username) throws UserNotFoundException;

  Todo addTodo(Todo todo);

  Todo updateTodo(Todo todo) throws TodoNotFoundException;

  Todo deleteTodo(Long todoId) throws TodoNotFoundException;
}
