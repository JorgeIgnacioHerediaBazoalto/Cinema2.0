public class Souvenir extends ObjetoEnCine{
    public Souvenir(String name, Double priceMoney, int pricePoints, int cantidadDisponible) {
        super(name, priceMoney, pricePoints, cantidadDisponible);
    }

    @Override
    public String cabecera() {
        return "------------------------------SOUVENIR-----------------------------";
    }
}
