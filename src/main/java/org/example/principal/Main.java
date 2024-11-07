package org.example.principal;

import org.example.hilo.OperacionBanco;

import org.example.modelo.Cuenta;
import org.example.persistenciaBase.CuentaDAO;

public class Main {
    public static void main(String[] args) {
        CuentaDAO cuentaDAO = new CuentaDAO();
        Cuenta<Integer> cuenta = cuentaDAO.obtenerCuentaPorId(1);

        if (cuenta != null) {


        Thread deposito1 = new Thread(new OperacionBanco(cuenta, 500000,cuentaDAO));
        Thread deposito2 = new Thread(new OperacionBanco(cuenta, 300000, cuentaDAO));

        deposito1.start();
        deposito2.start();

        try {
            deposito1.join();
            deposito2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    } else {

        System.out.println("No se encontró la cuenta con ID 1.");

    }
}
}