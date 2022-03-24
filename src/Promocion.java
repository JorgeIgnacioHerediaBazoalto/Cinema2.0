import java.time.DayOfWeek;
import java.time.LocalDate;

public class Promocion
{

    Cliente cliente;

    public Promocion(Cliente cliente)
    {
        this.cliente = cliente;
    }

    public double obtenerDescuento(LocalDate fechaActual, int edad, GeneroPelicula genero, String bancoTarjeta)
    {
        double descuento = 0;
        if(edad>=60)
        {
            descuento = 0.5;
        }
        if(fechaActual.getDayOfWeek() == DayOfWeek.WEDNESDAY)
        {
            descuento = 0.5;
        }
        if(edad <= 10 && genero == GeneroPelicula.ANIMACION)
        {
            descuento = 0.15;
        }
        if(fechaActual.getDayOfWeek() == DayOfWeek.THURSDAY && bancoTarjeta.equals("Los Elefantes"))
        {
            descuento = 0.12;
        }

        return descuento;
    }
}
