package M09UF02A04v2;

public class Barri {

    private final static int N_CLIENTS = 30;

    public static void main(String[] args) {
        Barberia barberia = new Barberia(5);
        Barber barber = new Barber(barberia);

        barber.start();
        for (int i = 0; i < N_CLIENTS; i++) {
            new Client(Integer.toString(i), barberia).start();
        }
    }
}
