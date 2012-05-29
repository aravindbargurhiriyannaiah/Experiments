package com.funkyganesha.onetoonebidirectional;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.funkyganesha.onetoonebidirectional.domain.Person;
import com.funkyganesha.onetoonebidirectional.domain.PersonDetail;
import com.funkyganesha.util.HibernateUtil;

public class OneToOneBidirectionalDemo {
    public static void main(String[] args) {
        new OneToOneBidirectionalDemo().performOperation();
    }

    private void performOperation() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction transaction = currentSession.getTransaction();
        transaction.begin();
        for (Person person : constructTestPerson()) {
            currentSession.save(person);
        }
        transaction.commit();
    }

    private List<Person> constructTestPerson() {
        List<Person> personList = new ArrayList<Person>();
        Person person;
        PersonDetail personDetail;
        for (int i = 0; i < 5; i++) {
            person = new Person();
            person.setName(RandomStringUtils.randomAlphabetic(10));
            personDetail = new PersonDetail();
            personDetail.setSsn(RandomStringUtils.randomNumeric(10));
            person.setPersonDetail(personDetail);
            personList.add(person);
        }
        return personList;
    }

}
