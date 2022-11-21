package Ejercicio3;

public class PrimerHiloEj3 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            System.out.print("Hola");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Hilo interrumpido: " + e.getMessage());
                return;
            }
        }
    }
}
