package com.yihuang.hrsys.entities;

/**
 * com.yihuang.hrsys.entities
 *
 * @author yihuang728
 * @create 2020/4/24
 */
public class User {

    /***
     *Username is the same with EmployeeID
     */
    private String username;

    private String password;

    private boolean isRoot;

    private String nickname;

    public User() {
    }

    public User(String username, String password, boolean isRoot) {
        this.username = username;
        this.password = password;
        this.isRoot = isRoot;
    }

    @Override
    public String toString() {
        return "User{" +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isRoot=" + isRoot + '\'' +
                ", nickname=" + nickname +
                '}';
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public boolean isRoot() {
        return isRoot;
    }

    public void setRoot(boolean root) {
        isRoot = root;
    }
}
