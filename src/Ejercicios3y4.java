import Ejercicio3.PrimerHiloEj3;
import Ejercicio3.SegundoHiloEj3;
import Ejercicio4.PrimerHiloEj4;

import static Ejercicio4.PrimerHiloEj4.salir;

public class Ejercicios3y4 implements Runnable {
    public static void main(String[] args) {
        ejercicio3();
        ejercicio4();

    }

    private static void ejercicio4() {
        System.out.println("EJERCICIO 4");
        System.out.println();

        Thread hilo1 = new Thread(new Ejercicios3y4());
        hilo1.start();

        Thread hilo2 = new Thread(new PrimerHiloEj4());
        hilo2.start();

        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Fin del ejercicio 4");
    }


    private static void ejercicio3() {
        System.out.println("EJERCICIO 3");
        System.out.println();

        PrimerHiloEj3 hilo1 = new PrimerHiloEj3();
        hilo1.ejercicio3();

        SegundoHiloEj3 hilo2 = new SegundoHiloEj3();
        hilo2.ejercicio3();

        hilo1.pararHilo1();

    }

    @Override
    public void run() {
        try {
            while (salir){
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() +  " Esperando");
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
