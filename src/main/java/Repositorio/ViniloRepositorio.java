package Repositorio;

import Modelo.Vinilo;
import Util.ConexionBaseDatos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ViniloRepositorio implements Repositorio<Vinilo> {
    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getInstance();
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
        return v;
    }



    @Override
    public List<Vinilo> listar() {
        List<Vinilo> vinilos = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
             ResultSet rs   = stmt.executeQuery("SELECT * FROM Vinilos")) {
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
        Vinilo vinilo = null;
        try (PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM Vinilos WHERE idVinilo = ?")) {
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
            sql = "UPDATE Vinilos SET nombre = ?, artista = ?, peso = ?, tamanio = ?, descripcion = ?, color = ? WHERE idVinilo = ?";
        } else {
            sql = "INSERT INTO Vinilos(nombre, artista, peso, tamanio, descripcion, color) VALUES (?, ?, ?, ?, ?, ?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setString  (1, vinilo.getNombre()      );
            stmt.setString  (2, vinilo.getArtista()     );
            stmt.setLong    (4, vinilo.getPeso()        );
            stmt.setLong    (5, vinilo.getTamanio()     );
            stmt.setString  (6, vinilo.getDescripcion() );
            stmt.setString  (7, vinilo.getColor()       );
            if (vinilo.getIdVinilo() != null && vinilo.getIdVinilo() > 0) {
                stmt.setLong(8, vinilo.getIdVinilo());
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void eliminar(Long id) {
        try (PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM Vinilos WHERE idVinilo = ?")) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
