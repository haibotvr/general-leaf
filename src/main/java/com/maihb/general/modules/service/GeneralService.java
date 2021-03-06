package com.maihb.general.modules.service;

import com.maihb.general.framework.security.LoginRequest;
import com.maihb.general.framework.web.ReturnValue;
import com.maihb.general.modules.entity.GeneralUser;

import java.util.List;

public interface GeneralService {

    List<GeneralUser> selectGeneralUsers();

    GeneralUser selectGeneralUser(Long id);

    GeneralUser insertGeneralUser(GeneralUser generalUser);

    ReturnValue login(LoginRequest loginRequest);

    void logOut(GeneralUser generalUser);
}
