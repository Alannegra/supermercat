package com.company;


import java.util.List;

public class Caixa implements  Runnable{


    private float total;
    private List<Client> clientes;
    private int numero;

    public Caixa(List<Client> clientes, int numero) {
        this.clientes = clientes;
        this.numero = numero;
    }

    public void pasarporcaja (List<Client> clientes){

        for (Client c : clientes) {

            for ( Float f : c.getList() ) {
                try {
                    total += f;
                    Thread.sleep((long)((Math.random()*300)+100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }



            }
            String decimal = String.format("%.02f", total);
            System.out.println("CAJA " + numero + "\n" + "Pedido de: " + c.getNom() + "\n" + "Total "+ decimal + "€" + "\n");

        }
    }


    @Override
    public void run() {
        pasarporcaja(clientes);
    }



}
