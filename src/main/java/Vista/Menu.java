package Vista;

import java.util.Scanner;

public class Menu {

    public void menu() {
        Scanner     lector      = new Scanner(System.in);
        ViniloMenu  viniloMenu  = new ViniloMenu();
        CdMenu      cdMenu      = new CdMenu();
        CaseteMenu  caseteMenu  = new CaseteMenu();
        String opcion;

        do {
            System.out.println("==============================");
            System.out.println("            BODEGA            ");
            System.out.println("==============================");
            System.out.println("    [1] Agregar producto      ");
            System.out.println("    [2] Mostrar productos     ");
            System.out.println("    [3] Eliminar producto     ");
            System.out.println("    [4] Modificar producto    ");
            System.out.println("    [5] Salir                 ");
            System.out.println("==============================");
            System.out.print  ("    Opción : ");
            opcion = lector.nextLine();
            System.out.println("==============================");

            switch (opcion) {
                case "1" -> {
                    System.out.println("                         # INVENTARIO  #      ");
                    System.out.println("                ------------------------------");
                    System.out.println("                    [1] Agregar Vinilo        ");
                    System.out.println("                    [2] Agregar CD            ");
                    System.out.println("                    [3] Agregar Casete        ");
                    System.out.println("                    [4] Salir                 ");
                    System.out.println("                ------------------------------");
                    System.out.print  ("                    Opción : ");
                    String subOpcion = lector.nextLine();
                    switch (subOpcion) {
                        case "1" -> viniloMenu.agregarVinilo();
                        case "2" -> cdMenu.agregarCd();
                        case "3" -> caseteMenu.agregarCasete();
                        case "4" -> System.out.println("        Volviendo al menú principal...");
                        default -> System.out.println("         Ingrese una opción válida... ");
                    }
                }
                case "2" -> {
                    System.out.println("                         # INVENTARIO  #      ");
                    viniloMenu.listarVinilos();
                    cdMenu.listarCds();
                    caseteMenu.listarCasetes();
                    int subOpcion;
                    do {
                        System.out.println("                ------------------------------");
                        System.out.println("                    [1] Buscar vinilo por ID  ");
                        System.out.println("                    [2] Buscar CD por ID      ");
                        System.out.println("                    [3] Buscar Casete por ID  ");
                        System.out.println("                    [4] Salir                 ");
                        System.out.println("                ------------------------------");
                        System.out.print  ("                    Opción : ");
                        subOpcion = lector.nextInt();
                        lector.nextLine();
                        switch (subOpcion) {
                            case 1  -> viniloMenu.buscarViniloPorId();
                            case 2  -> cdMenu.buscarCdPorId();
                            case 3  -> caseteMenu.buscarCasetePorId();
                            case 4  -> System.out.println("    Volviendo al menú principal...");
                            default -> System.out.println("    Ingrese una opción válida... ");
                        }
                    } while (subOpcion != 4);
                }
                case "3" -> {
                    System.out.println("                         # INVENTARIO  #      ");
                    int subOpcion;
                    do {
                        System.out.println("                ------------------------------");
                        System.out.println("                    [1] Eliminar Vinilo       ");
                        System.out.println("                    [2] Eliminar CD           ");
                        System.out.println("                    [3] Eliminar Casete       ");
                        System.out.println("                    [4] Salir                 ");
                        System.out.println("                ------------------------------");
                        System.out.print("                    Opción : ");
                        subOpcion = lector.nextInt();
                        switch (subOpcion) {
                            case 1 -> {
                                viniloMenu.listarVinilos();
                                viniloMenu.eliminarVinilo();
                            }
                            case 2 -> {
                                cdMenu.listarCds();
                                cdMenu.eliminarCd();
                            }
                            case 3 -> {
                                caseteMenu.listarCasetes();
                                caseteMenu.eliminarCasete();
                            }
                            case 4 -> System.out.println("    Volviendo al menú principal...");
                            default -> System.out.println("    Ingrese una opción válida... ");
                        }
                    } while (subOpcion != 4);
                }
                case "4" -> {
                    System.out.println("                         # INVENTARIO  #      ");
                    System.out.println("                ------------------------------");
                    System.out.println("                    [1] Modificar vinilo      ");
                    System.out.println("                    [2] Modificar CD          ");
                    System.out.println("                    [3] Modificar Casete      ");
                    System.out.println("                    [4] Salir                 ");
                    System.out.println("                ------------------------------");
                    System.out.print  ("                    Opción : ");
                    String subOpcion = lector.nextLine();
                    switch (subOpcion) {
                        case "1" -> {
                            viniloMenu.listarVinilos();
                            viniloMenu.modificarVinilo();
                        }
                        case "2" -> {
                            cdMenu.listarCds();
                            cdMenu.modificarCd();
                        }
                        case "3" -> {
                            caseteMenu.listarCasetes();
                            caseteMenu.modificarCasete();
                        }
                        case "4"    -> System.out.println("    Volviendo al menú principal...");
                        default     -> System.out.println("    Ingrese una opción válida... ");
                    }
                }
                case "5"    -> System.out.println(" Hasta luego... ");
                default     -> System.out.println(" Ingrese una opción válida");
            }
        } while (!opcion.equals("5"));
    }
}

