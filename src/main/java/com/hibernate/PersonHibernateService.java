package com.hibernate;

import com.hibernate.mapping.Toyota;
import com.hibernate.mapping.Vehicle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by aditya on 9/23/2016.
 */
@Service
@Transactional
public class PersonHibernateService{

    //private static final Logger logger = LogManager.getLogger(PersonHibernateService.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void createPerson(Person p) {
        //p.setId(1L);
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(p);
        /*logger.info("Done saving person...");

        if (logger.isDebugEnabled()) {
            logger.debug("I am on DEGUG Mode");
        }

        if(logger.isInfoEnabled()) {
            logger.info("Check INFO..");
        }*/

    }
    /**
     *
     * @param id
     * @return
     */
    public Person getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Person p = session.load(Person.class, id);
        Hibernate.initialize(p);

        return p;

    }

    public void create(Vehicle vehicle){
        sessionFactory.getCurrentSession().saveOrUpdate(vehicle);
    }

    /**
     * @param id
     * @return
     */
    public Vehicle getVehicleById(Long id) {
        return sessionFactory.getCurrentSession().load(Vehicle.class, id);
    }

    public List<Vehicle> getAllByVin(String vinStart) {

        Session session = sessionFactory.getCurrentSession();

        String hql = "from Vehicle v where v.vin like '" + vinStart + "%'";


        Query query = session.createQuery(hql);

        List<Vehicle> vehicles = query.list();

        return vehicles;


    }


    public List<Vehicle> getHondaByModelAndYear(String model, String year) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Honda h where h.model=:model and h.year=:year")
                .setParameter("model", model)
                .setParameter("year", year);

        return query.list();


    }

    public List<Vehicle> getToyotaByModelAndYear(String model, String year) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("query.getToyotaByModelAndYear")
                .setParameter("model", model)
                .setParameter("year", year);
        return query.list();


    }


    public List<Vehicle> getAllToyotaSQL(String model, String year) {
        Session session = sessionFactory.getCurrentSession();
        NativeQuery nativeQuery = session.getNamedNativeQuery("query.sql.toyota")
                .setParameter("model", model)
                .setParameter("year", year);

        nativeQuery.addEntity(Toyota.class);

        List<Vehicle> all = nativeQuery.list();

        return all;


    }
}
