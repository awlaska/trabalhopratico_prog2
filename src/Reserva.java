import java.io.IOException;
import java.util.Date;

public class Reserva extends Stand {
    private final int nrReserva;
    private Date dataReserva;
    private final int idCliente;
    private final int idDonoStand;
    private final int idCarro;

    public Reserva(int nrReserva, Date dataReserva, int idCliente, int idDonoStand, int idCarro) throws IOException {
        super();
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

    public int getIdCliente() {
        return idCliente;
    }

    public int getIdDonoStand() {
        return idDonoStand;
    }

    public int getIdCarro() {
        return idCarro;
    }

    //DONE adicionarReserva a list ?? que list?
    public void adicionarReserva(int nrReserva, Date dataReserva, int idCliente, int idDonoStand, int idCarro) throws IOException {
        new Reserva(nrReserva, dataReserva, idCliente, idDonoStand, idCarro);
    }

    //DONE alterarDataReserva
    public void alterarDataReserva(int nrReserva, Date novaDataReserva) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getNrReserva() == nrReserva) {
                reservas.get(i).setDataReserva(novaDataReserva);
            }
        }
    }

    //DONE apagarReserva
    public void apagarReserva(int nrReserva) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getNrReserva() == nrReserva) {
                reservas.remove(i);
            }
        }
    }
}