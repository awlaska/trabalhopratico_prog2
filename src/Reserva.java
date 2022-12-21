import java.util.Date;

public class Reserva {

    //TODO metodos para:
        /*
        adicionar reservas á list
        alterar data da reserva
        cacelar/apagar reserva
         */
    private int nrReserva;
    private Date dataReserva;
    private Veiculo veiculo;
    private Utilizador cliente;

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
}
