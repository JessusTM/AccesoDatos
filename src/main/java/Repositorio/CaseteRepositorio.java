package Repositorio;

import Modelo.Casete;
import Util.ConexionBaseDatos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CaseteRepositorio implements Repositorio<Casete> {
    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getConnection();
    }



    private static Casete crearCasete(ResultSet rs) throws SQLException {
        Casete c = new Casete();
        c.setIdCasete           (rs.getLong         ("idcasete"         ));
        c.setNombre             (rs.getString       ("nombre"           ));
        c.setArtista            (rs.getString       ("artista"          ));
        c.setAnioPublicacion    (rs.getInt          ("anio_publicacion" ));
        c.setMinutos            (rs.getLong         ("minutos"          ));
        c.setMaterial           (rs.getString       ("material"         ));
        c.setTamanio            (rs.getLong         ("tamanio"          ));
        c.setPrecio             (rs.getLong         ("precio"           ));
        c.setStock              (rs.getInt          ("stock"            ));
        c.setFechaRegistro      (rs.getDate         ("fecha_registro"   ));
        return c;
    }



    @Override
    public List<Casete> listar() {
        String sql              = "SELECT * FROM Casetes";
        List<Casete> casetes    = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement  stmt = conn.createStatement();
             ResultSet  rs   = stmt.executeQuery(sql)) {
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
        Casete casete   = null;
        String sql      = "SELECT * FROM Casetes WHERE idcasete = ?";
        try (Connection         conn = getConnection();
             PreparedStatement  stmt = conn.prepareStatement(sql)) {
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
            sql = "UPDATE Casetes SET nombre = ?, artista = ?, anio_publicacion = ?, minutos = ?, material = ?, tamanio = ?, precio = ?, stock = ?, fecha_registro = ? WHERE idcasete = ?";
        } else {
            sql = "INSERT INTO Casetes(nombre, artista, anio_publicacion, minutos, material, tamanio, precio, stock, fecha_registro) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        }
        try (Connection         conn = getConnection();
             PreparedStatement  stmt = conn.prepareStatement(sql)) {
            stmt.setString      (1, casete.getNombre()          );
            stmt.setString      (2, casete.getArtista()         );
            stmt.setInt         (3, casete.getAnioPublicacion() );
            stmt.setLong        (4, casete.getMinutos()         );
            stmt.setString      (5, casete.getMaterial()        );
            stmt.setLong        (6, casete.getTamanio()         );
            stmt.setLong        (7, casete.getPrecio()          );
            stmt.setInt         (8, casete.getStock()           );
            stmt.setDate        (9, new java.sql.Date(casete.getFechaRegistro().getTime()));
            if (casete.getIdCasete() != null && casete.getIdCasete() > 0) {
                stmt.setLong(10, casete.getIdCasete());
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void eliminar(Long id) {
        try (Connection         conn = getConnection();
             PreparedStatement  stmt = conn.prepareStatement("DELETE FROM Casetes WHERE idcasete = ?")) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
