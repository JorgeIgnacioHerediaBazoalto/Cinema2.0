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

    public void setCartelera(Cartelera cartelera) {
        this.cartelera = cartelera;
    }

//    public void comprarBoleto(String namePelicula, int cantidadDeBoletos, LocalTime localTime, Cliente cliente){
//        Funcion funcion = cartelera.searchFuncions(namePelicula);
//        int indiceBusqueda = funcion.horarios.indexOf(localTime);
//        int subtotal = 0;
//        sala = funcion.salas.get(indiceBusqueda);
//        ArrayList<String> butacasLibres = sala.getButacasLibres();
//        Pelicula pelicula = funcion.pelicula;
//        TipoFuncion formatoPelicula = funcion.tipoFuncions.get(indiceBusqueda);
//
//        for(int indice = 0; indice < cantidadDeBoletos; indice ++){
//
//            butaca = sala.getButaca(butacasLibres.get(indice).charAt(0), butacasLibres.get(indice).charAt(1));
//            Boleto boleto = new Boleto(cine, pelicula, sala, butaca, formatoPelicula);
//            boleto.generarBoleto();
//            precioBoleto = generarPrecioBoleto(formatoPelicula);
//            subtotal = precioBoleto + subtotal;
//        }
//        formatoFacturaBoleteria(cliente, empleado, subtotal, peliculas);
//    }

    public String comprarBoleto(String namePelicula, LocalTime hora, int cantidadDeBoletos, Cliente cliente) {
        Funcion funcion = cartelera.searchFuncions(namePelicula);
        Pelicula pelicula = funcion.pelicula;
        String factura = "";

        int precioTotal = 0;
        int indiceFuncion = cartelera.funcions.indexOf(funcion);
        int indiceHorarioYSala = funcion.horarios.indexOf(hora);
        Sala sala = cartelera.funcions.get(indiceFuncion).salas.get(indiceHorarioYSala);

        ArrayList<String> butacasLibres = sala.getButacasLibres();
        for (int i = 0; i < cantidadDeBoletos; i++) {
            String codigoFila = butacasLibres.get(i).charAt(0) + "";
            int numeroButaca = Integer.parseInt(String.valueOf(butacasLibres.get(i).charAt(1)));
            Butaca butaca = sala.searchFila(codigoFila).searchButaca(numeroButaca);
            Boleto boleto = new Boleto(cine, pelicula, sala, butaca, cartelera.funcions.get(indiceFuncion).tipoFuncions.get(indiceHorarioYSala));
            precioBoleto = generarPrecioBoleto(cartelera.funcions.get(indiceFuncion).tipoFuncions.get(indiceHorarioYSala));
            butaca.setDisponible(false);
            factura += boleto.generarBoleto();
            precioTotal += precioBoleto;
        }
        factura += formatoFacturaBoleteria(cliente, empleado, precioTotal, pelicula, cantidadDeBoletos);
        return factura;
    }

    public int comprarBoleto(Pelicula pelicula, int cantidadDeBoletos, TipoFuncion formatoPelicula, LocalTime localTime){

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

    public void formatoFacturaBoleteria(Cliente cliente, Empleado empleado, int subtotal //FormaDePago formaDePago,
                                        , ArrayList<Pelicula> peliculas /*, int cantidadDeBoletos, LocalTime localTime*/){
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
        System.out.println(" ".repeat(33) + "Descuento: : " + Promocion.obtenerDescuento(cine.getFechaActual(), cliente.getEdad(), peliculas.get(0).getGenero(), cliente.getNombreBancoTarjeta()) +"\n"+"-".repeat(45)+"\n");
        System.out.println(" ".repeat(33) + "Total D: " + calcularTotal(subtotal) * Promocion.obtenerDescuento(cine.getFechaActual(), cliente.getEdad(), peliculas.get(0).getGenero(), cliente.getNombreBancoTarjeta()) +"\n"+"-".repeat(45)+"\n");
        System.out.println(" ".repeat(3) + "ESTA FACTURA CONTRIBUYE AL DESARROLLO");
        System.out.println(" ".repeat(3) + "DEL PAIS, EL USO ILICITO DE ESTA SERA");
        System.out.println(" ".repeat(3) + "SANCIONADO DE ACUERDO A LA LEY Nº 453");
        System.out.println("=".repeat(n1));
        System.out.println(" ".repeat(3) + "Atendido por: " + empleado.getName());


    }

    public String formatoFacturaBoleteria(Cliente cliente, Empleado empleado, int subtotal, Pelicula pelicula, int cantidad){
        int n1 = 45;
        int n2 = 8;
        int n3 = 7;
        String factura = "" +
                "=".repeat(n1) + "\n" +
                " ".repeat(12) + "Factura Cine " + cine.getNombre() + "\n" +
                "=".repeat(n1) + "\n" +
                "=".repeat(n1) + "\n" + "\n" +
                " ".repeat(19) + "COCHABAMBA" + "\n" +
                " ".repeat(15) + "FACTURA N.12356"+"\n"+" ".repeat(7)+"AUTORIZACION N. 332401100018913"+"\n" + "\n" +
                " ".repeat(n2) + "Actividades de cinematografia"+"\n"+" ".repeat(12)+"y otras actividades"+"\n" + "\n" +
                " ".repeat(n2) + "Fecha"+" ".repeat(n2)+":"+" ".repeat(n3) + cine.getFechaActual() + "\n" +
                " ".repeat(n2) + "Hora"+" ".repeat(9)+":"+" ".repeat(n3) + cine.getHoraActual() + "\n" +
                " ".repeat(n2) + "Cliente"+" ".repeat(6)+":"+" ".repeat(n3) + cliente.getName() + "\n" +
                " ".repeat(2) + "Detalle"+" ".repeat(15)+"Cant."+" ".repeat(6) + "Subtotal"+"\n"+" "+"-".repeat(43) + "\n" +
                " ".repeat(2) + pelicula.nombrePelicula +" ".repeat(15)+ cantidad +" ".repeat(6) + precioBoleto +"\n"+" "+"-".repeat(43) + "\n" +
                " ".repeat(33) + "Total Bs: " + calcularTotal(subtotal)+"\n"+"-".repeat(45)+"\n" + "\n" +
                " ".repeat(33) + "Descuento: : " + Promocion.obtenerDescuento(cine.getFechaActual(), cliente.getEdad(), pelicula.getGenero(), cliente.getNombreBancoTarjeta()) +"\n"+"-".repeat(45)+"\n" + "\n" +
                " ".repeat(33) + "Total D: " + calcularTotal(subtotal) * Promocion.obtenerDescuento(cine.getFechaActual(), cliente.getEdad(), pelicula.getGenero(), cliente.getNombreBancoTarjeta()) +"\n"+"-".repeat(45)+"\n" + "\n" +
                " ".repeat(3) + "ESTA FACTURA CONTRIBUYE AL DESARROLLO" + "\n" +
                " ".repeat(3) + "DEL PAIS, EL USO ILICITO DE ESTA SERA" + "\n" +
                " ".repeat(3) + "SANCIONADO DE ACUERDO A LA LEY Nº 453" + "\n" +
                "=".repeat(n1) + "\n" +
                " ".repeat(3) + "Atendido por: " + empleado.getName() + "\n";
        return factura;

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

    private int generarPrecioBoleto(TipoFuncion formatoPelicula){
        if(formatoPelicula.equals(TipoFuncion.FUNCION_2D)){
            return 40;
        } if(formatoPelicula.equals(TipoFuncion.FUNCION_3D)){
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