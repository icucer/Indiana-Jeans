package cl.praxis.tienda;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ExportarTxt extends Exportador{
    /**
     * @param productos
     */
    @Override
    public void exportar(ArrayList<Producto> productos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("productos.txt"))) {
            for (Producto producto : productos) {
                writer.write(producto.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
