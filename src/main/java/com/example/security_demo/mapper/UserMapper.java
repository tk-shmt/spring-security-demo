package com.example.security_demo.mapper;

import com.example.security_demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface UserMapper {
    @Results(id = "userResultMap", value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(property = "userId", column = "user_id", jdbcType = JdbcType.VARCHAR),
            @Result(property = "password", column = "password", jdbcType = JdbcType.VARCHAR),
            @Result(property = "enabled", column = "enabled", jdbcType = JdbcType.BOOLEAN),
            @Result(property = "createdAt", column = "created_at", jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "updatedAt", column = "updated_at", jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "email", column = "email", jdbcType = JdbcType.VARCHAR),
            @Result(property = "firstName", column = "first_name", jdbcType = JdbcType.VARCHAR),
            @Result(property = "lastName", column = "last_name", jdbcType = JdbcType.VARCHAR),
            @Result(property = "phoneNumber", column = "phone_number", jdbcType = JdbcType.VARCHAR),
            @Result(property = "authorities", javaType = List.class, column = "user_id",
                    many = @org.apache.ibatis.annotations.Many(select = "com.example.demo.mapper.AuthorityMapper.findByUserId"))
    })
    @Select("SELECT * FROM users WHERE user_id = #{userId}")
    User findByUserId(@Param("userId") String userId);
}
