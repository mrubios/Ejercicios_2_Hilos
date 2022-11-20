package Ejercicio4;

import java.util.ArrayList;
import java.util.List;

public class PrimerHiloEj4 implements Runnable {
    List<String> mensajes = new ArrayList<>();
    public static boolean salir = true;
    public static boolean acabar = true;

    @Override
    public void run() {
        anadirMensajes();

        for (int i = 0; i < mensajes.stream().count(); i++) {
            if (acabar){
                if (i!= 0){
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(mensajes.get(i));
            }else{
                System.out.println(mensajes.get(i));
            }
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
