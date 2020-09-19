package net.xdclass.demo_project.service;

import net.xdclass.demo_project.domain.User;

import java.util.List;

public interface UserService {
    String login(User user);
    List<User> listUser();
}
