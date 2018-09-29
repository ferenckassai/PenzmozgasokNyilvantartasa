/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author javaoktatashu
 */
public class Penzmozgas {
    
    private int id;   
    private int osszeg;
    private LocalDate datum;
    private String megjegyzes;
    private int idKategoria;
    
    
    public Penzmozgas() {
    }

    public Penzmozgas(int id, int osszeg, LocalDate datum, String megjegyzes, int idKategoria) {
        this.id = id;
        this.osszeg = osszeg;
        this.datum = datum;
        this.megjegyzes = megjegyzes;
        this.idKategoria = idKategoria;
    }

    public Penzmozgas(int osszeg, LocalDate datum, String megjegyzes, Kategoria kategoria) {
        this.osszeg = osszeg;
        this.datum = datum;
        this.megjegyzes = megjegyzes;
       this.idKategoria = idKategoria;
    }

    public int getKategoria() {
        return idKategoria;
    }

    @Override
    public String toString() {
        return osszeg + " Ft, "  + datum + ", " + megjegyzes;
    }

    public int getIdKategoria() {
        return idKategoria;
    }

    public void setIdKategoria(int idKategoria) {
        this.idKategoria = idKategoria;
    }

    public void setKategoria(Kategoria kategoria) {
        this.idKategoria = idKategoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOsszeg() {
        return osszeg;
    }

    public void setOsszeg(int osszeg) {
        this.osszeg = osszeg;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public String getMegjegyzes() {
        return megjegyzes;
    }

    public void setMegjegyzes(String megjegyzes) {
        this.megjegyzes = megjegyzes;
    }
    
    
}
