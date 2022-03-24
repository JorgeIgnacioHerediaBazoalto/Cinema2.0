import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.assertEquals;

public class TestCandyBar {
    @Test
    public void testCandyBar() {
        Cine c = new Cine("Astor");
        Empleado empleado = new Empleado("Sam", "England", 132354, LocalDate.of(2003, 8, 8));
        CandyBar candyBar = new CandyBar(empleado, c);
        Producto producto1 = new Producto("Palomitas", 15.5, 50, 20);
        Producto producto2 = new Producto("Coca-Cola", 10.0, 50, 20);

        candyBar.addProducto(producto1);
        candyBar.addProducto(producto2);

        Cliente cliente1 = new Cliente("Juan Tasma", "Bolivia", 123456789, LocalDate.of(2003, Month.OCTOBER, 8));

        String expectedFactura = "=============================================\n" +
                "            Factura Cine Astor\n" +
                "            CANDYBAR\n" +
                "=============================================\n" +
                "=============================================\n" +
                "\n" +
                "               FACTURA N.12356\n" +
                "       AUTORIZACION N. 332401100018913\n" +
                "\n" +
                "        Actividades de cinematografia\n" +
                "            y otras actividades\n" +
                "\n" +
                "        Fecha        :       2022-03-23\n" +
                "        Hora         :       HORA-ACTUAL\n" +
                "        Cliente      :       Juan Tasma\n" +
                "  Detalle               Cant.      Subtotal\n" +
                " -------------------------------------------\n" +
                "Producto: Palomitas\n" +
                "\tPrecio (c/u): 15.5\n" +
                "\tCantidad: 5\n" +
                "\tSubtotal: 77.5\n" +
                "\n" +
                "Producto: Coca-Cola\n" +
                "\tPrecio (c/u): 10.0\n" +
                "\tCantidad: 2\n" +
                "\tSubtotal: 20.0\n" +
                "\n" +
                "\n" +
                "                                 Total Bs: 97\n" +
                "---------------------------------------------\n" +
                "\n" +
                "   ESTA FACTURA CONTRIBUYE AL DESARROLLO\n" +
                "   DEL PAIS, EL USO ILICITO DE ESTA SERA\n" +
                "   SANCIONADO DE ACUERDO A LA LEY Nº 453\n" +
                "=============================================\n";

        candyBar.comprar(cliente1, producto1, 5);
        candyBar.comprar(cliente1, producto2, 2);
        assertEquals(expectedFactura, candyBar.facturar(cliente1));
        assertEquals(15, candyBar.productos.get(0).cantidadDisponible);
    }
}
