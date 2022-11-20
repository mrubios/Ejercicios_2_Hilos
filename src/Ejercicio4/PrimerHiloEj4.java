package Ejercicio4;

import Ejercicio3.SegundoHiloEj3;

import java.util.ArrayList;
import java.util.List;

public class PrimerHiloEj4 implements Runnable {
    List<String> mensajes = new ArrayList<>();
    public static boolean salir = true;

    @Override
    public void run() {
        anadirMensajes();

        for (int i = 0; i < mensajes.stream().count(); i++) {
            if (i!= 0){
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(mensajes.get(i));
        }
        salir = false;


    }


    private void anadirMensajes() {
        mensajes.add("Programas");
        mensajes.add("Procesos");
        mensajes.add("Servicios");
        mensajes.add("Hilos");
    }
}
