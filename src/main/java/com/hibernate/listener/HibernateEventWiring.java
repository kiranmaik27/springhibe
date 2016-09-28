package com.hibernate.listener;

import org.hibernate.SessionFactory;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Kiranmai on 9/28/16.
 */
@Component
public class HibernateEventWiring {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private EntityLoadListener entityLoadListener;

    @Autowired
    private EntitySaveListener entitySaveListener;

    @PostConstruct
    public void registerListeners() {
        EventListenerRegistry registry = ((SessionFactoryImpl) sessionFactory).getServiceRegistry().getService(
                EventListenerRegistry.class);

        registry.getEventListenerGroup(EventType.LOAD).appendListener(entityLoadListener);
        registry.getEventListenerGroup(EventType.SAVE).appendListener(entitySaveListener);
        registry.getEventListenerGroup(EventType.SAVE_UPDATE).appendListener(entitySaveListener);
    }
}
