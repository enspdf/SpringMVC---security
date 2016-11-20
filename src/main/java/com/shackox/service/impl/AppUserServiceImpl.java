package com.shackox.service.impl;

import com.shackox.model.AppUser;
import com.shackox.service.AppUserService;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by SHACKOX on 23/10/16.
 */

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public void insertAppUser(AppUser appUser) {
        sessionFactory
                .getCurrentSession()
                .save(appUser);
    }

    @Transactional
    public AppUser getUserByUserName(String userName) {
        return (AppUser) sessionFactory.getCurrentSession()
                .createCriteria(AppUser.class)
                .add(Restrictions.eq("userName", userName))
                .uniqueResult();
    }
}
