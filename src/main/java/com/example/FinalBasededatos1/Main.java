package com.example.FinalBasededatos1;

import CRUD.DivisaManager;
import db.DatabaseConnection;
import entidad.Divisa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Connection connection = DatabaseConnection.getConnection()) {
			DivisaManager divisaManager = new DivisaManager(connection);
			Scanner scanner = new Scanner(System.in);
			int opcion;

			do {
				System.out.println("\n--- Menú ---");
				System.out.println("1. Crear Divisa");
				System.out.println("2. Leer Divisas");
				System.out.println("3. Actualizar Divisa");
				System.out.println("4. Eliminar Divisa");
				System.out.println("5. Salir");
				System.out.print("Seleccione una opción: ");
				opcion = scanner.nextInt();

				switch (opcion) {
					case 1:
						System.out.print("Nombre: ");
						String nombre = scanner.next();
						System.out.print("Compra: ");
						double compra = scanner.nextDouble();
						System.out.print("Venta: ");
						double venta = scanner.nextDouble();
						System.out.print("Status (true/false): ");
						boolean status = scanner.nextBoolean();
						divisaManager.crearDivisa(new Divisa(0, nombre, compra, venta, status));
						break;
					case 2:
						divisaManager.leerDivisas().forEach(System.out::println);
						break;
					case 3:
						System.out.print("ID: ");
						int id = scanner.nextInt();
						System.out.print("Nueva Compra: ");
						double nuevaCompra = scanner.nextDouble();
						System.out.print("Nueva Venta: ");
						double nuevaVenta = scanner.nextDouble();
						System.out.print("Nuevo Status (true/false): ");
						boolean nuevoStatus = scanner.nextBoolean();
						divisaManager.actualizarDivisa(new Divisa(id, null, nuevaCompra, nuevaVenta, nuevoStatus));
						break;
					case 4:
						System.out.print("ID a eliminar: ");
						int idEliminar = scanner.nextInt();
						divisaManager.eliminarDivisa(idEliminar);
						break;
					case 5:
						System.out.println("Saliendo...");
						break;
					default:
						System.out.println("Opción inválida.");
				}
			} while (opcion != 5);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

