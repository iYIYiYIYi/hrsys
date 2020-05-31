package com.yihuang.hrsys.service;

import com.yihuang.hrsys.entities.User;

import java.util.List;

/**
 * com.yihuang.hrsys.service
 * 用户服务接口
 * @author yihuang728
 * @create 2020/5/13
 */
public interface IUserService {

    public void addUser(User user);

    public void deleteUser(User user);

    public void deleteUser(String name);

    public void updateUser(User user);

    public User findUser(String username);

    public List<User> findUsers();

}
