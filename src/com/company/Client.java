package com.company;

import java.util.List;

public class Client {

    private String nom;
    private List<Float> list;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Float> getList() {
        return list;
    }

    public void setList(List<Float> list) {
        this.list = list;
    }

    public Client(int num, List<Float> list) {


        String s = "";
        for (int i = 0; i < 4; i++) {
            double random = Math.random()*(122-97)+97;
            char r = (char)random;
            s += Character.toString(r);
        }

        s = s.substring(0, 1).toUpperCase() + s.substring(1);


        this.nom = s + "\n" + "Cliente numero: " + num;

        this.list = list;
    }



}
