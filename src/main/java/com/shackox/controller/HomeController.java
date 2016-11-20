package com.shackox.controller;

import com.shackox.model.AppUser;
import com.shackox.model.UserRole;
import com.shackox.service.AppUserService;
import com.shackox.service.UserRoleService;

import java.util.ArrayList;
import java.util.List;

import com.shackox.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by SHACKOX on 22/10/16.
 */

@Controller
public class HomeController {

    @Autowired
    AppUserService appUserService;

    @Autowired
    UserRoleService userRoleService;


    @RequestMapping(value = "/")
    public String home(){

        return "home";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/signup")
    public String signup(){
        return "signup";
    }

    @RequestMapping(value = "/test")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public String test(){
        return "home";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signupForm(@RequestParam String userName, @RequestParam String password){
        UserRole role = userRoleService.getRoleUser();
        List<UserRole> roles = new ArrayList<>();
        roles.add(role);

        appUserService.insertAppUser(new AppUser(userName, Util.encodePassword(password),roles));
        return "redirect:/login";
    }
}