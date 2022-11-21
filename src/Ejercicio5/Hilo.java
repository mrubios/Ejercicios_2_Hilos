package Ejercicio5;

public class Hilo implements Runnable {

    private Saldo saldo;
    private int id;
    private double cantidad;

    public Hilo(Saldo saldo, int id, double cantidad) {
        this.saldo = saldo;
        this.id = id;
        this.cantidad = cantidad;
    }

    @Override
    public void run() {
        saldo.anadirSaldo(id, cantidad);
    }
}
