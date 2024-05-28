package controller;

import service.CrudUser;
import service.CrudUserImpl;
import model.User;

public class ControllerUser {
    private final String versionProtocol = "HTTP/1.1";
    private String method;
    private String url;
    private String headers;
    private String body;
    private int id;
    private CrudUser userCrudService = new CrudUserImpl();

    public ControllerUser(String method, String url, String headers, String body) {
        this.method = method;
        this.url = url;
        this.headers = headers;
        this.body = body;
        validateAndProcessRequest();
    }

    public ControllerUser(String method, String url, String headers, String body, int id) {
        this.method = method;
        this.url = url;
        this.headers = headers;
        this.body = body;
        this.id = id;
        validateAndProcessRequest();
    }

    private void validateAndProcessRequest() {
        if (!url.equals("http://localhost:8080/api/users")) {
            throw new IllegalArgumentException("Invalid URL");
        }

        switch (method) {
            case "GET":
                if (body == null || body.isEmpty()) {
                    System.out.println(getUsers());
                } else {
                    System.out.println(getUsersById(id));
                }
                break;
            case "POST":
                postUser(body);
                break;
            case "PUT":
                putUserId(body, id);
                break;
            case "DELETE":
                deleteUserById(id);
                break;
            default:
                throw new IllegalArgumentException("Invalid method");
        }
    }

    public String getUsers() {
        userCrudService.findAll();
        return "Users retrieved successfully.";
    }

    public String getUsersById(int id) {
        User user = userCrudService.findById(id);
        if (user != null) {
            return user.toString();
        }
        return "User not found.";
    }

    public void postUser(String body) {
        userCrudService.create(body);
        System.out.println("User created successfully.");
        userCrudService.findAll();
    }

    public void deleteUserById(int id) {
        userCrudService.deleteById(id);
        System.out.println("User deleted successfully.");
        userCrudService.findAll();
    }

    public void putUserId(String body, int id) {
        userCrudService.updateById(body, id);
        System.out.println("User updated successfully.");
        userCrudService.findAll();
    }

    @Override
    public String toString() {
        return "ControllerUser{url='" + url + "', headers='" + headers + "', body='" + body + "', id=" + id + "}";
    }
}
