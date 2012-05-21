package com.funkyganesha.domain.onetoone;

import java.util.Date;

import org.apache.commons.lang.RandomStringUtils;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.funkyganesha.util.HibernateUtil;

public class OneToOneDemo {
    public static void main(String[] args) {
        new OneToOneDemo().performOperation();
    }

    private void performOperation() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();
        Student student = constructTestStudent(constructTestAddress());
        currentSession.save(student);
        System.out.println(student.getId());
        transaction.commit();


    }

    private Student constructTestStudent(Address address) {
        Student student = new Student();
        student.setName(RandomStringUtils.randomAlphabetic(10));
        student.setAddress(address);
        student.setDateOfBirth(new Date());
        return student;
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
