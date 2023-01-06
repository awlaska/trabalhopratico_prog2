import java.io.IOException;
import java.util.ArrayList;

public class Venda {
    private int nrVenda;
    private int idCliente;
    private int idDonoStand;
    private int idCarro;
    protected ArrayList<Venda> venda = new ArrayList<>();

    public Venda(int nrVenda, int idCliente, int idDonoStand, int idCarro) throws IOException {
        super();
        this.nrVenda = nrVenda;
        this.idCliente = idCliente;
        this.idDonoStand = idDonoStand;
        this.idCarro = idCarro;
    }

//    public ArrayList<Venda> loadListVenda() {
//        venda = Ficheiro.loadListVenda("vendas", x);
//        return venda;
//    }
//    public void writeListVenda() throws IOException {
//        Ficheiro.escreverFicheiroVenda("Vendas", venda);
//    }

    //DOING adicionar uma venda (apenas dono consegue)
    //DOING altera o estado do carro para VENDIDO


    //DOING apagar venda (apenas dono consegue)
    //DOING altera estado do carro para DISPONIVEL


    //DOING listar vendas -> dono e admin veem tudo
    //DOING cliente apenas vê as dele
}
