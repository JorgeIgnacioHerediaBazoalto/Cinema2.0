import java.time.LocalDate;

public class Persona {
    // Atributos

    private String name;
    private String nacionalidad;
    private int edad;
    private int id;
    private LocalDate fechaNacimiento;



    public Persona(String name, String nacionalidad, int id, LocalDate fechaNacimiento){
        this.setName(name);
        this.setNacionalidad(nacionalidad);
        this.setId(id);
        this.setFechaNacimiento(fechaNacimiento);
        this.setEdad(LocalDate.now().getYear() - fechaNacimiento.getYear());
    }

    public String getInfo() {
        String info = "";
        info += "Name:\t\t" + getName() + "\n";
        info += "Nacionalidad:\t" + getNacionalidad() + "\n";
        info += "ID\t\t" + getId() + "\n";
        info += "Edad:\t\t" + getEdad() + "\n";
        info += "Fecha de nacimiento:\t" + getFechaNacimiento() + "\n";

        return info;
    }

    public String getName() {
        return name;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public int getEdad() {
        return edad;
    }

    public int getId() {
        return id;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setEdad() {
        this.edad = LocalDate.now().getYear() - fechaNacimiento.getYear();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
