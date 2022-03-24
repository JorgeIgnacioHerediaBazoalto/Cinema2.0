public class Boleto {

    Cine cine;
    Pelicula pelicula;
    Sala sala;
    Butaca butaca;
    String formatoPelicula;

    public Boleto(Cine cine, Pelicula pelicula, Sala sala, Butaca butaca,
                  String formatoPelicula){
        this.cine = cine;
        this.pelicula = pelicula;
        this.sala = sala;
        this.butaca = butaca;
        this.formatoPelicula = formatoPelicula;
    }



    public void generarBoleto(){
        int n1 = 39;
        int n2 = 5;
        System.out.println("-".repeat(n1));
        System.out.println(" ".repeat(14) + cine.getNombre());
        System.out.println(" ".repeat(n2) + pelicula.getNombrePelicula() + formatoPelicula + "\n");
        System.out.println(" ".repeat(n2) + "Fecha" + ".".repeat(17) + cine.fechaActual);
        System.out.println(" ".repeat(n2) + "Hora" + ".".repeat(19) + cine.horaActual);
        System.out.println(" ".repeat(n2) + "Sala" + ".".repeat(19) + sala.getCodigosala());
        System.out.println(" ".repeat(n2) + "Butaca" + ".".repeat(17) + butaca.getNumero());
        System.out.println("-".repeat(n1));

    }
}