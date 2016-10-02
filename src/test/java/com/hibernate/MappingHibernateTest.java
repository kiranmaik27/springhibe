package com.hibernate;

import com.hibernate.mapping.Honda;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Kiranmai on 10/1/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/hibernate.xml")
@Transactional
public class MappingHibernateTest {

    @Autowired
    private PersonHibernateService personHibernateService;

    @Test
    @Rollback(false)
    public void createVehicle(){

        Honda honda = new Honda();
        honda.setVin("12132434535");
        honda.setModel("CRV");
        honda.setYear("2016");

        personHibernateService.create(honda);


    }
}
