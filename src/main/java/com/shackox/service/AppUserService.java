package com.shackox.service;

import com.shackox.model.AppUser;

/**
 * Created by SHACKOX on 23/10/16.
 */
public interface AppUserService {
    void insertAppUser(AppUser appUser);

    AppUser getUserByUserName(String userName);
}
