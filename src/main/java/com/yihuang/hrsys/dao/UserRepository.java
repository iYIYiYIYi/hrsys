package com.yihuang.hrsys.dao;

import com.yihuang.hrsys.entities.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * com.yihuang.hrsys.dao
 *
 * @author yihuang728
 * @create 2020/04/25
 */
@Repository
public interface UserRepository {

    /***
     * create table user
     * @return MyBatis flag
     */
    int createTable();

    /***
     * update user information
     * @param user to be updated
     * @return MyBatis Flag
     */
    int updateUserInfo(User user);

    /***
     * remove User by Username
     * @param username a String makes reference to a specific User
     * @return MyBatis flag
     */
    int removeByUsername(String username);

    /***
     * remove User from database by itself
     * @param user to be deleted
     * @return MyBatis flag
     */
    int remove(User user);

    /***
     * insert User into table
     * @param user to be inserted
     * @return MyBatis flag
     */
    int addUser(User user);

    /***
     * get User by Username
     * @param username String makes reference to a specific User
     * @return User reference
     */
    User findByUsername(String username);

    /***
     * get all Users from database
     * @return a List of all User references
     */
    List<User> findAll();

}
