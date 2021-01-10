package org.java.multi.data.source.nasa.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "astronaut_info")
public class Astronaut {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "astronaut_id")
    private Long id;

    @Column(name = "astronaut_fname")
    private String firstName;

    @Column(name = "astronaut_lname")
    private String lastName;

    @Column(name = "astronaut_dob")
    private Date datOfBirth;

    @Column(name = "astronaut_country")
    private String country;

    @Column(name = "astronaut_gender")
    private Character gender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDatOfBirth() {
        return datOfBirth;
    }

    public void setDatOfBirth(Date datOfBirth) {
        this.datOfBirth = datOfBirth;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }
}
