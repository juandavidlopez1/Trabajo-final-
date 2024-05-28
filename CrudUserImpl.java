package service;

import model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CrudUserImpl implements CrudUser {
    private List<User> users = new ArrayList<>();
    private User user;

    @Override
    public void create(String body) {
        StringTokenizer st = new StringTokenizer(body, ",");
        String name = st.nextToken();
        String email = st.nextToken();
        String phone = st.nextToken();
        User user = new User(name, email, phone);
        users.add(user);
    }

    @Override
    public List<User> readAll() {
        return users;
    }

    @Override
    public void updateById(String body, int id) {
        for (User user : users) {
            if (user.getId() == id) {
                StringTokenizer st = new StringTokenizer(body, ",");
                user.setName(st.nextToken());
                user.setEmail(st.nextToken());
                user.setPhone(st.nextToken());
            }
        }
    }

    @Override
    public void deleteById(int id) {
        users.removeIf(user -> user.getId() == id);
    }

    @Override
    public void findAll() {
        printUsers(users);
    }

    @Override
    public User findById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    private void printUsers(List<User> users) {
        for (User user : users) {
            System.out.println(user);
        }
    }
}
