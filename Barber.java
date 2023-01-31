package M09UF02A04v2;

public class Barber extends Thread{
    private Barberia barberia;

    private final int SLEEP_TIME = 300;
    private final int TALL_TIME = 100;

    private final int NOVA_LONGITUD_CABELL = 0;

    private final int MAX_CLIENTS_X_TORN = 5;

    private int nClientsFets;

    public Barber(Barberia barberia) {
        this.barberia = barberia;
        nClientsFets = 0;
    }

    public void tallarCabell(Client client){
        try {
            System.out.println("Tallant el cabell a:[" + client.getName()+ "]" );
            sleep(TALL_TIME );
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        client.setLongitudCabell(NOVA_LONGITUD_CABELL);
        barberia.surtClient(client);
    }

    public void ferMigDiada(){
        try {
            System.out.println("Barber fent migdiada...");
            sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        while (true){
            if (barberia.quedenClients() && nClientsFets!=MAX_CLIENTS_X_TORN){
                System.out.println("quedentClients → Si");
                tallarCabell(barberia.seguent());
                nClientsFets++;
                nClientsFets%=(MAX_CLIENTS_X_TORN + 1);
            }else {
                ferMigDiada();
                nClientsFets = 0;
            }
        }
    }
}
