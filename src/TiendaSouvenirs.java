import java.util.ArrayList;

public class TiendaSouvenirs {
    Cine cine;
    Empleado empleado;
    ArrayList<Souvenir> souvenirs;

    public TiendaSouvenirs(Empleado empleado, Cine cine) {
        this.souvenirs = new ArrayList<>();
        this.cine = cine;
        this.empleado = empleado;
    }

    public void addSouvenir(Souvenir souvenir) {
        souvenirs.add(souvenir);
    }

    public String mostrarSouvenirs() {
        String returnSouvenirs = "";
        for (Souvenir souvenir : souvenirs
        ) {
            returnSouvenirs += "PRODUCTO N°: " + souvenirs.indexOf(souvenir) + "\n" +
                    "\t" + souvenir.infoObjeto(-1) + "\n------------------------------------------------------------\n";
        }
        return returnSouvenirs;
    }

    //falta agregar las formas de pago
    //Solucionar implementacion de los metodos por sus parametros
    //@Override
    public void comprar(Cliente cliente, Souvenir souvenir, int cantidad) {
        cliente.getCart().addSouvenir(souvenir, cantidad);
        souvenirs.get(souvenirs.indexOf(souvenir)).vender(cantidad);

    }

    public String facturar(Cliente cliente) {
        return formatoFactura(cliente, empleado, cine);
    }

    public String formatoFactura(Cliente cliente, Empleado empleado, Cine cine) {
        int n1 = 45;
        int n2 = 8;
        int n3 = 7;


        String factura = "" +
                "=".repeat(n1) + "\n" +
                " ".repeat(12) + "Factura Cine " + cine.getNombre() + "\n" +
                " ".repeat(12) + "TIENDA SOUVENIRS" + "\n" +
                "=".repeat(n1) + "\n" +
                "=".repeat(n1) + "\n" + "\n" +
                " ".repeat(15) + "FACTURA N.12356" + "\n" + " ".repeat(7) + "AUTORIZACION N. 332401100018913" + "\n" + "\n" +
                " ".repeat(n2) + "Actividades de cinematografia" + "\n" + " ".repeat(12) + "y otras actividades" + "\n" + "\n" +
                " ".repeat(n2) + "Fecha" + " ".repeat(n2) + ":" + " ".repeat(n3) + cine.getFechaActual() + "\n" +
                " ".repeat(n2) + "Hora" + " ".repeat(9) + ":" + " ".repeat(n3) + /*cine.getHoraActual()*/"HORA-ACTUAL" + "\n" +
                " ".repeat(n2) + "Cliente" + " ".repeat(6) + ":" + " ".repeat(n3) + cliente.getName() + "\n" +
                //System.out.println(" ".repeat(n2) + "Pago"+" ".repeat(9)+":"+" ".repeat(n3) + cliente.getFormaDePago+"\n");
                " ".repeat(2) + "Detalle" + " ".repeat(15) + "Cant." + " ".repeat(6) + "Subtotal" + "\n" + " " + "-".repeat(43) + "\n" +
                listarSouvenirs(cliente) + "\n" +
                " ".repeat(33) + "Total Bs: " + cliente.cart.getTotalSouvenirs() + "\n" + "-".repeat(45) + "\n" + "\n" +
                " ".repeat(3) + "ESTA FACTURA CONTRIBUYE AL DESARROLLO" + "\n" +
                " ".repeat(3) + "DEL PAIS, EL USO ILICITO DE ESTA SERA" + "\n" +
                " ".repeat(3) + "SANCIONADO DE ACUERDO A LA LEY Nº 453" + "\n" +
                "=".repeat(n1) + "\n";
        cliente.cart.setCartNew();

        return factura;
    }

    public String listarSouvenirs(Cliente cliente) {
        String souvenirs = "";
        for (int i = 0; i < cliente.cart.getSizeSouvenir(); i++) {
            souvenirs += "Producto: " + cliente.cart.getSouvenirs().get(i).name + "\n" +
                    "\tPrecio (c/u): " + cliente.cart.getSouvenirs().get(i).priceMoney + "\n" +
                    "\tCantidad: " + cliente.cart.getCantidadSouvenirs().get(i) + "\n" +
                    "\tSubtotal: " + cliente.cart.getSouvenirs().get(i).priceMoney * cliente.cart.getCantidadSouvenirs().get(i) + "\n\n";
        }
        cliente.cart.setTotalProducts();
        return souvenirs
}
