import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Cartelera {
    //Necesitamos una manera de mostrar horarios, estaba pensando en agregar un Arraylist de Horarios a funcion, y crear una clase horario,
    // para agregar horarios a la misma funcion
    LocalDate plazoInicio;
    LocalDate plazoFin;
    ArrayList<Funcion> funcions;

    public Cartelera(LocalDate plazoInicio, LocalDate plazoFin) {
        this.plazoInicio = plazoInicio;
        this.plazoFin = plazoFin;
        this.funcions = new ArrayList<>();
    }

    public void addFuncion(Funcion funcion) {
        funcions.add(funcion);
    }

    public String getCartelera() {
        int contPeli = 1;
        String carteleraString = "------------------------------CARTELERA------------------------------\n" +
                "Disponible desde: " + plazoInicio + "\tHasta: " + plazoFin + "\n\n";

        for (Funcion funcion: funcions
             ) {
            carteleraString += "FUNCION N°: " + contPeli + "\n";
            carteleraString += funcion.mostrarFuncion();
            contPeli++;
        }

        return carteleraString;
    }

    public Funcion searchFuncions(int indice) {
        return funcions.get(indice - 1);
    }

    public Funcion searchFuncions(String nameFuncion) {
        Funcion funcionReturn = null;
        for (Funcion funcion : funcions
             ) {
            if (funcion.peliculas.nombrePelicula.equals(nameFuncion)) {
                funcionReturn = funcion;
            }
            else {
                funcionReturn = null;
            }
        }
        return funcionReturn;
    }
}
