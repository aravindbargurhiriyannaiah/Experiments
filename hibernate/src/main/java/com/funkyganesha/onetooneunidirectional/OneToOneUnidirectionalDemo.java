package com.funkyganesha.onetooneunidirectional;

import java.util.Date;

import org.apache.commons.lang.RandomStringUtils;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.funkyganesha.onetooneunidirectional.domain.Address;
import com.funkyganesha.onetooneunidirectional.domain.User;
import com.funkyganesha.util.HibernateUtil;


public class OneToOneUnidirectionalDemo {
    public static void main(String[] args) {
        new OneToOneUnidirectionalDemo().performOperation();
    }

    private void performOperation() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();
        User user = constructTestStudent(constructTestAddress());
        currentSession.save(user);
        System.out.println(user.getId());
        transaction.commit();
    }

    private User constructTestStudent(Address address) {
        User user = new User();
        user.setName(RandomStringUtils.randomAlphabetic(10));
        user.setAddress(address);
        user.setDateOfBirth(new Date());
        return user;
    }

    private Address constructTestAddress() {
        Address address = new Address();
        address.setLine1(RandomStringUtils.randomAlphanumeric(10));
        address.setCity(RandomStringUtils.randomAlphabetic(10));
        address.setState("CA");
        address.setCountry("United States of America");
        address.setPostalCode(RandomStringUtils.randomAlphanumeric(10));
        return address;
    }
}

