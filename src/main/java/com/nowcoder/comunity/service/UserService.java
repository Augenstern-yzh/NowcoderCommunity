package com.nowcoder.comunity.service;

import com.nowcoder.comunity.dao.UserMapper;
import com.nowcoder.comunity.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired(required = false)
    private UserMapper userMapper;

    public User findUserById(int id){
        return userMapper.selectById(id);
    }
}
