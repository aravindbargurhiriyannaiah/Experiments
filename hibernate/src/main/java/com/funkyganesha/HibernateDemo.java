package com.funkyganesha;

import org.apache.commons.lang.RandomStringUtils;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.funkyganesha.domain.DomainObject;
import com.funkyganesha.util.HibernateUtil;

public class HibernateDemo {
    public static void main(String[] args) {
        Session session1 = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction1 = session1.beginTransaction();
        saveObject(session1, transaction1);
        Session session2 = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction2 = session2.beginTransaction();
        saveObject(session2, transaction2);

    }

    private static void saveObject(Session session, Transaction transaction) {
        DomainObject domainObject1 = constructTestObject();
        session.save(domainObject1);
        DomainObject domainObject2 = constructTestObject();
        session.save(domainObject2);
        transaction.commit();
        System.out.println("Contents of the table");
        System.out.println("domainObject1.id = " + domainObject1.getId());
        System.out.println("domainObject2.id = " + domainObject2.getId());
    }

    private static DomainObject constructTestObject() {
        DomainObject domainObject = new DomainObject();
        domainObject.setName(RandomStringUtils.randomAlphabetic(10));
        return domainObject;
    }

}
