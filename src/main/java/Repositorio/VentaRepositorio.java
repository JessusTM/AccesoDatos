package Repositorio;

import Modelo.Venta;
import Util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VentaRepositorio implements Repositorio<Venta> {
    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getConnection();
    }



    private static Venta crearVenta(ResultSet rs) throws SQLException {
        Venta v = new Venta();
        v.setIdVenta        (rs.getLong     ("idventa"      ));
        v.setIdProducto     (rs.getLong     ("idproducto"   ));
        v.setTipoProducto   (rs.getString   ("tipoproducto" ));
        v.setCantidad       (rs.getInt      ("cantidad"     ));
        v.setFechaVenta     (rs.getDate     ("fechaventa"   ));
        return v;
    }



    @Override
    public List<Venta> listar() {
        String sql          = "SELECT * FROM Ventas";
        List<Venta> ventas  = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement  stmt = conn.createStatement();
             ResultSet  rs   = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Venta v = crearVenta(rs);
                ventas.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ventas;
    }



    @Override
    public Venta porId(Long id) {
        Venta venta = null;
        String sql  = "SELECT * FROM Ventas WHERE idventa = ?";
        try (Connection         conn = getConnection();
             PreparedStatement  stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    venta = crearVenta(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return venta;
    }



    @Override
    public void guardar(Venta venta) {
        String sql = "INSERT INTO Ventas (idproducto, tipoproducto, cantidad, fechaventa) VALUES (?, ?, ?, ?)";
        try (Connection         conn = getConnection();
             PreparedStatement  stmt = conn.prepareStatement(sql)) {
            stmt.setLong    (1, venta.getIdProducto());
            stmt.setString  (2, venta.getTipoProducto());
            stmt.setInt     (3, venta.getCantidad());
            stmt.setDate    (4, new java.sql.Date(venta.getFechaVenta().getTime()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void eliminar(Long id) {
        String sql = "DELETE FROM Ventas WHERE idventa = ?";
        try (Connection         conn = getConnection();
             PreparedStatement  stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
