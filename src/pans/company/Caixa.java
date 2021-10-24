package pans.company;


import java.util.concurrent.Callable;

public class Caixa implements Callable<Float> {


    private float total;

    private Client client;


    public Caixa(Client client) {
        this.client = client;
    }

    public void pasarporcaja (Client client){

        System.out.println("Pedido de: " + client.getNom());


        System.out.println("Total "+total+"€ " + client.getNom());
    }





    @Override
    public Float call() throws Exception {

        for (Float c : client.getList()){
            try {
                total += c;
                Thread.sleep((long)((Math.random()*300)+100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return total;

    }
}
