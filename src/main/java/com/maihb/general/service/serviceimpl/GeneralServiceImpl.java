package com.maihb.general.service.serviceimpl;

import com.maihb.general.entity.GeneralUser;
import com.maihb.general.framework.web.ReturnValue;
import com.maihb.general.framework.annotation.BeanValid;
import com.maihb.general.framework.kits.JwtHelper;
import com.maihb.general.framework.security.LoginRequest;
import com.maihb.general.mapper.GeneralUserMapper;
import com.maihb.general.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneralServiceImpl implements GeneralService {

    GeneralUserMapper generalUserMapper;

    PasswordEncoder passwordEncoder;

    @Autowired
    public GeneralServiceImpl(GeneralUserMapper generalUserMapper, PasswordEncoder passwordEncoder) {
        this.generalUserMapper = generalUserMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<GeneralUser> selectGeneralUsers() {
        return generalUserMapper.selectGeneralUsers();
    }

    @Override
    public GeneralUser selectGeneralUser(Long id) {
        return generalUserMapper.selectGeneralUser(id);
    }

    @Override
    public GeneralUser insertGeneralUser(GeneralUser generalUser) {
        generalUser.setAdminPassword(passwordEncoder.encode(generalUser.getAdminPassword()));
        generalUserMapper.insertGeneralUser(generalUser);
        return generalUser;
    }

    @Override
    @BeanValid
    public ReturnValue login(LoginRequest loginRequest) {
        GeneralUser user = generalUserMapper.findByUsername(loginRequest);
        if(user == null){
            //用户名不存在或密码错误
            return ReturnValue.error().setMessage("用户名不存在");
        }
        if(passwordEncoder.matches(loginRequest.getPassword(), user.getAdminPassword())){
            //生成jwt并返回
            return ReturnValue.success(JwtHelper.createJWT(user)).setMessage("登陆成功");
        }else{
            return ReturnValue.error().setMessage("密码错误");
        }
    }

    @Override
    public void logOut(GeneralUser generalUser) {

    }
}
