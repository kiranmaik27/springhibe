package com.hibernate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by aditya on 9/23/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/hibernate.xml"})
@Transactional
public class SpringHibernateTest {

    @Autowired
    private PersonHibernateService personHibernateService;

    @Test
    @Rollback(false)
    public void createPersonTest() {
        Person p = new Person();
        p.setFirst("ADitya");
        personHibernateService.createPerson(p);
    }



}
