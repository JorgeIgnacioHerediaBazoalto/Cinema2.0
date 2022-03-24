public class ObjetoEnCine {
    String name;
    Double priceMoney;
    int pricePoints;
    int cantidadDisponible;

    public ObjetoEnCine(String name, Double priceMoney, int pricePoints, int cantidadDisponible) {
        this.name = name;
        this.priceMoney = priceMoney;
        this.pricePoints = pricePoints;
        this.cantidadDisponible = cantidadDisponible;
    }

    public String cabecera() {
        return null;
    }

    public void vender(int cantidad) {
        cantidadDisponible -= cantidad;
    }

    public String infoObjeto() {
        return cabecera() + "\n" +
                "NAME: " + name + "\n" +
                "PRECIO(Efectivo): " + priceMoney + "\n" +
                "PRECIO(Puntos): " + pricePoints + "\n";
    }

    public String infoObjeto(int num) {
        return "\n" +
                "NAME: " + name + "\n" +
                "PRECIO(Efectivo): " + priceMoney + "\n" +
                "PRECIO(Puntos): " + pricePoints + "\n" +
                "CANTIDAD DISPONIBLE: " + cantidadDisponible + "\n\n";
    }

    public String getName() {
        return name;
    }
}
