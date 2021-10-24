package pans.company;

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

    public Client(String nom, List<Float> list) {
        this.nom = nom;
        this.list = list;
    }



}
