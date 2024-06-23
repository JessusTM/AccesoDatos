package Vista;

import java.util.Scanner;
import java.util.Date;
import Controlador.*;
import Modelo.Vinilo;

public class ViniloMenu {
    private Scanner             lector;
    private ViniloControlador   controlador;



    public ViniloMenu() {
        this.lector         = new Scanner(System.in);
        this.controlador    = new ViniloControlador();
    }



    private Vinilo ingresarDatosVinilo() {
        System.out.print("                    Nombre      : ");
        String nombre = lector.nextLine();

        System.out.print("                    Artista     : ");
        String artista = lector.nextLine();

        System.out.print("                    Peso        : ");
        Long peso = lector.nextLong();
        lector.nextLine();

        System.out.print("                    Tamaño      : ");
        Long tamanio = lector.nextLong();
        lector.nextLine();

        System.out.print("                    Descripción : ");
        String descripcion = lector.nextLine();

        System.out.print("                    Color       : ");
        String color = lector.nextLine();

        System.out.print("                    Precio      : ");
        Long precio = lector.nextLong();
        lector.nextLine();

        System.out.print("                    Stock       : ");
        Integer stock = lector.nextInt();
        lector.nextLine();

        Date fechaRegistro = new Date();

        return new Vinilo(null, nombre, artista, peso, tamanio, descripcion, color, precio, stock, fechaRegistro);
    }

    public void agregarVinilo() {
        System.out.println("                ------- AGREGAR VINILO -------");
        Vinilo vinilo = ingresarDatosVinilo();
        controlador.guardarVinilo(vinilo);
        System.out.println("        Producto agregado exitosamente");
    }



    public void listarVinilos() {
        System.out.println("                ----------- VINILOS ----------");
        System.out.println(Vinilo.getHeader());
        controlador.listarVinilos().forEach(System.out::println);
    }



    public void buscarViniloPorId() {
        System.out.print("\n                [VINILO] ID : ");
        Long id         = lector.nextLong();
        Vinilo vinilo   = controlador.obtenerViniloPorId(id);
        if (vinilo != null) {
            System.out.println("                # --- VINILO ENCONTRADO --- # ");
            System.out.println("\t\t   " + vinilo);
        } else {
            System.out.println("        No se encontró un vinilo con el ID proporcionado.");
        }
    }



    public void eliminarVinilo() {
        System.out.println("                ------- ELIMINAR VINILO ------");
        System.out.print("                    ID : ");
        Long id = lector.nextLong();
        lector.nextLine();

        Vinilo viniloAEliminar = controlador.obtenerViniloPorId(id);
        if (viniloAEliminar != null) {
            controlador.eliminarVinilo(id);
            System.out.println("            Vinilo eliminado exitosamente");
        } else {
            System.out.println("        No se encontró un vinilo con el ID proporcionado.");
        }
    }




    public void modificarVinilo() {
        System.out.println("                ----- MODIFICAR VINILO ------- ");
        System.out.print("                    ID : ");
        Long id = lector.nextLong();
        lector.nextLine();

        Vinilo viniloExistente = controlador.obtenerViniloPorId(id);
        if (viniloExistente == null) {
            System.out.println("        No existe un vinilo con el ID proporcionado");
        } else {
            System.out.println("        Vinilo actual encontrado:");
            System.out.println(viniloExistente);

            Vinilo viniloModificado = ingresarDatosVinilo();
            viniloModificado.setIdVinilo(id);
            controlador.guardarVinilo(viniloModificado);
            System.out.println("        Vinilo modificado exitosamente");
        }
    }
}
