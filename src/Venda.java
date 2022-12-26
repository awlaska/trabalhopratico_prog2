public class Venda {
    private int idCliente;
    private int idDonoStand;
    private int idCarro;

    //TODO metodos para:
        /*
        adicionar venda á list
         */
    public Venda(int idCliente, int idDonoStand, int idCarro){
        this.idCliente = idCliente;
        this.idDonoStand = idDonoStand;
        this.idCarro = idCarro;
    }

    public Venda(int nrReserva){
        Reserva.getReservas()
    }
}
