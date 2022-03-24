package com.nowcoder.comunity.dao;

import com.nowcoder.comunity.entity.User;
import org.apache.ibatis.annotations.Mapper;

import javax.jws.soap.SOAPBinding;

@Mapper
public interface UserMapper {
    User selectById(int id);
    User selectByName(String username);
    User selectByEmail(String email);
    int insertUser(User user);
    int updateStatus(int id,int status);
    int updateHeader(int id,String headerUrl);
    int updatePassword(int id,String password);
}
