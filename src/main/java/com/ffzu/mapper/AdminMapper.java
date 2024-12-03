package com.ffzu.mapper;

import com.ffzu.pojo.Admin;
import com.ffzu.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper {
    // 根据宿舍号查找用户
    @Select("SELECT id, password FROM userForm WHERE id = #{id}")
    Admin getId(String id);
    @Select("SELECT id, password FROM userForm WHERE id = #{id}")
    Admin getAdminById(String id);
}
