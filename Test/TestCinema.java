import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

import static java.lang.System.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCinema {

    @Test
    public void testClient(){
        Cliente cliente1 = new Cliente("Juan Tasma", "Bolivia", 123456789, LocalDate.of(2003, Month.OCTOBER, 8));

        String expected = "Name:\t\tJuan Tasma\n" +
                "Nacionalidad:\tBolivia\n" +
                "ID\t\t123456789\n" +
                "Edad:\t\t19\n" +
                "Fecha de nacimiento:\t2003-10-08\n";

        assertEquals(expected, cliente1.getInfo());
    }

    @Test
    public void testButaca(){
        Butaca b1=new Butaca(1,true);
        assertTrue(b1.estaDisponible());
        out.println(b1.getInfoButaca());
    }

    @Test
    public void testFila(){
        Fila f=new Fila("A1");
        f.generarButacas(10);
        out.println(f.infoFila());
    }
    @Test
    public void testSala(){
        Sala s=new Sala("A");
        s.generarFilas(6,9);
        out.println(s.mostrarAsientos());
    }
    @Test
    public void testCine(){
        Cine c = new Cine("Astor");
        out.println(c.infoCine());
        c.setFechaYHoraActual();
        out.println(c.getFechaActual());
    }
    @Test
    public void testOcuparButaca(){
        Cine c = new Cine("Astor");
        out.println(c.infoCine());
        c.comprarbutaca("A","A",4);
    }

    @Test
    public void testIDClient() {
        Registro registro = new Registro();
        //la funcion de asignar el id en orden funciona, pero falta que el id sea correlativo, para eso necesito usar el arraylsit de clientes en cine
        Cliente cliente1 = new Cliente("Juan Tasma", "Bolivia", 123456789, LocalDate.of(2003, Month.OCTOBER, 8));

        registro.registrar(cliente1);
        assertEquals("CLI-0", cliente1.getIdClient());

        Empleado empleado1 = new Empleado("Juan Tasma", "Bolivia", 123456789, LocalDate.of(2003, Month.OCTOBER, 8));
        registro.registrar(empleado1);
        assertEquals("EMP-0", empleado1.getIdEmpleado());
    }

    @Test
    public void testTarjetaCliente()
    {
        Cliente cliente1 = new Cliente("Juan Tasma", "Bolivia", 123456789, LocalDate.of(2003, Month.OCTOBER, 8));
        TarjetaDeCredito tarjetaC1 = new TarjetaDeCredito("Los Elefantes", "Juan Tasma", 2000);
        cliente1.setTarjeta(tarjetaC1);
        out.println(cliente1.getNombreBancoTarjeta());
    }

    @Test
    public void testCartelera() {
        int year = 2022;
        Cartelera cartelera = new Cartelera(LocalDate.of(year, 3, 17), LocalDate.of(year, 4, 2));
        Pelicula peli1 = new Pelicula("Point Of Break", GeneroPelicula.ACCION, 2.5);
        Funcion funcion = new Funcion(peli1, "2D", 40, 50);

        Sala sala1 = new Sala("VIP-3");
        Sala sala2 = new Sala("VIP-3");

        funcion.addHorario(LocalTime.of(2, 30), sala1);

        cartelera.addFuncion(funcion);

        String expected = "------------------------------CARTELERA------------------------------\n" +
                "Disponible desde: 2022-03-17\tHasta: 2022-04-02\n\n" +
                "FUNCION N°: 1\n" +
                "Pelicula: Point Of Break\n" +
                "\t\tGenero: ACCION\n" +
                "\t\tDuracion: 2.5\n" +
                "\t\tTipo Pelicula: 2D\n" +
                "\t\tHorario: \n" +
                "\t\t\t02:30\n";

        assertEquals(expected, cartelera.getCartelera());
    }

    @Test
    public void testSala2() {
        Sala sala1 = new Sala("1-VIP");
        sala1.generarFilas(8,8);
        out.println(sala1.mostrarAsientos());

        sala1.filas.get(0).butacas.get(0).setDisponible(false);
        out.println(sala1.mostrarAsientos());
    }

}
