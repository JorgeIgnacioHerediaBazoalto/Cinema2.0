import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;

public class Cine {
    String nombre;
    Boleteria boleteria;
    ArrayList<Sala> salas;
    int numerosalas;
    int indicesala;

    //FECHAS
    LocalDate fechaActual;
    LocalTime horaActual;

    public Cine(String nombre){
        this.nombre = nombre;
        this.salas = new ArrayList<>();
        this.boleteria = null;
    }

    public Cine(String nombre, Boleteria boleteria) {
        this.nombre = nombre;
        this.salas = new ArrayList<>();
        this.boleteria = boleteria;
        generarsalas(3,10,10);
        generarsalas(2,8,10);
        generarsalas(2,5,10);
    }

    public void generarsalas(int numerosalas,int numerofilas, int butacasporfila){
        this.numerosalas=numerosalas;
        for (int i=1;i<=numerosalas;i++){
            Sala sala = new Sala(String.valueOf((char)(65+indicesala)));
            sala.generarFilas(numerofilas,butacasporfila);
            salas.add(sala);
            indicesala++;
        }
    }

    public ArrayList<Sala> getSalas() {return salas;}

    public void addSala(Sala sala){salas.add(sala);}

    public String getNombre() {return nombre;}

    public LocalDate getFechaActual() {setFechaYHoraActual(); return fechaActual;}

    public LocalTime getHoraActual() {setFechaYHoraActual(); return horaActual;}

    public void setFechaYHoraActual(){
        this.fechaActual = LocalDate.now();
        this.horaActual = LocalTime.now();
    }

    public String infoCine(){
        StringBuilder info= new StringBuilder();
        info.append("Nombre del cine ").append(getNombre()).append("\n");
        for (Sala sala:salas) {
            info.append(sala.getCodigosala()).append("\n");
            info.append(sala.mostrarAsientos());
        }
        info.append("\n");
        return info.toString();
    }

    public void comprarbutaca(String codigosala,String codigofila,int numerobutaca){
        for (Sala sala:getSalas()) {
            if (Objects.equals("Sala - "+codigosala, sala.getCodigosala())){
                for (Fila fila:sala.getFilas()) {
                    if (Objects.equals(codigofila, fila.getCodigofila())){
                        for (Butaca butaca: fila.getButacas()) {
                            if (butaca.getNumero()==numerobutaca){
                                Butaca blanco = fila.getButacas().get(numerobutaca-1);
                                if (blanco.estaDisponible()){
                                    String c="";
                                    c+="Numero de sala: "+codigosala+"\n";
                                    c+="Numero de fila: "+codigofila+"\n";
                                    c+="Numero de butaca: "+numerobutaca+"\n";
                                    System.out.println(c);
                                    blanco.disponible=false;
                                    System.out.println(sala.mostrarAsientos());
                                }
                                else {
                                    System.out.println("Compra invalida");
                                }
                            }
                        }
                    }
                }
            }
        }

    }


}
