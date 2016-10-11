package com.hibernate.web;

import com.hibernate.Person;

/**
 * Created by Kiranmai on 10/11/16.
 */
public class HelloForm {

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    private String prefix;
    private Person person = new Person();

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
