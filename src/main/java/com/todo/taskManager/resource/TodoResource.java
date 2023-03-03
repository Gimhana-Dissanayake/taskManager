package com.todo.taskManager.resource;

import com.todo.taskManager.domain.Todo;
import com.todo.taskManager.exception.domain.ExceptionHandling;
import com.todo.taskManager.exception.domain.TodoNotFoundException;
import com.todo.taskManager.exception.domain.UserNotFoundException;
import com.todo.taskManager.service.TodoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = { "", "/todo" })
public class TodoResource extends ExceptionHandling {

  private TodoService todoService;

  @Autowired
  public TodoResource(TodoService todoService) {
    this.todoService = todoService;
  }

  @GetMapping("/{username}")
  public ResponseEntity<List<Todo>> getTodos(
    @PathVariable("username") String username
  ) throws UserNotFoundException {
    List<Todo> list = todoService.getTodos(username);

    return new ResponseEntity<>(list, HttpStatus.OK);
  }

  @PostMapping("/add")
  public ResponseEntity<Todo> addTodo(@RequestBody Todo todo) {
    Todo createTodo = todoService.addTodo(todo);

    return new ResponseEntity<>(createTodo, HttpStatus.CREATED);
  }

  @PutMapping("/update")
  public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo)
    throws TodoNotFoundException {
    Todo updateTodo = todoService.updateTodo(todo);

    return new ResponseEntity<>(updateTodo, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Todo> deleteTodo(@PathVariable("id") Long id)
    throws TodoNotFoundException {
    Todo deletedTodo = todoService.deleteTodo(id);

    return new ResponseEntity<>(deletedTodo, HttpStatus.OK);
  }
}
