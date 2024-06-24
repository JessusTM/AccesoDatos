package Repositorio;

import Modelo.Cd;
import Util.ConexionBaseDatos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CdRepositorio implements Repositorio<Cd> {
    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getConnection();
    }



    private static Cd crearCd(ResultSet rs) throws SQLException {
        Cd c = new Cd();
        c.setIdCd               (rs.getLong         ("idcd"             ));
        c.setNombre             (rs.getString       ("nombre"           ));
        c.setArtista            (rs.getString       ("artista"          ));
        c.setAnioPublicacion    (rs.getInt          ("anio_publicacion" ));
        c.setMinutos            (rs.getLong         ("minutos"          ));
        c.setPrecio             (rs.getLong         ("precio"           ));
        c.setStock              (rs.getInt          ("stock"            ));
        c.setFechaRegistro      (rs.getDate         ("fecha_registro"   ));
        return c;
    }



    @Override
    public List<Cd> listar() {
        String sql      = "SELECT * FROM Cds";
        List<Cd> cds    = new ArrayList<>();
        try (Connection conn    = getConnection();
             Statement  stmt    = conn.createStatement();
             ResultSet  rs      = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Cd c = crearCd(rs);
                cds.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cds;
    }



    @Override
    public Cd porId(Long id) {
        Cd cd       = null;
        String sql  = "SELECT * FROM Cds WHERE idcd = ?";
        try (Connection         conn = getConnection();
             PreparedStatement  stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    cd = crearCd(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cd;
    }



    @Override
    public void guardar(Cd cd) {
        String sql;
        if (cd.getIdCd() != null && cd.getIdCd() > 0) {
            sql = "UPDATE Cds SET nombre = ?, artista = ?, anio_publicacion = ?, minutos = ?, precio = ?, stock = ?, fecha_registro = ? WHERE idcd = ?";
        } else {
            sql = "INSERT INTO Cds(nombre, artista, anio_publicacion, minutos, precio, stock, fecha_registro) VALUES (?, ?, ?, ?, ?, ?, ?)";
        }
        try (Connection         conn = getConnection();
             PreparedStatement  stmt = conn.prepareStatement(sql)) {
            stmt.setString  (1, cd.getNombre()              );
            stmt.setString  (2, cd.getArtista()             );
            stmt.setInt     (3, cd.getAnioPublicacion()     );
            stmt.setLong    (4, cd.getMinutos()             );
            stmt.setLong    (5, cd.getPrecio()              );
            stmt.setInt     (6, cd.getStock()               );
            stmt.setDate    (7, new java.sql.Date(cd.getFechaRegistro().getTime()));
            if (cd.getIdCd() != null && cd.getIdCd() > 0) {
                stmt.setLong(8, cd.getIdCd());
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void eliminar(Long id) {
        String sql = "DELETE FROM Cds WHERE idcd = ?";
        try (Connection         conn = getConnection();
             PreparedStatement  stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
