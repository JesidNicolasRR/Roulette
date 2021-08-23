/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Masiv.Roulette.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Nicolas Reina
 */
@Entity
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PERSON")
    private BigDecimal idPerson;
    @Basic(optional = false)
    @Column(name = "NAME_PERSON")
    private String namePerson;
    @Column(name = "CREDIT")
    private int credit;
    public Person() {
    }
    public Person(BigDecimal idPerson) {
        this.idPerson = idPerson;
    }
    public Person(BigDecimal idPerson, String namePerson) {
        this.idPerson = idPerson;
        this.namePerson = namePerson;
    }
    public BigDecimal getIdPerson() {
        return idPerson;
    }
    public void setIdPerson(BigDecimal idPerson) {
        this.idPerson = idPerson;
    }
    public String getNamePerson() {
        return namePerson;
    }
    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }
    public int getCredit() {
        return credit;
    }
    public void setCredit(int credit) {
        this.credit = credit;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerson != null ? idPerson.hashCode() : 0);
        return hash;
    }
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.idPerson == null && other.idPerson != null) || (this.idPerson != null && !this.idPerson.equals(other.idPerson))) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "com.Masiv.Roulette.entity.Person[ idPerson=" + idPerson + " ]";
    }
    
}
