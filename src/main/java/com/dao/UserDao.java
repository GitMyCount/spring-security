package com.dao;

import com.entity.Role;
import com.entity.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    User getUserById(Long id);

    void edit(User user);

    void delete(Long id);

    User getUserByName(String username);

    Role getRoleByName(String name);

}
