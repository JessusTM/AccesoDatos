package Vista;

import java.util.Scanner;
import java.util.Date;
import Controlador.*;
import Modelo.Casete;

public class CaseteMenu {
    // ----- ATRIBUTOS -----
    private Scanner lector;
    private CaseteControlador controlador;



    // ----- CONSTRUCTOR -----
    public CaseteMenu() {
        this.lector         = new Scanner(System.in);
        this.controlador    = new CaseteControlador();
    }



    private Casete ingresarDatosCasete() {
        System.out.print("                    Nombre           : ");
        String nombre = lector.nextLine();

        System.out.print("                    Artista          : ");
        String artista = lector.nextLine();

        System.out.print("                    Año Publicación  : ");
        Integer anioPublicacion = lector.nextInt();
        lector.nextLine();

        System.out.print("                    Minutos          : ");
        Long minutos = lector.nextLong();
        lector.nextLine();

        System.out.print("                    Material         : ");
        String material = lector.nextLine();

        System.out.print("                    Tamaño           : ");
        Long tamanio = lector.nextLong();
        lector.nextLine();

        System.out.print("                    Precio           : ");
        Long precio = lector.nextLong();
        lector.nextLine();

        System.out.print("                    Stock            : ");
        Integer stock = lector.nextInt();
        lector.nextLine();

        Date fechaRegistro = new Date();

        return new Casete(null, nombre, artista, anioPublicacion, minutos, material, tamanio, precio, stock, fechaRegistro);
    }



    public void agregarCasete() {
        System.out.println("                ------- AGREGAR CASETE -------");
        Casete casete = ingresarDatosCasete();
        controlador.guardarCasete(casete);
        System.out.println("        El casete fue agregado exitosamente...");
    }



    public void listarCasetes() {
        System.out.println("                ---------- CASETES -----------");
        System.out.println(Casete.getHeader());
        controlador.listarCasetes().forEach(System.out::println);
    }



    public void buscarCasetePorId() {
        System.out.print("\n                [CASETE] ID : ");
        Long id = lector.nextLong();
        Casete casete   = controlador.obtenerCasetePorId(id);
        if (casete != null) {
            System.out.println("                # - CASETE ENCONTRADO - # ");
            System.out.println("\t\t   " + casete);
        } else {
            System.out.println("        No se existe un CASETE con el ID proporcionado");
        }
    }



    public void eliminarCasete() {
        System.out.println("                ------- ELIMINAR CASETE ------");
        System.out.print("                    ID : ");
        Long id = lector.nextLong();
        controlador.eliminarCasete(id);
        System.out.println("            CASETE eliminado exitosamente");
    }



    public void modificarCasete() {
        System.out.println("                ----- MODIFICAR CASETE ------- ");
        System.out.print("                    ID : ");
        Long id = lector.nextLong();
        lector.nextLine();

        Casete caseteExistente = controlador.obtenerCasetePorId(id);
        if (caseteExistente == null) {
            System.out.println("        No existe un CASETE con el ID proporcionado");
        } else {
            System.out.println("        CASETE actual encontrado:");
            System.out.println(caseteExistente);

            Casete caseteModificado = ingresarDatosCasete();
            caseteModificado.setIdCasete(id);
            controlador.guardarCasete(caseteModificado);
            System.out.println("        El CASETE fue modificado exitosamente");
        }
    }
}
