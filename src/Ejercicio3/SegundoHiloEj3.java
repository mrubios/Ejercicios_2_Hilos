package Ejercicio3;

public class SegundoHiloEj3 implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 15; i++) {
            System.out.println(" Mundo!");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
