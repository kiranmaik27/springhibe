package com.hibernate.web;

import com.hibernate.Person;
import com.hibernate.PersonHibernateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by vashishta on 10/5/16.
 */
@Controller
@RequestMapping(value = "/hello")
public class HelloController {

    @Autowired
    private PersonHibernateService personHibernateService;


    @RequestMapping(method = RequestMethod.GET)
    public String show(Model model, @RequestParam(name = "id", required = false) Long id) {
        HelloForm helloForm = new HelloForm();
        helloForm.setPrefix("Mr.");


        if (id != null) {
            Person p = personHibernateService.getById(id);
            helloForm.setPerson(p);
        }

        model.addAttribute("helloForm", helloForm);
        return "hello";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String save(@ModelAttribute("helloForm") HelloForm helloForm) {

        Person p = helloForm.getPerson();
        personHibernateService.createPerson(p);

        return "goodbye";
    }

}
