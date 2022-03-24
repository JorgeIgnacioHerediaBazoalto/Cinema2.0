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
        salas_por_defecto(c);
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
        Funcion funcion = new Funcion(peli1);

        Sala sala1 = new Sala("VIP-3");
        Sala sala2 = new Sala("VIP-3");

        funcion.addHorario(LocalTime.of(2, 30), sala1, TipoFuncion.FUNCION_2D);

        cartelera.addFuncion(funcion);

        String expected = "------------------------------CARTELERA------------------------------\n" +
                "Disponible desde: 2022-03-17\tHasta: 2022-04-02\n\n" +
                "FUNCION N°: 1\n" +
                "Pelicula: Point Of Break\n" +
                "\t\tGenero: ACCION\n" +
                "\t\tDuracion: 2.5\n" +
                "\t\tHorario: \n" +
                "\t\t\t02:30 - FUNCION_2D\n";

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

    @Test
    public void testCineCompleto() {
        Cine cine = cineComplet();

        Cartelera cartelera = new Cartelera(LocalDate.now(), LocalDate.of(2022, 3, 31));
        Pelicula pelicula1 = new Pelicula("MVP, Back to the game", GeneroPelicula.DOCUMENTAL, 2.5);
        Funcion funcion = new Funcion(pelicula1);
        funcion.addHorario(LocalTime.of(10, 20), cine.salas.get(0), TipoFuncion.FUNCION_3D);
        funcion.addHorario(LocalTime.of(10, 30), cine.salas.get(1), TipoFuncion.FUNCION_2D);
        cartelera.addFuncion(funcion);

        cine.boleteria.setCartelera(cartelera);

        Cliente cliente1 = new Cliente("May", "Boliviana", 13432, LocalDate.of(2003, 7, 3), true);
        TarjetaDeCredito tarjetaDeCreditoCliente1 = new TarjetaDeCredito("Los elefantes", cliente1.getName(), 2500.0);
        cliente1.setTarjeta(tarjetaDeCreditoCliente1);

        out.println(cine.boleteria.comprarBoleto("MVP, Back to the game", LocalTime.of(10, 30), 3, cliente1));
    }

    public Cine cineComplet() {
        Empleado empleado1 = new Empleado("Sam", "Boliviana", 15649, LocalDate.of(2003, 8, 8));
        Empleado empleado2 = new Empleado("Emma", "Boliviana", 56946, LocalDate.of(2003, 8, 8));
        Empleado empleado3 = new Empleado("Nath", "Boliviana", 56947, LocalDate.of(2003, 8, 8));

        Registro registro = new Registro();
        registro.registrar(empleado1);
        registro.registrar(empleado2);

        Cine cine = new Cine("Astor", registro);
        salas_por_defecto(cine);

        CandyBar candyBar = new CandyBar(empleado1, cine);

        Producto producto1 = new Producto("Pipocas-S", 15.0, 50, 50);
        Producto producto2 = new Producto("Pipocas-M", 25.0, 60, 50);
        Producto producto3 = new Producto("Pipocas-L", 30.0, 80, 50);
        Producto producto4 = new Producto("Refresco-S", 10.0, 50, 50);
        Producto producto5 = new Producto("Refresco-M", 15.0, 60, 50);
        Producto producto6 = new Producto("Refresco-L", 20.0, 80, 50);

        candyBar.addProducto(producto1);
        candyBar.addProducto(producto2);
        candyBar.addProducto(producto3);
        candyBar.addProducto(producto4);
        candyBar.addProducto(producto5);
        candyBar.addProducto(producto6);

        TiendaSouvenirs tiendaSouvenirs = new TiendaSouvenirs(empleado2, cine);

        Souvenir souvenir1 = new Souvenir("Peluche", 30.0, 80, 15);
        Souvenir souvenir2 = new Souvenir("Polera", 35.0, 90, 15);

        tiendaSouvenirs.addSouvenir(souvenir1);
        tiendaSouvenirs.addSouvenir(souvenir2);

        Boleteria boleteria = new Boleteria(empleado3, cine);

        cine.setBoleteria(boleteria);
        cine.setCandyBar(candyBar);
        cine.setTiendaSouvenirs(tiendaSouvenirs);

        return cine;
    }

    public void salas_por_defecto(Cine c){
        c.generarsalas(3,10,10);
        c.generarsalas(2,8,10);
        c.generarsalas(2,5,10);
    }

}
