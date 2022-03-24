import java.time.LocalTime;
import java.util.ArrayList;

public class Funcion {

    Pelicula pelicula;
    TipoFuncion tipoPelicula;
    int precio2D = 40;
    int precio3D = 60;
    ArrayList<LocalTime> horarios = new ArrayList<>();
    ArrayList<Sala> salas = new ArrayList<>();
    ArrayList<TipoFuncion> tipoFuncions = new ArrayList<>();

    public Funcion(Pelicula pelicula)
    {
        this.pelicula = pelicula;
    }

    public void addHorario(LocalTime hora, Sala sala, TipoFuncion tipoFuncion) {
        horarios.add(hora);
        salas.add(sala);
        tipoFuncions.add(tipoFuncion);
    }

    public String mostrarFuncion() {
        String funcionString = "";
        funcionString += "Pelicula: " + pelicula.nombrePelicula + "\n" +
                "\t\tGenero: " + pelicula.genero + "\n"  +
                "\t\tDuracion: " + pelicula.duracion + "\n"  +
                "\t\tHorario: \n";

        for (LocalTime hora: horarios
        ) {
            funcionString += "\t\t\t" + hora + " - " + tipoFuncions.get(horarios.indexOf(hora)) + "\n";
        }
        return funcionString;
    }
}
