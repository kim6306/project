package org.itsci.project.service;

import org.itsci.project.model.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();
    void saveUser(User user);
    User getUser(Long id);
    void deleteUser(Long id);
    User findByUsername(String username);

}
