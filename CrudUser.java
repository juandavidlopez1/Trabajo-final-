package service;

import model.User;
import java.util.List;

public interface CrudUser {
    void create(String body);
    List<User> readAll();
    void updateById(String body, int id);
    void deleteById(int id);
    void findAll();
    User findById(int id);
}

