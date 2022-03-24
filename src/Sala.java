import java.util.ArrayList;

public class Sala {
    String codigosala;
    int numeroFilas;
    int capacidad;
    ArrayList<Fila> filas;
    int butacasporfila;

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

//"SALA-A"
    public Sala(String codigosala, int numeroFilas, int butacasporfila){
        this.codigosala = codigosala;
        this.numeroFilas = numeroFilas;
        this.filas = new ArrayList<>();
        generarFilas(numeroFilas,butacasporfila);
    }

    public Sala(String codigosala){
        this.codigosala = codigosala;
        this.filas = new ArrayList<>();
    }

    public void generarFilas( int numeroFilas,int butacasporfila) {
        this.butacasporfila=butacasporfila;
        this.numeroFilas=numeroFilas;
        for (int i=1;i<=numeroFilas;i++){
            Fila fila = new Fila(String.valueOf((char)(64+i)));
            fila.generarButacas(butacasporfila);
            filas.add(fila);
        }
    }

    public String mostrarAsientos() {
        StringBuilder asientos = new StringBuilder();
        asientos.append("  ");
        for (int i=1;i<=butacasporfila;i++) {
            asientos.append("  ").append(ANSI_RESET).append(i).append("  ");
            asientos.append(" ");
        }
        asientos.append("\n");
        for (Fila fila : filas) {
            asientos.append(ANSI_RESET).append(fila.codigoFila).append(": ");
            for (Butaca butaca : fila.butacas
                 ) {
                if (butaca.estaDisponible()){
                    asientos.append(ANSI_GREEN + "!---! ");
                }
                else {
                    asientos.append(ANSI_RED + "!-*-! ");
                }
            }
            asientos.append("\n" + ANSI_RESET);
        }

        return asientos.toString();
    }

    public void setCapacidad() {
        this.capacidad = filas.get(0).limiteButacas * numeroFilas;
    }

    public String getCodigosala() {return "SALA - " + codigosala;}

    public void addfila(Fila fila){filas.add(fila);}

    public ArrayList<Fila> getFilas() {return filas;}

    public int getCapacidad() {
        return capacidad;
    }

    public Butaca getButaca(char codigoFila, int numButaca) {
        return searchFila(""+codigoFila).searchButaca(numButaca);
    }

    public ArrayList<String> getButacasLibres() {
        ArrayList<String> butacasLibres = new ArrayList();
        for (Fila fila : filas
        ) {
            for (Butaca butaca : fila.butacas
            ) {
                if (butaca.estaDisponible()){butacasLibres.add(butaca.id);}
            }
        }
        return butacasLibres;
    }

    public Fila searchFila(String codigoFila) {
        Fila filaEncontrada = null;
        for (Fila fila:filas
        ) {
            if (fila.codigoFila.equals(codigoFila)) {
                filaEncontrada = fila;
            }
        }
        return filaEncontrada;
    }
}
