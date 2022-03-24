import java.util.ArrayList;

public class Registro {
    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Empleado> empleados = new ArrayList<>();

    public void registrar(Cliente cliente) {
        cliente.setIdClient(getSizeClientes());
        clientes.add(cliente);
    }

    public void registrar(Empleado empleado) {
        empleado.setIdEmpleado(getSizeEmpleados());
        empleados.add(empleado);
    }


    //cuando encuentra al cliente en los registros devuelve el indice para que puedan manejar ese cliente
    //si no lo encuentra devolvera un valor -1 lo cual si intentamos accederlo, retornara un error de que ese indice no existe
    public int searchClienteIndice(int id) {
        int indice = -1;
        for (Cliente cliente : clientes
             ) {
            if (cliente.getId() == id) {
                indice = clientes.indexOf(cliente);
            }
            else {
                System.out.println("No encontramos el Cliente, puedes registrarlo");
            }
        }
        return indice;
    }

    public void actualizarEdades() {
        for (Cliente cliente : clientes
             ) {
            cliente.setEdad();
        }
        for (Empleado empleado : empleados
             ) {
            empleado.setEdad();
        }
    }

    public int getSizeEmpleados() {
        return empleados.size();
    }

    public int getSizeClientes() {
        return empleados.size();
    }
}
