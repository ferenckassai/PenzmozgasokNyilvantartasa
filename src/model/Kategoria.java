/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class Kategoria {

    
    private int id;
    private String nev;
    private int tipus;

    public Kategoria() {
    }

    public Kategoria(int id, String nev, int tipus) {
        this.id = id;
        this.nev = nev;
        this.tipus = tipus;
    }

    public Kategoria(String nev, int tipus) {
        this.nev = nev;
        this.tipus = tipus;
    }

    public int getTipus() {
        return tipus;
    }

    public void setTipus(int tipus) {
        this.tipus = tipus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    @Override
    public String toString() {
        return nev;
    }

    private static int BEVETEL = 0;
    private static int KIADAS = 1;

    public static int getBEVETEL() {
        return BEVETEL;
    }

    public static void setBEVETEL(int aBEVETEL) {
        BEVETEL = aBEVETEL;
    }

    public static int getKIADAS() {
        return KIADAS;
    }

    public static void setKIADAS(int aKIADAS) {
        KIADAS = aKIADAS;
    }

}
