import Ejercicio3.PrimerHiloEj3;
import Ejercicio3.SegundoHiloEj3;
import Ejercicio4.PrimerHiloEj4;

import java.util.Scanner;

import static Ejercicio4.PrimerHiloEj4.acabar;
import static Ejercicio4.PrimerHiloEj4.salir;


public class Ejercicios3y4 implements Runnable {
    public static void main(String[] args) {
        //ejercicio3();
        ejercicio4();

    }

    private static void ejercicio4() {
        Scanner sc = new Scanner(System.in);

        System.out.println("EJERCICIO 4");
        System.out.println("¿Cuanto tiempo quieres esperar?");
        numero = sc.nextInt();
        sc.nextLine();


        Thread hilo1 = new Thread(new Ejercicios3y4());
        hilo1.start();

        Thread hilo2 = new Thread(new PrimerHiloEj4());
        hilo2.start();

        try {
            Thread.sleep(numero);
            acabar = false;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Fin del ejercicio 4");
        sc.close();


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

    public static int numero;
}
