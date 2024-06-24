package Repositorio;

import Modelo.Vinilo;
import Util.ConexionBaseDatos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ViniloRepositorio implements Repositorio<Vinilo> {
    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getConnection();
    }



    private static Vinilo crearVinilo(ResultSet rs) throws SQLException {
        Vinilo v = new Vinilo();
        v.setIdVinilo       (rs.getLong     ("idVinilo"         ));
        v.setNombre         (rs.getString   ("nombre"           ));
        v.setArtista        (rs.getString   ("artista"          ));
        v.setPeso           (rs.getLong     ("peso"             ));
        v.setTamanio        (rs.getLong     ("tamanio"          ));
        v.setDescripcion    (rs.getString   ("descripcion"      ));
        v.setColor          (rs.getString   ("color"            ));
        v.setPrecio         (rs.getLong     ("precio"           ));
        v.setStock          (rs.getInt      ("stock"            ));
        v.setFechaRegistro  (rs.getDate     ("fecha_registro"   ));
        return v;
    }



    @Override
    public List<Vinilo> listar() {
        String sql              = "SELECT * FROM Vinilos";
        List<Vinilo> vinilos    = new ArrayList<>();
        try (Connection conn        = getConnection();
             Statement  stmt        = conn.createStatement();
             ResultSet  rs          = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Vinilo v = crearVinilo(rs);
                vinilos.add(v);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vinilos;
    }



    @Override
    public Vinilo porId(Long id) {
        String sql      = "SELECT * FROM Vinilos WHERE idvinilo = ?";
        Vinilo vinilo   = null;
        try (Connection         conn = getConnection();
             PreparedStatement  stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    vinilo = crearVinilo(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vinilo;
    }



    @Override
    public void guardar(Vinilo vinilo) {
        String sql;
        if (vinilo.getIdVinilo() != null && vinilo.getIdVinilo() > 0) {
            sql = "UPDATE Vinilos SET nombre = ?, artista = ?, peso = ?, tamanio = ?, descripcion = ?, color = ?, precio = ?, stock = ? WHERE idvinilo = ?";
        } else {
            sql = "INSERT INTO Vinilos(nombre, artista, peso, tamanio, descripcion, color, precio, stock, fecha_registro) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        }
        try (Connection         conn = getConnection();
             PreparedStatement  stmt = conn.prepareStatement(sql)) {
            stmt.setString  (1, vinilo.getNombre()      );
            stmt.setString  (2, vinilo.getArtista()     );
            stmt.setLong    (3, vinilo.getPeso()        );
            stmt.setLong    (4, vinilo.getTamanio()     );
            stmt.setString  (5, vinilo.getDescripcion() );
            stmt.setString  (6, vinilo.getColor()       );
            stmt.setLong    (7, vinilo.getPrecio()      );
            stmt.setInt     (8, vinilo.getStock()       );
            if (vinilo.getIdVinilo() != null && vinilo.getIdVinilo() > 0) {
                stmt.setLong(9, vinilo.getIdVinilo());
            } else {
                stmt.setDate(9, new java.sql.Date(vinilo.getFechaRegistro().getTime()));
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public void eliminar(Long id) {
        try (Connection         conn = getConnection();
             PreparedStatement  stmt = conn.prepareStatement("DELETE FROM Vinilos WHERE idvinilo = ?")) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
