package Repositorio;

import Modelo.Cd;
import Util.ConexionBaseDatos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CdRepositorio implements Repositorio<Cd> {
    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }



    private static Cd crearCd(ResultSet rs) throws SQLException {
        Cd c = new Cd();
        c.setIdCd               (rs.getLong         ("idcd"             ));
        c.setNombre             (rs.getString       ("nombre"           ));
        c.setArtista            (rs.getString       ("artista"          ));
        c.setAnioPublicacion    (rs.getDate         ("anio_publicacion" ));
        c.setMinutos            (rs.getLong         ("minutos"          ));
        return c;
    }



    @Override
    public List<Cd> listar() {
        List<Cd> cds = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
             ResultSet rs   = stmt.executeQuery("SELECT * FROM Cds")) {
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
        Cd cd = null;
        String sql = "SELECT * FROM Cds WHERE idcd = ?";
        try (PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM Cds WHERE idcd = ?")) {
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
            sql = "UPDATE Cds SET nombre = ?, artista = ?, anio_publicacion = ?, minutos = ? WHERE idcd = ?";
        } else {
            sql = "INSERT INTO Cds(nombre, artista, anio_publicacion, minutos) VALUES (?, ?, ?, ?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setString      (1, cd.getNombre()  );
            stmt.setString      (2, cd.getArtista() );
            stmt.setDate        (3, new java.sql.Date(cd.getAnioPublicacion().getTime()));
            stmt.setLong        (4, cd.getMinutos() );
            if (cd.getIdCd() != null && cd.getIdCd() > 0) {
                stmt.setLong(5, cd.getIdCd());
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void eliminar(Long id) {
        try (PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM Cds WHERE idcd = ?")) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
