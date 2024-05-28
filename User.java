package model;

public class User {
    private static int idCounter = 1;
    private int id;
    private String name;
    private String email;
    private String phone;

    public User(String name, String email, String phone) {
        this.id = idCounter++;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "', email='" + email + "', phone='" + phone + "'}";
    }
}
