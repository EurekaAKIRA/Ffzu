package com.ffzu.mapper;

import com.ffzu.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    // 根据宿舍号查找用户
    @Select("SELECT id, password FROM userForm WHERE id = #{id}")
    User getUserById(String id);
}
