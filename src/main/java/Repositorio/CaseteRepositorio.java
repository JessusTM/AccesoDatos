package Repositorio;

import Modelo.Casete;
import Util.ConexionBaseDatos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CaseteRepositorio implements Repositorio<Casete> {
    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }



    private static Casete crearCasete(ResultSet rs) throws SQLException {
        Casete c = new Casete();
        c.setIdCasete           (rs.getLong         ("idcasete"         ));
        c.setNombre             (rs.getString       ("nombre"           ));
        c.setArtista            (rs.getString       ("artista"          ));
        c.setAnioPublicacion    (rs.getDate         ("anio_publicacion" ));
        c.setMinutos            (rs.getLong         ("minutos"          ));
        c.setMaterial           (rs.getString       ("material"         ));
        c.setTamanio            (rs.getLong         ("tamanio"          ));
        return c;
    }



    @Override
    public List<Casete> listar() {
        List<Casete> casetes = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
             ResultSet rs   = stmt.executeQuery("SELECT * FROM Casetes")) {
            while (rs.next()) {
                Casete c = crearCasete(rs);
                casetes.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return casetes;
    }



    @Override
    public Casete porId(Long id) {
        Casete casete = null;
        String sql = "SELECT * FROM Casetes WHERE idcasete = ?";
        try (PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM Casetes WHERE idcasete = ?")) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    casete = crearCasete(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return casete;
    }



    @Override
    public void guardar(Casete casete) {
        String sql;
        if (casete.getIdCasete() != null && casete.getIdCasete() > 0) {
            sql = "UPDATE Casetes SET nombre = ?, artista = ?, anio_publicacion = ?, minutos = ?, material = ?, tamanio = ? WHERE idcasete = ?";
        } else {
            sql = "INSERT INTO Casetes(nombre, artista, anio_publicacion, minutos, material, tamanio, fecha_registro, precio, stock) VALUES (?, ?, ?, ?, ?, ?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setString      (1, casete.getNombre());
            stmt.setString      (2, casete.getArtista());
            stmt.setDate        (3, new java.sql.Date(casete.getAnioPublicacion().getTime()));
            stmt.setLong        (4, casete.getMinutos());
            stmt.setString      (5, casete.getMaterial());
            stmt.setLong        (6, casete.getTamanio());
            if (casete.getIdCasete() != null && casete.getIdCasete() > 0) {
                stmt.setLong(7, casete.getIdCasete());
            }
            stmt.executeUpdate();

            String sqlInventario = "INSERT INTO Inventario(idProducto, stock, fechaRegistro, precio) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmtInventario = getConnection().prepareStatement(sqlInventario)) {
                stmtInventario.setLong  (1, casete.getIdCasete());
                stmtInventario.setInt   (2, 0);
                stmtInventario.setDate  (3, new java.sql.Date(System.currentTimeMillis()));
                stmtInventario.setLong  (4, 0L);
                stmtInventario.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void eliminar(Long id) {
        try (PreparedStatement stmt     = getConnection().prepareStatement("DELETE FROM Casetes WHERE idcasete = ?"     );
             PreparedStatement stmtInv  = getConnection().prepareStatement("DELETE FROM Inventario WHERE idproducto = ?")) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
            stmtInv.setLong(1, id);
            stmtInv.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
