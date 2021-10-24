package pans.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class MainSupermercat {
    public static void main(String[] args) throws InterruptedException, ExecutionException {


        int MAX = 2;

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        List<Caixa> llistaTasques = new ArrayList<Caixa>();

        List<Float> list1 = new ArrayList<>();
        List<Float> list2 = new ArrayList<>();

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

        Client client1 = new Client("ClienteUno", list1);
        Client client2 = new Client("ClienteDos",list2);

        List<Client> clientes = new ArrayList<>();
        clientes.add(client1);
        clientes.add(client2);



        for (int i = 0; i < MAX; i++) {
            Caixa calcula = new Caixa(clientes.get(i));
            llistaTasques.add(calcula);
        }

        List<Future<Float>> llistaResultats;

        llistaResultats = executor.invokeAll(llistaTasques);
        executor.shutdown();

        for (int i = 0; i < llistaResultats.size(); i++) {
            Future<Float> resultat = llistaResultats.get(i);
            System.out.println("Resultat tasca " + (i + 1) + " és:" + resultat.get());
        }




    }
}
