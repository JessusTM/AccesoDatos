package Vista;

import Controlador.VentaControlador;
import Modelo.Venta;

import java.util.Date;
import java.util.Scanner;

public class VentaMenu {
    private Scanner lector;
    private VentaControlador controlador;
    ViniloMenu  viniloMenu  = new ViniloMenu();

    public VentaMenu() {
        this.lector = new Scanner(System.in);
        this.controlador = new VentaControlador();
    }


    private String elegirTipoProducto() {
        String tipoProducto = null;
        int opcion;
        do {
            System.out.println("                TIPO DE PRODUCTO");
            System.out.println("                    [1] Vinilo");
            System.out.println("                    [2] CD");
            System.out.println("                    [3] Casete");
            System.out.print  ("                Opción: ");
            opcion = lector.nextInt();
            lector.nextLine();

            switch (opcion) {
                case 1:
                    tipoProducto = "Vinilo";
                    break;
                case 2:
                    tipoProducto = "CD";
                    break;
                case 3:
                    tipoProducto = "Casete";
                    break;
                default:
                    System.out.println("        Ingresa una opción válida...");
                    break;
            }
        } while (!(opcion >= 1 && opcion <= 3));
        return tipoProducto;
    }

    private Long ingresarIdVinilo() {
        System.out.print  ("                    [VINILO] ID         : ");
        return lector.nextLong();
    }

    private Integer ingresarCantidad() {
        System.out.print  ("                    [VINILO] Cantidad   : ");
        System.out.print("Cantidad: ");
        return lector.nextInt();
    }


    public void agregarVenta() {
        System.out.println("                ------- AGREGAR VENTA -------- ");
        String tipoProducto = elegirTipoProducto();

        switch (tipoProducto) {
            case "Vinilo":
                viniloMenu.listarVinilos();
                Long idVinilo       = ingresarIdVinilo();
                Integer cantidad    = ingresarCantidad();
                controlador.guardarVentaVinilo(idVinilo, cantidad);
                System.out.println("        Venta de vinilo registrada exitosamente");
                break;
            case "CD":
                break;
            case "Casete":
                break;
            default:
                System.out.println("Tipo de producto no válido.");
                break;
        }
    }




    public void listarVentas() {
        System.out.println("                ----------- VENTAS ----------");
        controlador.listarVentas().forEach(System.out::println);
    }



    public void buscarVentaPorId() {
        System.out.print("\n                [VENTA] ID : ");
        Long idVenta = lector.nextLong();
        Venta venta = controlador.obtenerVentaPorId(idVenta);
        if (venta != null) {
            System.out.println("                # --- VENTA ENCONTRADA --- # ");
            System.out.println("\t\t   " + venta);
        } else {
            System.out.println("        No se encontró una venta con el ID proporcionado.");
        }
    }



    public void eliminarVenta() {
        System.out.println("                ------- ELIMINAR VENTA ------");
        System.out.print("                    ID : ");
        Long idVenta = lector.nextLong();
        lector.nextLine();

        Venta ventaAEliminar = controlador.obtenerVentaPorId(idVenta);
        if (ventaAEliminar != null) {
            controlador.eliminarVenta(idVenta);
            System.out.println("            Venta eliminada exitosamente");
        } else {
            System.out.println("        No se encontró una venta con el ID proporcionado.");
        }
    }

    // Puedes agregar métodos adicionales según las necesidades del menú de ventas
}
