package com.songguoliang.mapper;

import com.songguoliang.base.BaseMapper;
import com.songguoliang.entity.Resource;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description
 * @Author sgl
 * @Date 2018-04-12 16:29
 */
public interface ResourceMapper extends BaseMapper<Resource>{

    /**
     * 根据类型获取资源
     * @param type
     * @return
     */
    @Select("select * from tbl_resource where resource_type=#{type} and status=0 order by seq")
    List<Resource>selectByType(Integer type);

}
