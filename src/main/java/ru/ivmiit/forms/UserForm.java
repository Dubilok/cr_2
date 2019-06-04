package ru.ivmiit.forms;

import ru.ivmiit.models.User;

public class UserForm {

    private int id;
    private String name;
    private String email;
    private int age;

    public UserForm() {
    }

    public UserForm(int id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public UserForm(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserForm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }

    public static User from(UserForm userForm) {
        User user = new User();
        user.setName(userForm.name);
        user.setEmail(userForm.email);
        user.setAge(userForm.age);
        return user;
    }

    public static User update(UserForm userForm) {
        User user = new User();
        user.setId(userForm.id);
        user.setName(userForm.name);
        user.setEmail(userForm.email);
        user.setAge(userForm.age);
        return user;
    }
}
