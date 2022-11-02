package org.itsci.project.dao;



import org.itsci.project.model.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();
    void saveUser(User user);
    User getUser(Long id);
    void deleteUser(Long id);
    User findByUsername(String username);

}
