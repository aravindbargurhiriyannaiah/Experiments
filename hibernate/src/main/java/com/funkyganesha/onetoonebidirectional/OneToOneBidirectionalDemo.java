package com.funkyganesha.onetoonebidirectional;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.funkyganesha.onetoonebidirectional.domain.Person;
import com.funkyganesha.onetoonebidirectional.domain.PersonDetails;
import com.funkyganesha.onetoonebidirectional.domain.Professional;
import com.funkyganesha.onetoonebidirectional.domain.Skill;
import com.funkyganesha.util.HibernateUtil;

public class OneToOneBidirectionalDemo {
    public static void main(String[] args) {
//        new OneToOneBidirectionalDemo().performOperation();
        new OneToOneBidirectionalDemo().performPersonOperation();
    }

    private void performPersonOperation() {
        Person person = new Person();
        person.setFirstName("Aravind");
        person.setLastName("Bargur Hiriyannaiah");
        PersonDetails personDetails = new PersonDetails();
        personDetails.setEyeColor("Brown");
        personDetails.setHairColor("Black");
        person.setPersonDetails(personDetails);
        personDetails.setPerson(person);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction transaction = currentSession.getTransaction();
        transaction.begin();
        currentSession.save(person);
        transaction.commit();
        System.out.println(person.getId());
        System.out.println(personDetails.getId());

    }

    private void performOperation() {
        Skill skill = constructTestSkill();
        Professional professional = createTestProfessional();
        skill.setProfessional(professional);
        professional.setSkill(skill);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.save(professional);
        transaction.commit();
        System.out.println(professional.getId());
        System.out.println(skill.getId());
    }

    private Skill constructTestSkill() {
        Skill skill = new Skill();
        skill.setApplicationServer("Tomcat");
        skill.setCertification("SCEA");
        skill.setDomainExpertise("Advertisement");
        skill.setOperatingSystem("*nix");
        skill.setYearsOfExperience(5);
        skill.setProgrammingLanguage("Java");
        return skill;
    }

    private Professional createTestProfessional() {
        Professional professional = new Professional();
        professional.setName("Aravind Bargur Hiriyannaiah");
        return professional;
    }


}
