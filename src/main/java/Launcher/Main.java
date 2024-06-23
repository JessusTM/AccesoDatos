package Launcher;

import Modelo.Vinilo;
import Repositorio.*;
import Vista.Menu;
import Util.ConexionBaseDatos;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = ConexionBaseDatos.getInstance()) {
            Repositorio<Vinilo> repositorio = new ViniloRepositorio();
            Menu menu = new Menu();
            menu.menu();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
