package com.pabwe.services;

import com.pabwe.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> listUser();

    void save(User user);

    void updateStatus(User user);

    User findByUsername(String username);

    Optional<User> findById(Long id);
}
