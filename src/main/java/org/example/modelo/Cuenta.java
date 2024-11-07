package org.example.modelo;

public class Cuenta <T>{
    private T id;
    private double saldo;

    public Cuenta(T id, double saldo) {
        this.id = id;
        this.saldo = saldo;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
