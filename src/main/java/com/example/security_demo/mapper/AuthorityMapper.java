package com.example.security_demo.mapper;

import com.example.security_demo.entity.Authority;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.type.JdbcType;
import java.util.List;

@Mapper
public interface AuthorityMapper {

    @Results(id = "authorityResultMap", value = {
            @Result(property = "id", column = "id", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(property = "userId", column = "user_id", jdbcType = JdbcType.VARCHAR),
            @Result(property = "authority", column = "authority", jdbcType = JdbcType.VARCHAR),
            @Result(property = "createdAt", column = "created_at", jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "updatedAt", column = "updated_at", jdbcType = JdbcType.TIMESTAMP)
    })
    @Select("SELECT * FROM authorities WHERE user_id = #{userId}")
    List<Authority> findByUserId(@Param("userId") String userId);
}