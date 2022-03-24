import java.util.ArrayList;

public class Almacen {
    ArrayList<Producto> productos;
    ArrayList<Souvenir> souvenirs;

    public Almacen(){
    }

    public void addProduct(Producto producto) {
        productos.add(producto);
    }

    public void addSouvenir(Souvenir souvenir) {
        souvenirs.add(souvenir);
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public ArrayList<Souvenir> getSouvenirs() {
        return souvenirs;
    }

    public int getSizeProducts() {
        return productos.size();
    }

    public int getSizeSouvenir() {
        return souvenirs.size();
    }
}
