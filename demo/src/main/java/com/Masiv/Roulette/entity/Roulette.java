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
public class Roulette implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ROC")
    private BigDecimal idRoc;
    @Basic(optional = false)
    @Column(name = "NAME_ROC")
    private String nameRoc;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Roulette() {
    }
    public Roulette(BigDecimal idRoc) {
        this.idRoc = idRoc;
    }
    public Roulette(BigDecimal idRoc, String nameRoc, String estado) {
        this.idRoc = idRoc;
        this.nameRoc = nameRoc;
        this.estado = estado;
    }
    public BigDecimal getIdRoc() {
        return idRoc;
    }
    public void setIdRoc(BigDecimal idRoc) {
        this.idRoc = idRoc;
    }
    public String getNameRoc() {
        return nameRoc;
    }
    public void setNameRoc(String nameRoc) {
        this.nameRoc = nameRoc;
    }

}
