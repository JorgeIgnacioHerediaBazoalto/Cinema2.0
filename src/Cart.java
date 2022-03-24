import java.util.ArrayList;

public class Cart {
    ArrayList<Producto> productos;
    ArrayList<Integer> cantidadProductos;
    int totalProducts = 0;
    ArrayList<Souvenir> souvenirs;
    ArrayList<Integer> cantidadSouvenirs;
    int totalSouvenirs = 0;

    public Cart() {
        this.productos = new ArrayList<>();
        this.cantidadProductos = new ArrayList<>();
        this.souvenirs = new ArrayList<>();
        this.cantidadSouvenirs = new ArrayList<>();
    }

    public void addProduct(Producto producto, int cantidad) {
        productos.add(producto);
        cantidadProductos.add(cantidad);
    }

    public void addSouvenir(Souvenir souvenir, int cantidad) {
        souvenirs.add(souvenir);
        cantidadSouvenirs.add(cantidad);
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public ArrayList<Souvenir> getSouvenirs() {
        return souvenirs;
    }

    public ArrayList<Integer> getCantidadProductos() {
        return cantidadProductos;
    }

    public ArrayList<Integer> getCantidadSouvenirs() {
        return cantidadSouvenirs;
    }

    public int getSizeProducts() {
        return productos.size();
    }

    public int getSizeSouvenir() {
        return souvenirs.size();
    }

    public int getTotalProducts() {
        setTotalProducts();
        return totalProducts;
    }

    public int getTotalSouvenirs() {
        setTotalSouvenirs();
        return totalSouvenirs;
    }

    public void setTotalProducts() {
        for (int i = 0; i < getSizeProducts(); i++) {
            totalProducts += (productos.get(i).priceMoney * cantidadProductos.get(i));
        }
    }

    public void setTotalSouvenirs() {
        for (int i = 0; i < getSizeSouvenir(); i++) {
            totalSouvenirs += (souvenirs.get(i).priceMoney * cantidadSouvenirs.get(i));
        }
    }

    public void setCartNew() {
        productos.clear();
        souvenirs.clear();
        totalProducts = 0;
        totalSouvenirs = 0;
    }

}
