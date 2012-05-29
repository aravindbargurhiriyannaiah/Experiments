package com.funkyganesha.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.funkyganesha.domain.DomainObject;
import com.funkyganesha.onetomany.domain.College;
import com.funkyganesha.onetomany.domain.Student;
import com.funkyganesha.onetoonebidirectional.domain.Person;
import com.funkyganesha.onetoonebidirectional.domain.PersonDetail;
import com.funkyganesha.onetooneunidirectional.domain.Address;
import com.funkyganesha.onetooneunidirectional.domain.User;


public class HibernateUtil {

    private static Class[] annotatedClassesToBeAdded = {DomainObject.class, Address.class, User.class, Person.class, PersonDetail.class, Student.class, College.class};

    private static class InstanceHolder {

        public static SessionFactory sessionFactory = buildSessionFactory();

        private static SessionFactory buildSessionFactory() {
            SessionFactory factory = null;
            try {
                Configuration configuration = new Configuration();
                configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
                configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
                configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/experiments");
                configuration.setProperty("hibernate.connection.username", "root");
                configuration.setProperty("hibernate.connection.password", "root");
                configuration.setProperty("hibernate.connection.pool_size", "1");
                configuration.setProperty("hibernate.connection.autocommit", "true");
                configuration.setProperty("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");
//                configuration.setProperty("hibernate.hbm2ddl.auto", "create-drop");
                configuration.setProperty("hibernate.show_sql", "true");
                configuration.setProperty("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory");
                configuration.setProperty("hibernate.current_session_context_class", "thread");
                for (Class clazz : annotatedClassesToBeAdded) {
                    configuration.addAnnotatedClass(clazz);
                }
                factory = configuration.buildSessionFactory();
            } catch (HibernateException e) {
                e.printStackTrace();
            }
            return factory;
        }

    }

    public static SessionFactory getSessionFactory() {
        return InstanceHolder.sessionFactory;
    }

    private HibernateUtil() {
    }
}
