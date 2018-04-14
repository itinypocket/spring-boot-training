package com.songguoliang.service;

import com.songguoliang.entity.User;
import com.songguoliang.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author sgl
 * @Date 2018-04-12 10:25
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User selectByLoginName(String loginName) {
        User user = new User();
        user.setLoginName(loginName);
        return userMapper.selectOne(user);
    }

    public User selectById(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    public void updatePwdByUserId(Long userId, String md5Hex) {
        userMapper.updatePwdByUserId(userId, md5Hex);
    }
}
