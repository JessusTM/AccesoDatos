package Controlador;

import Modelo.*;
import Repositorio.*;
import Util.ConexionBaseDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class VentaControlador {
    private VentaRepositorio    repositorioVenta;
    private ViniloRepositorio   repositorioVinilo;

    public VentaControlador() {
        this.repositorioVenta   = new VentaRepositorio();
        this.repositorioVinilo  = new ViniloRepositorio();
    }

    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }



    public void guardarVentaVinilo(Long idVinilo, Integer cantidad) {
        Vinilo vinilo = repositorioVinilo.porId(idVinilo);
        if (vinilo != null) {
            if (vinilo.getStock() >= cantidad) {
                Date fechaActual = new Date();
                Venta venta = new Venta(null, idVinilo, "Vinilo", cantidad, fechaActual);
                repositorioVenta.guardar(venta);
                actualizarStockVinilo(idVinilo, cantidad);
            } else {
                System.out.println("No hay suficiente stock disponible.");
            }
        } else {
            System.out.println("Vinilo no encontrado.");
        }
    }

    private void actualizarStockVinilo(Long idVinilo, int cantidadVenta) {
        String sql = "UPDATE Vinilos SET stock = stock - ? WHERE idVinilo = ?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, cantidadVenta);
            stmt.setLong(2, idVinilo);
            stmt.executeUpdate();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }



    public void eliminarVenta(Long idVenta) {
        repositorioVenta.eliminar(idVenta);
    }

    public java.util.List<Venta> listarVentas() {
        return repositorioVenta.listar();
    }

    public Venta obtenerVentaPorId(Long idVenta) {
        return repositorioVenta.porId(idVenta);
    }
    }

