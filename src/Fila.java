import java.util.ArrayList;

public class Fila {
    int limiteButacas;
    String codigoFila;
    ArrayList<Butaca> butacas;

    public Fila(String codigo){
        this.codigoFila = codigo;
        this.butacas = new ArrayList<>();
    }

    public void generarButacas(int limiteButacas) {
        this.limiteButacas=limiteButacas;
        for (int i = 1; i <= limiteButacas; i++) {
            Butaca butaca = new Butaca(i, true);
            butaca.setId(codigoFila);
            addbutaca(butaca);
        }
    }

    public String getCodigofila() {
        return codigoFila;
    }

    public ArrayList<Butaca> getButacas() {
        return butacas;
    }

    public void addbutaca(Butaca butaca){
        if (butacas.size()<=10){
            butacas.add(butaca);
        }
        else {
            System.out.println("Fila llena");
        }
    }

    public String infoFila(){
        StringBuilder info= new StringBuilder();
        info.append("Código de fila ").append(getCodigofila()).append("\n");
        info.append("Numero de butaca\t\tDisponibilidad\n");
        for (Butaca butaca:getButacas()) {
            info.append(butaca.getNumero()).append("\t\t\t\t\t\t").append(butaca.estaDisponible()).append("\n");
        }
        return info.toString();
    }

    public Butaca searchButaca(int numeroButaca) {
        Butaca butacaEncontrada = null;
        for (Butaca butaca : butacas
        ) {
            if (butaca.numero == numeroButaca) {
                butacaEncontrada = butaca;
                break;
            }
        }
        return butacaEncontrada;
    }
}
