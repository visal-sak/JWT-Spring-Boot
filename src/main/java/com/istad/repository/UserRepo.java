package com.istad.repository;

import com.istad.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserRepo {
    @Select("SELECT username ,password,role FROM users_tb\n" +
            "INNER JOIN user_role_tb urt on users_tb.id = urt.user_id\n" +
            "INNER JOIN role_tb rt on rt.id = urt.role_id\n" +
            "WHERE username LIKE #{username}")
    List<User> findUserByName(String username);
}
