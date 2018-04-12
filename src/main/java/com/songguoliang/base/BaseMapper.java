package com.songguoliang.commons;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * mapper基类
 * @Author sgl
 * @Date 2018-04-11 15:58
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
