import java.util.Date;
import java.util.List;

public class Reserva {
    private int nrReserva;
    private Date dataReserva;
    private int idCliente;
    private int idDonoStand;
    private int idCarro;

    private List<Reserva> reservas;

    public Reserva(int nrReserva, Date dataReserva, int idCliente, int idDonoStand, int idCarro) {
        this.nrReserva = nrReserva;
        this.dataReserva = dataReserva;
        this.idCliente = idCliente;
        this.idDonoStand = idDonoStand;
        this.idCarro = idCarro;
    }

    public Date getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }

    public int getNrReserva() {
        return nrReserva;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    //DONE adicionarReserva a list ?? que list?
    public void adicionarReserva(int nrReserva, Date dataReserva, int idCliente, int idDonoStand, int idCarro){
        new Reserva(nrReserva, dataReserva, idCliente, idDonoStand, idCarro);
    }

    //DONE alterarDataReserva
    public void alterarDataReserva(int nrReserva, Date novaDataReserva){
        for (int i = 0; i < reservas.size(); i++) {
            if(reservas.get(i).getNrReserva() == nrReserva){
                reservas.get(i).setDataReserva(novaDataReserva);
            }
        }
    }

    //DONE apagarReserva
    public void apagarReserva(int nrReserva){
        for (int i = 0; i < reservas.size(); i++) {
            if(reservas.get(i).getNrReserva() == nrReserva){
                reservas.remove(i);
            }
        }
    }
}