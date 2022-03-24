import java.time.LocalDate;
import java.time.LocalTime;

public class Boleto {

    Cine cine;
    Pelicula pelicula;
    Sala sala;
    Fila fila;
    Butaca butaca;
    String formatoPelicula;
    LocalTime hora;
    LocalDate fecha;

    public Boleto(Cine cine, Pelicula pelicula, Sala sala, Fila fila, Butaca butaca,
                  String formatoPelicula, LocalDate fecha, LocalTime hora){
        this.cine = cine;
        this.pelicula = pelicula;
        this.sala = sala;
        this.fila = fila;
        this.butaca = butaca;
        this.formatoPelicula = formatoPelicula;
        this.fecha = fecha;
        this.hora = hora;
    }

    public void generarBoleto(){
        int n1 = 39;
        int n2 = 4;
        System.out.println("-".repeat(n1));
        System.out.println(" ".repeat(14) + "Cine " + cine.getNombre());
        System.out.println(" ".repeat(9) + pelicula.getNombrePelicula() +" - "+ formatoPelicula + "\n");
        System.out.println(" ".repeat(n2) + "Fecha" + ".".repeat(18) + fecha);
        System.out.println(" ".repeat(n2) + "Hora" + ".".repeat(19) + hora);
        System.out.println(" ".repeat(n2) + "Sala" + ".".repeat(19) + sala.getCodigosala());
        System.out.println(" ".repeat(n2) + "Butaca" + ".".repeat(17) + fila.getCodigofila() + butaca.getNumero());
        System.out.println("-".repeat(n1));

    }
}
