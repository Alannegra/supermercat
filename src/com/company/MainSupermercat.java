package com.company;

import java.util.ArrayList;
import java.util.List;

public class MainSupermercat {
    public static void main(String[] args) {

        List<Float> list1 = new ArrayList<>();
        list1.add(2f);
        list1.add(2f);
        list1.add(2f);
        list1.add(2f);
        list1.add(2f);

        Client client1 = new Client("ClienteUno", list1);
        Client client2 = new Client("ClienteDos",list1);





    }
}
