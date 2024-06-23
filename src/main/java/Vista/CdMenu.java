package Vista;

import java.util.Scanner;
import java.util.Date;
import Controlador.*;
import Modelo.Cd;

public class CdMenu {
    private Scanner lector;
    private CdControlador controlador;

    public CdMenu() {
        this.lector         = new Scanner(System.in);
        this.controlador    = new CdControlador();
    }

    private Cd ingresarDatosCd() {
        System.out.print("                    Nombre           : ");
        String nombre = lector.nextLine();

        System.out.print("                    Artista          : ");
        String artista = lector.nextLine();

        System.out.print("                    Año Publicación  : ");
        int anioPublicacion = lector.nextInt();

        System.out.print("                    Minutos          : ");
        Long minutos = lector.nextLong();

        System.out.print("                    Precio           : ");
        Long precio = lector.nextLong();

        System.out.print("                    Stock            : ");
        int stock = lector.nextInt();
        lector.nextLine();  // Consume newline

        return new Cd(null, nombre, artista, anioPublicacion, minutos, precio, stock, new Date());
    }




    public void agregarCd() {
        System.out.println("                --------- AGREGAR CD ---------");
        Cd cd = ingresarDatosCd();
        controlador.guardarCd(cd);
        System.out.println("        El CD fue agregado exitosamente...");
    }



    public void listarCds() {
        System.out.println("                ------------ CDs -------------");
        controlador.listarCds().forEach(System.out::println);
    }



    public void buscarCdPorId() {
        System.out.print("\n                [CD] ID : ");
        Long id = lector.nextLong();
        Cd cd   = controlador.obtenerCdPorId(id);
        if (cd != null) {
            System.out.println("                # --- CD ENCONTRADO --- # ");
            System.out.println("\t\t   " + cd);
        } else {
            System.out.println("        No se existe un CD con el ID proporcionado.");
        }
    }



    public void eliminarCd() {
        System.out.println("                --------- ELIMINAR CD --------");
        System.out.print("                    ID : ");
        Long id = lector.nextLong();
        controlador.eliminarCd(id);
        System.out.println("            CD eliminado exitosamente.");
    }



    public void modificarCd() {
        System.out.println("                ------- MODIFICAR CD --------- ");
        System.out.print("                    ID : ");
        Long id = lector.nextLong();
        lector.nextLine();

        Cd cdExistente = controlador.obtenerCdPorId(id);
        if (cdExistente == null) {
            System.out.println("        No existe un CD con el ID proporcionado");
        } else {
            System.out.println("        CD actual encontrado:");
            System.out.println(cdExistente);

            Cd cdModificado = ingresarDatosCd();
            cdModificado.setIdCd(id);
            controlador.guardarCd(cdModificado);
            System.out.println("        El CD fue modificado exitosamente.");
        }
    }
}
