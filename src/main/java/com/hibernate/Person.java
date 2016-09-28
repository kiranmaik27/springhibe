package com.hibernate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by aditya on 9/23/2016.
 */
public class Person {

    private Long id;
    private String first;

    private List<Address> addressList = new ArrayList<Address>();
    private Set<PhoneNumber> phoneNumberSet = new HashSet<PhoneNumber>();

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public Set<PhoneNumber> getPhoneNumberSet() {
        return phoneNumberSet;
    }

    public void setPhoneNumberSet(Set<PhoneNumber> phoneNumberSet) {
        this.phoneNumberSet = phoneNumberSet;
    }

    public void addAddress(Address address) {
        address.setPerson(this);
        addressList.add(address);
    }

    public void addPhone(PhoneNumber number) {
        number.setPerson(this);
        phoneNumberSet.add(number);
    }
}
