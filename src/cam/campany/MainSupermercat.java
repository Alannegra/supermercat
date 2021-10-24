package cam.campany;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class MainSupermercat {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        int MAX = 2;


        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(MAX);

        List<Caixa> llistaTasques = new ArrayList<>();



        List<Float> list1 = new ArrayList<>();
        List<Float> list2 = new ArrayList<>();

        list1.add(2.3f);
        list1.add(2f);
        list1.add(3f);
        list1.add(4f);
        list1.add(5f);

        list2.add(0.3f);
        list2.add(1.5f);
        list2.add(3.5f);
        list2.add(4f);
        list2.add(5f);

        Client client1 = new Client("ClienteUno", list1);
        Client client2 = new Client("ClienteDos",list2);

        Client client3 = new Client("Clientetres", list1);
        Client client4 = new Client("Clientecuatro",list2);

        List<Client> clientes = new ArrayList<>();
        List<Client> clientes2 = new ArrayList<>();

        clientes.add(client1);
        clientes.add(client2);

        clientes2.add(client3);
        clientes2.add(client4);



        for (int i = 0; i < clientes.size(); i+=MAX) {
            Caixa calcula = new Caixa(clientes.get(i));
            Caixa calcula2 = new Caixa(clientes.get(i+1));

            llistaTasques.add(calcula);
            llistaTasques.add(calcula2);

        }

        List<Future<Float>> llistaResultats;

        llistaResultats = executor.invokeAll(llistaTasques);

        executor.shutdown();

        for (int i = 0; i < llistaResultats.size(); i++) {
            Future<Float> resultat = llistaResultats.get(i);
            System.out.println("Resultat tasca " + (i + 1) + " és: " + resultat.get());
        }


    }
}
