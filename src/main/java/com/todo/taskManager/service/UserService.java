package com.todo.taskManager.service;

import com.todo.taskManager.domain.User;
import com.todo.taskManager.exception.domain.EmailExistException;
import com.todo.taskManager.exception.domain.EmailNotFoundException;
import com.todo.taskManager.exception.domain.NotAnImageFileException;
import com.todo.taskManager.exception.domain.UsernameExistException;
import java.io.IOException;
import java.util.List;
import javax.mail.MessagingException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {
  User register(
    String firstName,
    String lastName,
    String username,
    String email
  )
    throws UsernameNotFoundException, UsernameExistException, EmailExistException, MessagingException;

  List<User> getUsers();

  User findUserByUsername(String username);

  User findUserByEmail(String email);

  User addNewUser(
    String firstName,
    String lastName,
    String username,
    String email,
    String role,
    boolean isNotLocked,
    boolean isActive,
    MultipartFile profileImage
  )
    throws UsernameNotFoundException, UsernameExistException, EmailExistException, IOException, NotAnImageFileException;

  User updateUser(
    String currentUsername,
    String newFirstName,
    String newLastName,
    String newUsername,
    String newEmail,
    String role,
    boolean isNotLocked,
    boolean isActive,
    MultipartFile profileImage
  )
    throws UsernameNotFoundException, UsernameExistException, EmailExistException, IOException, NotAnImageFileException;

  void deleteUser(String username) throws IOException;

  void resetPassword(String email)
    throws EmailNotFoundException, MessagingException;

  User updateProfileImage(String username, MultipartFile profileImage)
    throws UsernameNotFoundException, UsernameExistException, EmailExistException, IOException, NotAnImageFileException;
}
