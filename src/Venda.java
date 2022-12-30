import java.io.IOException;

public class Venda extends Stand {
    private int nrVenda;
    private int idCliente;
    private int idDonoStand;
    private int idCarro;

    //TODO metodos para:
        /*
        adicionar venda á list
         */
    public Venda(int nrVenda, int idCliente, int idDonoStand, int idCarro) throws IOException {
        super();
        this.nrVenda = nrVenda;
        this.idCliente = idCliente;
        this.idDonoStand = idDonoStand;
        this.idCarro = idCarro;
    }

    //DONE
    public Venda(int nrReserva) throws IOException {
        super();
        for (int i = 0; i < vendas.size(); i++) {
            if (reservas.get(i).getNrReserva() == nrReserva) {
                Venda venda = new Venda(reservas.get(i).getNrReserva(), reservas.get(i).getIdCliente(), reservas.get(i).getIdDonoStand(), reservas.get(i).getIdCarro());
                vendas.add(venda);
                reservas.remove(i);
            }
        }
    }
}
