public class Pelicula {

    String nombrePelicula;
    GeneroPelicula genero;
    double duracion;

    public Pelicula(String nombrePelicula, GeneroPelicula genero, double duracion)
    {
        this.nombrePelicula = nombrePelicula;
        this.genero = genero;
        this.duracion = duracion;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setGenero(GeneroPelicula genero) {
        this.genero = genero;
    }

    public GeneroPelicula getGenero() {
        return genero;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public double getDuracion() {
        return duracion;
    }
}
