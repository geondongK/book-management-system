package com.bookManagementSystem.domain.auth.mapper;

import com.bookManagementSystem.domain.auth.domain.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SignUpMapper {
    void signUp(Users dto);
}
