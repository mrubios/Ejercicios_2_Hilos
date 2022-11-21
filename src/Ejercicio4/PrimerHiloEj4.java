package Ejercicio4;

import java.util.ArrayList;
import java.util.List;

public class PrimerHiloEj4 implements Runnable {
    List<String> mensajes = new ArrayList<>();
    public static boolean salir = true;
    private int i;

    @Override
    public void run() {
        anadirMensajes();
        try {
        for (i = 0; i < mensajes.stream().count(); i++) {
                System.out.println(mensajes.get(i));
                        Thread.sleep(4000);
        }
        } catch (InterruptedException e) {
            for (i = i+1; i < mensajes.stream().count(); i++) {
                System.out.println(mensajes.get(i));
            }
        }finally {
            salir = false;
        }


    }


    private void anadirMensajes() {
        mensajes.add("Programas");
        mensajes.add("Procesos");
        mensajes.add("Servicios");
        mensajes.add("Hilos");
    }
}
