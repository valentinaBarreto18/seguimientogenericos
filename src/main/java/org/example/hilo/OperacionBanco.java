package org.example.hilo;

import org.example.modelo.Cuenta;
import org.example.persistenciaBase.CuentaDAO;

public class OperacionBanco  implements  Runnable {
    private final Cuenta<Integer> cuenta;
    private final double monto;
    private final CuentaDAO cuentaDAO;


    public OperacionBanco(Cuenta<Integer> cuenta, double monto, CuentaDAO cuentaDAO) {
        this.cuenta = cuenta;
        this.monto = monto;
        this.cuentaDAO = cuentaDAO;
    }

    @Override
    public void run() {
        synchronized (cuenta) {
            double nuevoSaldo = cuenta.getSaldo() + monto;
            cuenta.setSaldo(nuevoSaldo);
            cuentaDAO.actualizarSaldo(cuenta);
            System.out.println("Nuevo saldo: " + cuenta.getSaldo());
        }
    }
}
