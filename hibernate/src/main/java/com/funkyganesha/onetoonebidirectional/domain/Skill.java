package com.funkyganesha.onetoonebidirectional.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "skill")
public class Skill implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String programmingLanguage;
    private int yearsOfExperience;
    private String operatingSystem;
    private String applicationServer;
    private String certification;
    private String domainExpertise;
    private Professional professional;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "programming_language")
    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    @Column(name = "years_of_experience")
    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    @Column(name = "operating_system")
    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    @Column(name = "application_server")
    public String getApplicationServer() {
        return applicationServer;
    }

    public void setApplicationServer(String applicationServer) {
        this.applicationServer = applicationServer;
    }

    @Column(name = "certification")
    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    @Column(name = "domain_expertise")
    public String getDomainExpertise() {
        return domainExpertise;
    }

    public void setDomainExpertise(String domainExpertise) {
        this.domainExpertise = domainExpertise;
    }

    @OneToOne
    @PrimaryKeyJoinColumn
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }
}
