package com.hibernate;

import com.hibernate.mapping.Honda;
import com.hibernate.mapping.Toyota;
import com.hibernate.mapping.Vehicle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

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

        Toyota toyota = new Toyota();
        toyota.setModel("Camry");
        toyota.setYear("2016");
        toyota.setVin("23234323534543");

        personHibernateService.create(toyota);
    }

    @Test
    public void testGet() {
        Vehicle vehicle = personHibernateService.getVehicleById(1L);
        Assert.notNull(vehicle);
    }

    @Test
    public void testHQL() {
        List<Vehicle> vehicles = personHibernateService.getAllByVin("1");
        Assert.notNull(vehicles);
    }

    @Test
    public void testGetHonda() {
        List<Vehicle> vehicles = personHibernateService.getHondaByModelAndYear("CRV", "2016");
        Assert.notNull(vehicles);
    }

    @Test
    public void testGetToyota() {
        List<Vehicle> vehicles = personHibernateService.getToyotaByModelAndYear("CAMRY", "2017");
        Assert.notNull(vehicles);
    }

    @Test
    public void testGetToyotaSQL() {
        List<Vehicle> vehicles = personHibernateService.getAllToyotaSQL("CAMRY", "2017");
        Assert.notNull(vehicles);
    }
}
