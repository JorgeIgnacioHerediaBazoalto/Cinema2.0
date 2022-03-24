import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Boleteria{

    Empleado empleado;
    Cartelera cartelera;
    Sala sala;
    Butaca butaca;
    Cine cine;
    int precioBoleto;
    ArrayList<Pelicula> peliculas = new ArrayList<>();
    int total = 0;

    public Boleteria(Empleado empleado, Cine cine) {
        this.empleado = empleado;
        this.cine = cine;
        this.cartelera = null;
    }

    public void comprarBoleto(Cine cine, Pelicula pelicula, int cantidadDeBoletos, String formatoPelicula,
                             LocalDate localDate, LocalTime localTime){

        int subtotal = 0;
        Sala sala;
        Fila fila;
        Butaca butaca;
        ArrayList<Butaca> butacasLibres;
        int precioBoleto = generarPrecioBoleto(formatoPelicula);

        sala = cine.getSalas().get(7); //aca se deberia usar el metodo buscarSala
        fila = generarFila(sala,cantidadDeBoletos);
        butacasLibres = buscarButacasLibres(sala, cantidadDeBoletos);
        //peliculas.add(pelicula);

        for(int indice = 0; indice < cantidadDeBoletos; indice ++){

            butaca = butacasLibres.get(indice);
            Boleto boleto = new Boleto(cine, pelicula, sala, fila, butaca, formatoPelicula, localDate, localTime);
            boleto.generarBoleto();
            subtotal = precioBoleto + subtotal;
        }
    }

    public void formatoFacturaBoleteria(Cine cine, Cliente cliente, int subtotal, //FormaDePago formaDePago,
                                        ArrayList<Pelicula>peliculas,Empleado empleado){
        int n1 = 45;
        int n2 = 8;
        int n3 = 7;
        System.out.println("=".repeat(n1));
        System.out.println(" ".repeat(14) + "Factura Cine " + cine.getNombre());
        System.out.println("=".repeat(n1));
        System.out.println("=".repeat(n1) + "\n");
        System.out.println(" ".repeat(18) + "COCHABAMBA");
        System.out.println(" ".repeat(15) + "FACTURA N.12356"+"\n"+" ".repeat(7)+"AUTORIZACION N. 332401100018913"+"\n");
        System.out.println(" ".repeat(n2) + "Actividades de cinematografia"+"\n"+" ".repeat(12)+"y otras actividades"+"\n");
        System.out.println(" ".repeat(n2) + "Fecha"+" ".repeat(n2)+":"+" ".repeat(n3) + cine.getFechaActual());
        System.out.println(" ".repeat(n2) + "Hora"+" ".repeat(9)+":"+" ".repeat(n3) + cine.getHoraActual());
        System.out.println(" ".repeat(n2) + "Cliente"+" ".repeat(6)+":"+" ".repeat(n3) + cliente.getName()+"\n");
        //System.out.println(" ".repeat(n2) + "Pago"+" ".repeat(9)+":"+" ".repeat(n3) + cliente.getFormaDePago+"\n");
        System.out.println(" ".repeat(2)+"Detalle"+" ".repeat(15)+"Cant."+" ".repeat(6) + "Subtotal"+"\n"+" "+"-".repeat(43));
        listarPeliculas(peliculas);
        System.out.println(" ".repeat(28) + "Total Bs: " + calcularTotal(subtotal)+"\n"+"-".repeat(45)+"\n");
        System.out.println(" ".repeat(3) + "ESTA FACTURA CONTRIBUYE AL DESARROLLO");
        System.out.println(" ".repeat(3) + "DEL PAIS, EL USO ILICITO DE ESTA SERA");
        System.out.println(" ".repeat(3) + "SANCIONADO DE ACUERDO A LA LEY Nº 453\n");
        System.out.println(" ".repeat(12)+"Atendido por: " + empleado.getName());
        System.out.println(" ".repeat(11)+"GRACIAS POR SU COMPRA"+"\n");
        System.out.println("=".repeat(n1));
    }

    public void listarPeliculas(ArrayList<Pelicula> peliculas){
        for(Pelicula pelicula:peliculas){
            System.out.println(" ".repeat(3) + pelicula.getNombrePelicula());
        }
    }

    public int calcularTotal(int subtotal){
        int total = 0;
        total = total + subtotal;
        return total;
    }

    public int generarPrecioBoleto(String formatoPelicula){
        if(formatoPelicula.equals("2D")){
            return 40;
        } if(formatoPelicula.equals("3D")){
            return 60;
        }
        return 0;
    }

    public Sala buscarSala(Cine cine, Pelicula pelicula){

        for (Sala sala: cine.getSalas()) {
            Pelicula peli = sala.getPelicula();
            String nombrePelicula = peli.getNombrePelicula();
            if(pelicula.getNombrePelicula().equals(nombrePelicula)){
                return sala;
            }
        }
        return null;
    }

    public ArrayList<Butaca> buscarButacasLibres(Sala sala, int cantidadDeBoletos){
        ArrayList<Butaca> butacasLibres = new ArrayList<>();

        for (Fila fila:sala.getFilas()) {
            for (Butaca butaca : fila.getButacas()) {
                boolean estadoButaca = butaca.estaDisponible();
                if(estadoButaca){
                    butacasLibres.add(butaca);
                }else{
                    butacasLibres.clear();
                }
                if(butacasLibres.size() == cantidadDeBoletos){
                    return butacasLibres;
                }
            }
        }
        return butacasLibres;
    }

    public Fila generarFila(Sala sala, int cantidadDeBoletos){
        ArrayList<Butaca> butacasLibres = new ArrayList<>();

        for (Fila fila:sala.getFilas()) {
            for (Butaca butaca : fila.getButacas()) {
                boolean estadoButaca = butaca.estaDisponible();
                if(estadoButaca){
                    butacasLibres.add(butaca);
                }else{
                    butacasLibres.clear();
                }
                if(butacasLibres.size() == cantidadDeBoletos){
                    return fila;
                }
            }
        }
        return null;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setCartelera(Cartelera cartelera) {
        this.cartelera = cartelera;
    }

    public double calcularPuntos(int cantidadBoletos, double descuento)
    {
        double  puntosTotal = 0;
        double puntosPorBoleto  = 50;

        puntosPorBoleto = puntosPorBoleto * descuento;
        puntosTotal = cantidadBoletos * puntosPorBoleto;

        return puntosTotal;
    }


    public double canjearPuntos(double puntosTotal, int opcion)
    {

        switch (opcion)
        {
            case 1:
                if(puntosTotal >= 500 && puntosTotal < 950)
                {
                    puntosTotal = puntosTotal - 500;
                    return puntosTotal;
                }
                break;
            case 2:
                if(puntosTotal >= 950 && puntosTotal < 1350)
                {
                    puntosTotal = puntosTotal - 950;
                    return puntosTotal;
                }
                break;
            case 3:
                if(puntosTotal >=1350)
                {
                    puntosTotal = puntosTotal - 1350;
                    return puntosTotal;
                }
                break;
            default:
                return puntosTotal;
        }
        return puntosTotal;
    }

    public String canjearBoletos(int opcion, Pelicula pelicula)
    {
        String premio ="";
        switch (opcion)
        {
            case 1:
                premio = "Un boleto para la pelicula "+ pelicula.getNombrePelicula();
                return premio;
                //break;
            case 2:
                premio = "Dos boletos para la pelicula "+ pelicula.getNombrePelicula();
                return premio;
                //break;
            case 3:
                premio = "Tres boletos para la pelicula "+ pelicula.getNombrePelicula();
                return premio;
                //break;

        }
        return premio;
    }
}