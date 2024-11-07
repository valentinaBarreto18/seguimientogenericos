package org.example.persistenciaBase;
import org.example.modelo.Cuenta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CuentaDAO {

    public Cuenta<Integer> obtenerCuentaPorId(int cuentaId) {
        String query = "SELECT * FROM cuentas WHERE id = ?";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, cuentaId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                double saldo = resultSet.getDouble("saldo");
                return new Cuenta<>(id, saldo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void actualizarSaldo(Cuenta<Integer> cuenta) {
        String query = "UPDATE cuentas SET saldo = ? WHERE id = ?";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setDouble(1, cuenta.getSaldo());
            statement.setInt(2, cuenta.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



