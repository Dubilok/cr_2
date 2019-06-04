package ru.ivmiit.dao;

import ru.ivmiit.models.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    void save(User user);

    User getById(Integer id);

    void delete(Integer id);

    void update(User user);

}
