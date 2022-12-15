import java.util.Date;

public class Reserva {
    private int nrReserva;
    private Date dataReserva;
    private Veiculo veiculo;
    private Utilizador cliente;
    private Utilizador donoStand;

    public Date getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Utilizador getCliente() {
        return cliente;
    }

    public void setCliente(Utilizador cliente) {
        this.cliente = cliente;
    }

    public Utilizador getDonoStand() {
        return donoStand;
    }

    public void setDonoStand(Utilizador donoStand) {
        this.donoStand = donoStand;
    }
}
