package CRUD;
import entidad.Divisa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DivisaManager {
    private Connection connection;

    public DivisaManager(Connection connection) {
        this.connection = connection;
    }

    // Crear una nueva divisa
    public void crearDivisa(Divisa divisa) throws SQLException {
        String sql = "INSERT INTO divisas (nombre, compra, venta, status) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, divisa.getNombre());
            statement.setDouble(2, divisa.getCompra());
            statement.setDouble(3, divisa.getVenta());
            statement.setBoolean(4, divisa.isStatus());
            statement.executeUpdate();
            System.out.println("Divisa creada exitosamente.");
        }
    }

    // Leer todas las divisas
    public List<Divisa> leerDivisas() throws SQLException {
        String sql = "SELECT * FROM divisas";
        List<Divisa> divisas = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Divisa divisa = new Divisa(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getDouble("compra"),
                        resultSet.getDouble("venta"),
                        resultSet.getBoolean("status")
                );
                divisas.add(divisa);
            }
        }
        return divisas;
    }

    // Actualizar una divisa
    public void actualizarDivisa(Divisa divisa) throws SQLException {
        String sql = "UPDATE divisas SET compra = ?, venta = ?, status = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, divisa.getCompra());
            statement.setDouble(2, divisa.getVenta());
            statement.setBoolean(3, divisa.isStatus());
            statement.setInt(4, divisa.getId());
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Divisa actualizada exitosamente.");
            } else {
                System.out.println("No se encontró la divisa con el ID especificado.");
            }
        }
    }

    // Eliminar una divisa
    public void eliminarDivisa(int id) throws SQLException {
        String sql = "DELETE FROM divisas WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Divisa eliminada exitosamente.");
            } else {
                System.out.println("No se encontró la divisa con el ID especificado.");
            }
        }
    }
}
