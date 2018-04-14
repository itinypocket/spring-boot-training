package com.songguoliang.util;

import org.springframework.cglib.beans.BeanMap;

import java.util.Map;

/**
 * @Description
 * @Author sgl
 * @Date 2018-04-14 09:57
 */
public class BeanUtils extends org.springframework.beans.BeanUtils{
    /**
     * 将对象装成map形式
     * @param src
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static Map toMap(Object src) {
        return BeanMap.create(src);
    }
}
