package M09UF02A04v2;

public class Client extends Thread{
    private Barberia barberia;

    private boolean estaEnLaPelu = false;

    private int longitudCabell;

    private final int CABELL_LLARG = 10;

    private final int TEMPS_DE_CREIXE = 100;

    public Client(String nom, Barberia barberia) {
        super(nom);
        this.barberia = barberia;
        longitudCabell = 0;
    }

    private void esperarQueCreixiElCabell(){
        while (longitudCabell<CABELL_LLARG){
            try {
                Thread.sleep(TEMPS_DE_CREIXE);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            longitudCabell++;
        }
    }
    private void anarAlaPelu(){
       estaEnLaPelu = barberia.entraClient(this);
    }

    public void sortirDeLaPelu(){
        estaEnLaPelu = false;
    }

    @Override
    public void run() {
        while (true){
            if(!estaEnLaPelu){
                esperarQueCreixiElCabell();
                anarAlaPelu();
            }
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void setLongitudCabell(int longitudCabell) {
        this.longitudCabell = longitudCabell;
    }
}
