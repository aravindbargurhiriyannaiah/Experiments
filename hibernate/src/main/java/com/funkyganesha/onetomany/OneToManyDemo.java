package com.funkyganesha.onetomany;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.funkyganesha.onetomany.domain.College;
import com.funkyganesha.onetomany.domain.Student;
import com.funkyganesha.util.HibernateUtil;

public class OneToManyDemo {
    public static void main(String[] args) {
        new OneToManyDemo().performOperation();
    }

    private void performOperation() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        College college = constructTestCollege();
        session.save(college);
        transaction.commit();
    }

    private College constructTestCollege() {
        College college = new College();
        college.setStudents(new ArrayList<Student>());
        college.setName("UCSD");
        Student student = new Student();
        student.setName("Aravind");
        college.addStudent(student);
        student = new Student();
        student.setName("Bargur");
        college.addStudent(student);
        return college;
    }

}
