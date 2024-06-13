package cl.praxis.tienda;

import java.util.ArrayList;

public class ProductoServicio {
    private ArrayList<Producto> listaProductos = new ArrayList<>();

    public ProductoServicio() {
    }

    public ProductoServicio(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void listarProductos() {
        for (Producto producto : listaProductos) {
            System.out.println(producto);
        }
    }

    public void agregarProductos(Producto producto) {
        listaProductos.add(producto);
    }
}
