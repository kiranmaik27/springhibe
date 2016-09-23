package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by aditya on 9/23/2016.
 */
@Service
@Transactional
public class PersonHibernateService{

    @Autowired
    private SessionFactory sessionFactory;

    public void createPerson(Person p){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(p);
    }
}
