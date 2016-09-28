package com.hibernate.listener;

import org.hibernate.HibernateException;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.hibernate.event.spi.SaveOrUpdateEventListener;
import org.springframework.stereotype.Component;

/**
 * Created by Kiranmai on 9/28/16.
 */
@Component
public class EntitySaveListener implements SaveOrUpdateEventListener {

    public void onSaveOrUpdate(SaveOrUpdateEvent event) throws HibernateException {
        Object obj = event.getEntity();
        System.out.print(obj);
    }
}
