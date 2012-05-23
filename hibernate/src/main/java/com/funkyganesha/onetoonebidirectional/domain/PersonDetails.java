package com.funkyganesha.onetoonebidirectional.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "person_details")
public class PersonDetails {
    private int id;
    private String hairColor;
    private String eyeColor;
    private Person person;

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "foreignKeyGenerator")
    @GenericGenerator(name = "foreignKeyGenerator", strategy = "foreign", parameters = @Parameter(name = "property", value = "person"))
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "hair_color")
    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    @Column(name = "eye_color")
    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    @OneToOne
    @PrimaryKeyJoinColumn
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
