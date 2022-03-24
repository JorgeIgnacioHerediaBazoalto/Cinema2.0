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

    public Boleteria(Empleado empleado) {
        this.empleado = empleado;
        this.cartelera = null;
    }

    public int comprarBoleto(Pelicula pelicula, int cantidadDeBoletos, String formatoPelicula, LocalTime localTime){

        int subtotal = 0;
        sala = generarSala(pelicula, localTime);
        ArrayList<Butaca> butacasLibres = new ArrayList<>();
        butacasLibres = buscarButacasLibres(sala, cantidadDeBoletos, butacasLibres);
        peliculas.add(pelicula);

        for(int indice = 0; indice < cantidadDeBoletos; indice ++){

            butaca = butacasLibres.get(indice);
            Boleto boleto = new Boleto(cine, pelicula, sala, butaca, formatoPelicula);
            boleto.generarBoleto();
            precioBoleto = generarPrecioBoleto(formatoPelicula);
            subtotal = precioBoleto + subtotal;
        }
        return subtotal;
    }

    public void formatoFacturaBoleteria(Cliente cliente, Empleado empleado, int subtotal, //FormaDePago formaDePago,
                                        ArrayList<Pelicula>peliculas, int cantidadDeBoletos, LocalTime localTime){
        int n1 = 45;
        int n2 = 8;
        int n3 = 7;

        System.out.println("=".repeat(n1));
        System.out.println(" ".repeat(12) + "Factura Cine " + cine.getNombre());
        System.out.println("=".repeat(n1));
        System.out.println("=".repeat(n1) + "\n");
        System.out.println(" ".repeat(19) + "COCHABAMBA");
        System.out.println(" ".repeat(15) + "FACTURA N.12356"+"\n"+" ".repeat(7)+"AUTORIZACION N. 332401100018913"+"\n");
        System.out.println(" ".repeat(n2) + "Actividades de cinematografia"+"\n"+" ".repeat(12)+"y otras actividades"+"\n");
        System.out.println(" ".repeat(n2) + "Fecha"+" ".repeat(n2)+":"+" ".repeat(n3) + cine.getFechaActual());
        System.out.println(" ".repeat(n2) + "Hora"+" ".repeat(9)+":"+" ".repeat(n3) + cine.getHoraActual());
        System.out.println(" ".repeat(n2) + "Cliente"+" ".repeat(6)+":"+" ".repeat(n3) + cliente.getName());
        //System.out.println(" ".repeat(n2) + "Pago"+" ".repeat(9)+":"+" ".repeat(n3) + cliente.getFormaDePago+"\n");
        System.out.println(" ".repeat(2)+"Detalle"+" ".repeat(15)+"Cant."+" ".repeat(6) + "Subtotal"+"\n"+" "+"-".repeat(43));
        listarPeliculas(peliculas);
        System.out.println(" ".repeat(33) + "Total Bs: " + calcularTotal(subtotal)+"\n"+"-".repeat(45)+"\n");
        System.out.println(" ".repeat(3) + "ESTA FACTURA CONTRIBUYE AL DESARROLLO");
        System.out.println(" ".repeat(3) + "DEL PAIS, EL USO ILICITO DE ESTA SERA");
        System.out.println(" ".repeat(3) + "SANCIONADO DE ACUERDO A LA LEY Nº 453");
        System.out.println("=".repeat(n1));


    }

    public void listarPeliculas(ArrayList<Pelicula> peliculas){
        for(Pelicula pelicula:peliculas){
            System.out.println(" " + pelicula);
        }
    }

    public int calcularTotal(int subtotal){
        total = total + subtotal;
        return total;
    }

    private int generarPrecioBoleto(String formatoPelicula){
        if(formatoPelicula.equals("2D")){
            return 40;
        } if(formatoPelicula.equals("3D")){
            return 60;
        }
        return 0;
    }

    public Sala generarSala(Pelicula pelicula, LocalTime localTime){
        ArrayList<Sala> salas;
        salas = cine.getSalas();
        for(int i = 0; i < salas.size(); i ++) {
            sala = salas.get(i);
            String nombrePelicula = pelicula.nombrePelicula;
            //LocalTime localTimeSala
            if(nombrePelicula.equals(pelicula.getNombrePelicula())){
                return sala;
            }
        }
        return sala;
    }

    public ArrayList<Butaca> buscarButacasLibres(Sala sala, String codigofila, int cantidadDeBoletos,
                                                 ArrayList<Butaca> butacasLibres){
        for (Fila fila:sala.getFilas()) {
            if (Objects.equals(codigofila, fila.getCodigofila())){
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
        }
        return butacasLibres;
    }

    public ArrayList<Butaca> buscarButacasLibres(Sala sala, int cantidadDeBoletos, ArrayList<Butaca> butacasLibres){
        int capacidadSala = sala.getCapacidad();
        capacidadSala = capacidadSala / sala.getFilas().get(0).getButacas().size(); // /10 butacasPorFila
        ArrayList<String> codigosDeFilas = new ArrayList<>();
        String codigo;

        for(int i = 0; i < capacidadSala; i++){
            char character = (char)(65 + i);
            codigo = String.valueOf(character);
            codigosDeFilas.add(codigo);
        }

        for(int i = 0; i < codigosDeFilas.size(); i++){
            String codigoFila = codigosDeFilas.get(i);
            butacasLibres = buscarButacasLibres(sala, codigoFila, cantidadDeBoletos, butacasLibres);
            if(butacasLibres.size() == cantidadDeBoletos){
                return butacasLibres;
            }
        }
        return butacasLibres;
    }

}