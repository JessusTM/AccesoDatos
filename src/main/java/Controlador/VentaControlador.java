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
    private CdRepositorio       repositorioCd;
    private CaseteRepositorio   repositorioCasete;

    public VentaControlador() {
        this.repositorioVenta   = new VentaRepositorio();
        this.repositorioVinilo  = new ViniloRepositorio();
        this.repositorioCd      = new CdRepositorio();
        this.repositorioCasete  = new CaseteRepositorio();
    }

    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }



    public void guardarVentaVinilo(Long idVinilo, Integer cantidad) {
        Vinilo vinilo = repositorioVinilo.porId(idVinilo);
        if (vinilo != null) {
            if (vinilo.getStock() >= cantidad) {
                Date fechaActual    = new Date();
                Venta venta         = new Venta(null, idVinilo, "Vinilo", cantidad, fechaActual);
                repositorioVenta.guardar(venta);
                actualizarStockVinilo(idVinilo, cantidad);
            } else {
                System.out.println("        No hay suficiente stock disponible...");
            }
        } else {
            System.out.println("        Vinilo no encontrado...");
        }
    }

    private void actualizarStockVinilo(Long idVinilo, int cantidadVenta) {
        String sql = "UPDATE Vinilos SET stock = stock - ? WHERE idVinilo = ?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt (1, cantidadVenta   );
            stmt.setLong(2, idVinilo        );
            stmt.executeUpdate();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }





    public void guardarVentaCd(Long idCd, Integer cantidad) {
        Cd cd = repositorioCd.porId(idCd);
        if (cd != null) {
            if (cd.getStock() >= cantidad) {
                Date fechaActual    = new Date();
                Venta venta         = new Venta(null, idCd, "Cd", cantidad, fechaActual);
                repositorioVenta.guardar(venta);
                actualizarStockCd(idCd, cantidad);
            } else {
                System.out.println("        No hay suficiente stock disponible...");
            }
        } else {
            System.out.println("        CD no encontrado...");
        }
    }

    private void actualizarStockCd(Long idCd, int cantidadVenta) {
        String sql = "UPDATE Cds SET stock = stock - ? WHERE idcd = ?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt (1, cantidadVenta   );
            stmt.setLong(2, idCd            );
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





    public void guardarVentaCasete(Long idCasete, Integer cantidad) {
        Casete casete = repositorioCasete.porId(idCasete);
        if (casete != null) {
            if (casete.getStock() >= cantidad) {
                Date fechaActual    = new Date();
                Venta venta         = new Venta(null, idCasete, "Casete", cantidad, fechaActual);
                repositorioVenta.guardar(venta);
                actualizarStockCasete(idCasete, cantidad);
            } else {
                System.out.println("        No hay suficiente stock disponible...");
            }
        } else {
            System.out.println("        CD no encontrado...");
        }
    }

    private void actualizarStockCasete(Long idCasete, int cantidadVenta) {
        String sql = "UPDATE Casetes SET stock = stock - ? WHERE idcasete = ?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt (1, cantidadVenta   );
            stmt.setLong(2, idCasete        );
            stmt.executeUpdate();
        } catch (SQLException e) {
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

