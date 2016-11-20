package com.shackox.service.impl;

import com.shackox.model.UserRole;
import com.shackox.service.UserRoleService;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by SHACKOX on 19/11/16.
 */

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public UserRole getRoleUser() {
        return (UserRole) sessionFactory
                .getCurrentSession()
                .createCriteria(UserRole.class)
                .add(Restrictions.eq("roleName", "ROLE_USER"))
                .uniqueResult();
    }
}
