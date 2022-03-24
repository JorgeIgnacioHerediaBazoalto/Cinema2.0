import java.time.LocalTime;
import java.util.ArrayList;

public class Funcion {

    Pelicula peliculas;
    String tipoPelicula;
    int precio2D;
    int precio3D;
    ArrayList<LocalTime> horarios = new ArrayList<>();
    ArrayList<Sala> salas = new ArrayList<>();

    public Funcion(Pelicula peliculas, /*String hora, String dia, Sala sala,*/ String tipoPelicula, int precio2D, int precio3D)
    {
        this.peliculas = peliculas;
        //this.hora = hora;
        //this.dia = dia;
        //this.sala = sala;
        this.tipoPelicula = tipoPelicula;
        this.precio2D = precio2D;
        this.precio3D = precio3D;
    }

    public void addHorario(LocalTime hora, Sala sala) {
        horarios.add(hora);
        salas.add(sala);
    }

    public String mostrarFuncion() {
        String funcionString = "";
        funcionString += "Pelicula: " + peliculas.nombrePelicula + "\n" +
                "\t\tGenero: " + peliculas.genero + "\n"  +
                "\t\tDuracion: " + peliculas.duracion + "\n"  +
                "\t\tTipo Pelicula: " + tipoPelicula + "\n" +
                "\t\tHorario: \n";

        for (LocalTime hora: horarios
        ) {
            funcionString += "\t\t\t" + hora + "\n";
        }
        return funcionString;
    }
}
