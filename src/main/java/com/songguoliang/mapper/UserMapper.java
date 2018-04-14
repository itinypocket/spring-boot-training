package com.songguoliang.mapper;

import com.songguoliang.base.BaseMapper;
import com.songguoliang.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @Author sgl
 * @Date 2018-04-12 10:23
 */
public interface UserMapper extends BaseMapper<User> {
    @Update("update tbl_user set password=#{pwd} where id=#{userId}")
    int updatePwdByUserId(@Param("userId") Long userId, @Param("pwd") String pwd);
}
