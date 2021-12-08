package com.kai.mvc.bean;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/12/7
 **/
public class User {

    private Integer Id;

    private String username;

    private String password;

    private Integer age;

    private String gender;

    public User() {
    }

    public User(Integer id, String username, String password, Integer age, String gender) {
        Id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.gender = gender;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
