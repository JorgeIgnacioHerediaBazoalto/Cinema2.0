import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.assertEquals;

public class TestTiendaSouvenir {
    @Test
    public void testTiendaSouvenir() {
        Cine c = new Cine("Astor");
        Empleado empleado = new Empleado("Sam", "England", 132354, LocalDate.of(2003, 8, 8));
        TiendaSouvenirs tiendaSouvenirs = new TiendaSouvenirs(empleado, c);
        Souvenir souvenir1 = new Souvenir("Llavero", 15.5, 50, 20);
        Souvenir souvenir2 = new Souvenir("Peluche", 20.0, 50, 20);

        tiendaSouvenirs.addSouvenir(souvenir1);
        tiendaSouvenirs.addSouvenir(souvenir2);

        Cliente cliente1 = new Cliente("Juan Tasma", "Bolivia", 123456789, LocalDate.of(2003, Month.OCTOBER, 8));

        String expectedFactura = "=============================================\n" +
                "            Factura Cine Astor\n" +
                "            TIENDA SOUVENIRS\n" +
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
                "Producto: Llavero\n" +
                "\tPrecio (c/u): 15.5\n" +
                "\tCantidad: 5\n" +
                "\tSubtotal: 77.5\n" +
                "\n" +
                "Producto: Peluche\n" +
                "\tPrecio (c/u): 20.0\n" +
                "\tCantidad: 2\n" +
                "\tSubtotal: 40.0\n" +
                "\n" +
                "\n" +
                "                                 Total Bs: 117\n" +
                "---------------------------------------------\n" +
                "\n" +
                "   ESTA FACTURA CONTRIBUYE AL DESARROLLO\n" +
                "   DEL PAIS, EL USO ILICITO DE ESTA SERA\n" +
                "   SANCIONADO DE ACUERDO A LA LEY Nº 453\n" +
                "=============================================\n";

        tiendaSouvenirs.comprar(cliente1, souvenir1, 5);
        tiendaSouvenirs.comprar(cliente1, souvenir2, 2);
        assertEquals(expectedFactura, tiendaSouvenirs.facturar(cliente1));
        assertEquals(15, tiendaSouvenirs.souvenirs.get(0).cantidadDisponible);
    }
}
