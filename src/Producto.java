public class Producto extends ObjetoEnCine{
    public Producto(String name, Double priceMoney, int pricePoints, int cantidadDisponible) {
        super(name, priceMoney, pricePoints, cantidadDisponible);
    }

    @Override
    public String cabecera() {
        return "------------------------------PRODUCTO-----------------------------";
    }
}
