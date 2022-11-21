import Ejercicio3.PrimerHiloEj3;
import Ejercicio3.SegundoHiloEj3;
import Ejercicio4.PrimerHiloEj4;
import Ejercicio5.Hilo;
import Ejercicio5.Saldo;

import java.util.Scanner;
import static Ejercicio4.PrimerHiloEj4.salir;


public class Main implements Runnable {
    public static void main(String[] args) {

        System.out.println("¿Qué ejercicio quieres ejecutar?");
        System.out.println("1- Ejercicio 3");
        System.out.println("2- Ejercicio 4");
        System.out.println("3- Ejercicio 5");
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        sc.nextLine();
        switch (n1){
            case 1: ejercicio3();
                break;
            case 2: ejercicio4();
                break;
            case 3: ejercicio5();
                break;
            default: break;

        }
    }

    private static void ejercicio5() {

        System.out.println("EJERCICIO 5");

        Saldo saldo = new Saldo(10);

        Thread hilo1 = new Thread(new Hilo(saldo, 1, 2.5));
        Thread hilo2 = new Thread(new Hilo(saldo, 2, 5));
        Thread hilo3 = new Thread(new Hilo(saldo, 3, 12.5));

        hilo1.start();
        hilo2.start();
        hilo3.start();

        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Fin del ejercicio 5");

    }

    private static void ejercicio4() {
        Scanner sc = new Scanner(System.in);

        System.out.println("EJERCICIO 4");

        System.out.println("¿Cuanto tiempo quieres esperar?");
        numero = sc.nextInt();
        sc.nextLine();

        Thread hilo1 = new Thread(new Main());
        hilo1.start();

        Thread hilo2 = new Thread(new PrimerHiloEj4());
        hilo2.start();

        try {
            Thread.sleep(numero);
            hilo2.interrupt();
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

        Thread t1 = new Thread(new PrimerHiloEj3());
        t1.start();

        Thread t2 = new Thread(new SegundoHiloEj3());
        t2.start();

        try {
            Thread.sleep(5000);
            t1.interrupt();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void run() {
        try {
            while (salir){
                Thread.sleep(1000);
                if (!salir)break;
                System.out.println(Thread.currentThread().getName() +  " Esperando");
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int numero;
}
