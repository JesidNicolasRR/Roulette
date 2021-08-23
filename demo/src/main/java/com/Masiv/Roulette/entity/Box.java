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
import javax.persistence.Id;

/**
 *
 * @author Nicolas Reina
 */
@Entity

public class Box implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_BOX")
    private BigDecimal idBox;
    @Basic(optional = false)
    @Column(name = "NUMBER_BOX")
    private int numberBox;
    @Basic(optional = false)
    @Column(name = "COLOR")
    private String color;
    public Box() {
    }
    public Box(BigDecimal idBox) {
        this.idBox = idBox;
    }
    public Box(BigDecimal idBox, int numberBox, String color) {
        this.idBox = idBox;
        this.numberBox = numberBox;
        this.color = color;
    }
    public BigDecimal getIdBox() {
        return idBox;
    }
    public void setIdBox(BigDecimal idBox) {
        this.idBox = idBox;
    }
    public int getNumberBox() {
        return numberBox;
    }
    public void setNumberBox(int numberBox) {
        this.numberBox = numberBox;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
}
