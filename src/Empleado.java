import java.time.LocalDate;

public class Empleado extends Persona{
    String idEmpleado;

    public Empleado(String name, String nacionalidad, int id, LocalDate fechaNacimiento) {
        super(name, nacionalidad, id, fechaNacimiento);
    }

    public void setIdEmpleado(int numEmpleado) {
        this.idEmpleado = "EMP-" + numEmpleado;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }
}
