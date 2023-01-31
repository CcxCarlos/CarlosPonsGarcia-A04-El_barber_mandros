package M09UF02A04v2;

public class Barberia {
    private final int espaiBarberia;
    private final Client[] clients;

    private int seguentClient;

    public Barberia(int espaiBarberia){
        this.espaiBarberia = espaiBarberia;
        this.clients = new Client[espaiBarberia];
        seguentClient = 0;
    }
    public boolean quedenClients(){
        for (Client c : clients) {
            if (c!=null) return true;
        }
        return false;
    }

    public int hiHaLloc(){
        int pos = 0;
        for (Client c : clients) {
            if (pos>=seguentClient){
                if (c==null) return pos;
            }
            pos++;
        }
        return -1;
    }

    public synchronized Client seguent(){
        Client c = clients[seguentClient];
        clients[seguentClient] = null;
        seguentClient++;
        seguentClient%=espaiBarberia;
        if (quedenClients()) System.out.println("Següent client en espera [" + clients[seguentClient].getName() + "]");
        return c;

    }
    public synchronized boolean entraClient(Client client){
        int pos = hiHaLloc();
        if (hiHaLloc()==-1) return false;
        clients[pos] = client;
        System.out.println("Entra el client: [" + client.getName() + "]");
        return true;
    }
    public synchronized void surtClient(Client client){
        client.sortirDeLaPelu();

    }

}
