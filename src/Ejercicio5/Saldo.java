package Ejercicio5;

public class Saldo {
    private double saldo;

    public Saldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    private void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    private int sleepAleatorio(){
        int numero = (int)(Math.random()*10000+1);
        return numero;
    }

    public synchronized void anadirSaldo(int id, double cantidad){

        System.out.println("Hilo " + id);
        System.out.println("Saldo inicial: " + saldo);
        this.saldo += cantidad;
        System.out.println("Añadido: "  + cantidad);
        System.out.println("Total: " + saldo);

        try {
            Thread.sleep(sleepAleatorio());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
