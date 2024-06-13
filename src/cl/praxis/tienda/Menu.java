package cl.praxis.tienda;

import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private ProductoServicio productoServicio = new ProductoServicio();

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println(" +-----------------------------+");
            System.out.println(" |            MENU:            |");
            System.out.println(" +-----------------------------+");
            System.out.println(" |   1.   Listar Producto      |");
            System.out.println(" |   2.   Agregar Producto     |");
            System.out.println(" |   3.    Exportar Datos      |");
            System.out.println(" |   4.        Salir           |");
            System.out.println(" +-----------------------------+");
            System.out.print("\nIngrese una opción: ");
            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        productoServicio.listarProductos();
                        break;
                    case 2:
                        agregarProducto();
                        break;
                    case 3:
                        Exportador exportador = new ExportarTxt();
                        exportador.exportar(productoServicio.getListaProductos());
                        break;
                    case 4:
                        System.out.println("Saliendo...");
                        Utilidad.esperar(5);
                        Utilidad.limpiarPantalla();
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                opcion = -1;
            }
        } while (opcion != 4);
    }

    private void agregarProducto() {
        System.out.print("Ingresar nombre articulo: ");
        String articulo = scanner.nextLine();
        System.out.print("Ingresa precio: ");
        String precio = validarEntradaNumerica("Ingresa precio: ");
        System.out.print("Ingresa descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingresa código: ");
        String codigo = scanner.nextLine();
        System.out.print("Ingresa talla: ");
        String talla = scanner.nextLine();
        System.out.print("Ingresa marca: ");
        String marca = scanner.nextLine();
        System.out.print("Ingresa color: ");
        String color = scanner.nextLine();

        Producto producto = new Producto();
        producto.setArticulo(articulo);
        producto.setPrecio(precio);
        producto.setDescripcion(descripcion);
        producto.setCodigo(codigo);
        producto.setTalla(talla);
        producto.setMarca(marca);
        producto.setColor(color);

        productoServicio.agregarProductos(producto);
    }

    private String validarEntradaNumerica(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine();
            try {
                Integer.parseInt(entrada);
                return entrada;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
            }
        }
    }
}
