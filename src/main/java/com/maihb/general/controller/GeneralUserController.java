package com.maihb.general.controller;

import com.maihb.general.entity.GeneralUser;
import com.maihb.general.framework.web.ReturnValue;
import com.maihb.general.service.GeneralService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class GeneralUserController extends BaseController{

    @Autowired
    GeneralService generalService;

    @RequestMapping(path = "/generalUsers", method = RequestMethod.GET)
    public ReturnValue selectGeneralUsers(){
        return ReturnValue.success(generalService.selectGeneralUsers());
    }

    @RequestMapping(path = "/generalUser/{id}", method = RequestMethod.GET)
    public ReturnValue selectGeneralUser(@PathVariable("id") Long id){
        return ReturnValue.success(generalService.selectGeneralUser(id));
    }

    @RequestMapping(path = "/generalUser", method = RequestMethod.POST)
    public ReturnValue insertGeneralUser(GeneralUser generalUser){
        return ReturnValue.success(generalService.insertGeneralUser(generalUser));
    }

}
