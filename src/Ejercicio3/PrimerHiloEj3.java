package Ejercicio3;

public class PrimerHiloEj3 implements Runnable{

    Thread t1;
    public void ejercicio3(){
        t1 = new Thread(new PrimerHiloEj3());
        t1.start();
    }
    public void pararHilo1(){
        try {
            Thread.sleep(5000);
            t1.interrupt();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
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
