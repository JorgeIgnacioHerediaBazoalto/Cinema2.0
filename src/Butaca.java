public class Butaca {
    int numero;
    boolean disponible;
    String id;

    public Butaca(int numero,boolean disponible){
        this.numero=numero;
        this.disponible=disponible;
    }

    public boolean estaDisponible() {
        return disponible;
    }

    public int getNumero() {
        return numero;
    }

    public String getInfoButaca() {
        String info = "";
        info += "Numero de butaca:" + getNumero() + "\n";
        info += "Disponibilidad:" + estaDisponible() + "\n";
        return info;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setId(String fila){
        this.id = fila + numero;
    }

    public String getId() {
        return id;
    }
}
