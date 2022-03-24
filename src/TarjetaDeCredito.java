public class TarjetaDeCredito
{
    String banco;
    String propietario;
    double saldo;

    public TarjetaDeCredito( String banco, String propietario, double saldo)
    {
        this.banco = banco;
        this.propietario = propietario;
        this.saldo = saldo;
    }

    public String getBanco() {
        return banco;
    }
}
