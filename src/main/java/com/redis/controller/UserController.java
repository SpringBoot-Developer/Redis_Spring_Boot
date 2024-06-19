package com.redis.controller;

import com.redis.dao.UserDao;
import com.redis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDao userDao;


    @PostMapping
    public User create(@RequestBody User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userDao.save(user);
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") String userId) {
        return userDao.get(userId);
    }

    @GetMapping
    public Map<Object, Object> getAll() {
        return userDao.findAll();
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable("userId") String userId) {
        userDao.delete(userId);
    }
}
