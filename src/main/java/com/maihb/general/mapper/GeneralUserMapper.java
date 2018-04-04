package com.maihb.general.mapper;

import com.maihb.general.entity.GeneralUser;
import com.maihb.general.framework.security.LoginRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GeneralUserMapper {

    List<GeneralUser> selectGeneralUsers();

    GeneralUser selectGeneralUser(Long id);

    Long insertGeneralUser(GeneralUser generalUser);

    @Select("select * from general_user where admin_username = #{username}")
    GeneralUser findByUsername(LoginRequest loginRequest);
}
