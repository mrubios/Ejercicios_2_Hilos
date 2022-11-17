import Ejercicio3.PrimerHilo;
import Ejercicio3.SegundoHilo;

public class Ejercicios {
    public static void main(String[] args) {
        ejercicio3();
    }

    private static void ejercicio3() {
        System.out.println("EJERCICIO 3");
        System.out.println();

        PrimerHilo hilo1 = new PrimerHilo();
        hilo1.ejercicio3();

        SegundoHilo hilo2 = new SegundoHilo();
        hilo2.ejercicio3();

        hilo1.pararHilo1();

    }

}
