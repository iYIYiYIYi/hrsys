package com.yihuang.hrsys.service.implement;

import com.yihuang.hrsys.dao.UserRepository;
import com.yihuang.hrsys.entities.User;
import com.yihuang.hrsys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.yihuang.hrsys.util.PasswordEncoder.string2MD5;

/**
 * com.yihuang.hrsys.service.implement
 *
 * @author yihuang728
 * @create 2020/5/13
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.addUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.remove(user);
    }

    @Override
    public void deleteUser(String name) {
        userRepository.removeByUsername(name);
    }

    @Override
    public void updateUser(User user) {
        userRepository.updateUserInfo(user);
    }

    @Override
    public User findUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    public boolean register(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        password = string2MD5(password);
        password = string2MD5(password + username);
        User newUser = new User(username,password,false);
        addUser(newUser);
        return true;
    }

    public void resetPwd(User user,String password) {
        String username = user.getUsername();
        password = string2MD5(password);
        password = string2MD5(password + username);
        user.setPassword(password);
        updateUser(user);
    }

    public boolean register(User user) {
        if (user == null) {
            return false;
        }

        String username = user.getUsername();
        String password = user.getPassword();
        password = string2MD5(password);
        password = string2MD5(password + username);
        user.setUsername(username);
        user.setPassword(password);
        addUser(user);
        return true;
    }

    public String login(String username,String password) {
        User user = userRepository.findByUsername(username);
        //Maybe we don't have such user
        if (user == null) {
            return "";
        }

        //MD5 encoding
        password = string2MD5(password);
        password = string2MD5(password + username);
        if (password.equals(user.getPassword())) {
            return user.isRoot()?"dashboard":"index/"+username;
        }
        return "";
    }



}
