public class Boleto {

    Cine cine;
    Pelicula pelicula;
    Sala sala;
    Butaca butaca;
    TipoFuncion formatoPelicula;

    public Boleto(Cine cine, Pelicula pelicula, Sala sala, Butaca butaca,
                  TipoFuncion formatoPelicula){
        this.cine = cine;
        this.pelicula = pelicula;
        this.sala = sala;
        this.butaca = butaca;
        this.formatoPelicula = formatoPelicula;
    }

    public String generarBoleto(){
        String boleto = "";
        int n1 = 39;
        int n2 = 5;
        boleto += "-".repeat(n1) + "\n" +
            " ".repeat(14) + cine.getNombre() + "\n" +
            " ".repeat(n2) + pelicula.getNombrePelicula() + "\n" + "\n" +
            " ".repeat(n2) + "Formato" + ".".repeat(17) + formatoPelicula + "\n" +
            " ".repeat(n2) + "Fecha" + ".".repeat(17) + cine.getFechaActual() + "\n" +
            " ".repeat(n2) + "Hora" + ".".repeat(19) + cine.getHoraActual() + "\n" +
            " ".repeat(n2) + "Sala" + ".".repeat(19) + sala.getCodigosala()+ "\n" +
            " ".repeat(n2) + "Butaca" + ".".repeat(17) + butaca.getId() + "\n" +
            "-".repeat(n1)+ "\n";
        return boleto;
    }
}