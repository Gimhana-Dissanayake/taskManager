package com.todo.taskManager.service.impl;

import com.todo.taskManager.domain.Todo;
import com.todo.taskManager.domain.User;
import com.todo.taskManager.exception.domain.TodoNotFoundException;
import com.todo.taskManager.exception.domain.UserNotFoundException;
import com.todo.taskManager.repository.TodoRepository;
import com.todo.taskManager.repository.UserRepository;
import com.todo.taskManager.service.TodoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {

  @Autowired
  private TodoRepository todoRepository;

  @Autowired
  private UserRepository userRepository;

  @Override
  public List<Todo> getTodos(String username) throws UserNotFoundException {
    User user = userRepository.findUserByUsername(username);

    if (user == null) {
      throw new UserNotFoundException(
        "User with username " + username + " does not exist"
      );
    }

    return todoRepository.findByUsername(username);
  }

  @Override
  public Todo addTodo(Todo todo) {
    return todoRepository.save(todo);
  }

  @Override
  public Todo updateTodo(Todo todo) throws TodoNotFoundException {
    Optional<Todo> todoFromDb = todoRepository.findById(todo.getId());

    if (todoFromDb.isPresent()) {
      return todoRepository.save(todo);
    } else {
      throw new TodoNotFoundException(
        "Todo with id " + todo.getId() + " does not exsist"
      );
    }
  }

  @Override
  public Todo deleteTodo(Long todoId) throws TodoNotFoundException {
    Optional<Todo> todo = todoRepository.findById(todoId);
    if (todo.isPresent()) {
      todoRepository.deleteById(todoId);
      return todo.get();
    } else {
      throw new TodoNotFoundException(
        "Todo with id " + todoId + " does not exsist"
      );
    }
  }
}
