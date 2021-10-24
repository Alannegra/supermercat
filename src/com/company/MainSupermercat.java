package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MainSupermercat {
    public static void main(String[] args) {

        int CAJAS = 2;
        int CLIENTES = 2;
        int PRODUCTOS = 5;

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(CAJAS);

        /*List<Float> list1 = new ArrayList<>();
        List<Float> list2 = new ArrayList<>();
        List<Float> list3 = new ArrayList<>();
        List<Float> list4 = new ArrayList<>();

        list1.add(2f);
        list1.add(2f);
        list1.add(3f);
        list1.add(4f);
        list1.add(5f);

        list2.add(1f);
        list2.add(1f);
        list2.add(3.5f);
        list2.add(4f);
        list2.add(5f);

        list3.add(2f);
        list3.add(2f);
        list3.add(3f);
        list3.add(4f);
        list3.add(5f);

        list4.add(1f);
        list4.add(1f);
        list4.add(3.5f);
        list4.add(4f);
        list4.add(5f);

        Client client1 = new Client("ClienteUno", list1);
        Client client2 = new Client("ClienteDos",list2);

        Client client3 = new Client("Clientetres", list3);
        Client client4 = new Client("Clientecuatro",list4);


        List<Client> clientes1 = new ArrayList<>();
        List<Client> clientes2 = new ArrayList<>();

        clientes1.add(client1);
        clientes1.add(client2);

        clientes2.add(client3);
        clientes2.add(client4);*/




        for (int i = 0; i < CAJAS; i++) {
            List<Client> listaclientes = new ArrayList<>();
            for (int j = 0; j < CLIENTES; j++) {
                List<Float> listaproductos = new ArrayList<>();
                for (int k = 0; k < PRODUCTOS; k++) {
                 listaproductos.add((float)Math.random()*5+1);
                }
                listaclientes.add(new Client(j+1 , listaproductos));
            }
            Caixa caixa = new Caixa(listaclientes,i+1);
            executor.execute(caixa);
        }




//        Caixa caixa1 = new Caixa(clientes1);
//        Caixa caixa2 = new Caixa(clientes2);
//
//
//        executor.execute(caixa1);
//        executor.execute(caixa2);


        executor.shutdown();
        //122
        /*double random = Math.random()*(122-97)+97;
        char r = (char)random;
        String s = Character.toString(r);
        System.out.println(s);*/


    }
}
