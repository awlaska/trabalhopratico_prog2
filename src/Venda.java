import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Venda {
    private int nrVenda;
    private int diaVenda;
    private int mesVenda;
    private int anoVenda;
    private int idCliente;
    private int idCarro;
    protected ArrayList<Venda> venda = new ArrayList<>();

    public Venda(int nrVenda, int diaVenda, int mesVenda, int anoVenda, int idCliente, int idCarro) {
        this.nrVenda = nrVenda;
        this.diaVenda = diaVenda;
        this.mesVenda = mesVenda;
        this.anoVenda = anoVenda;
        this.idCarro = idCliente;
        this.idCarro = idCarro;
    }

    public int getNrVenda() {
        return nrVenda;
    }
    public int getDiaVenda() {
        return diaVenda;
    }
    public int getMesVenda() {
        return mesVenda;
    }
    public int getAnoVenda() {
        return anoVenda;
    }
    public int getIdCliente() {
        return idCliente;
    }
    public int getIdCarro() {
        return idCarro;
    }

    public ArrayList<Venda> loadListVenda() throws IOException {
        venda = Ficheiro.loadListVenda("vendas", 5);
        return venda;
    }
    public void writeListVenda() throws IOException {
        Ficheiro.escreverFicheiroVenda("Vendas", venda);
    }

    //DOING o método tem de ser verificado, funciona mas pode ter "lixo"
    //DOING adicionar uma venda (apenas dono consegue)
    //DOING altera o estado do carro para VENDIDO
    public int adicionarVenda(int user) throws IOException {
        Scanner input = new Scanner(System.in);
        LocalDate currentdate = LocalDate.now();
        Venda vend = null;
        boolean certo = false;

        int diaAtual, mesAtual, anoAtual;

        listarVenda(user);

        System.out.println("\nCriação de reserva!");
        System.out.println("ID do carro que deseja reservar: ");
        idCarro = input.nextInt();
        System.out.println("Data para visitar o Stand:");
        do {
            do {
                System.out.println("Dia >> ");
                diaVenda = input.nextInt();
                if (diaVenda > 31) System.out.println("O dia inserido não é válido!");
            } while (diaVenda > 31);
            do {
                System.out.println("Mês >> ");
                mesVenda = input.nextInt();
                if (mesVenda > 12) System.out.println("O mês inserido não é válido!");
            } while (mesVenda > 12);
            do {
                System.out.println("Ano >> ");
                anoVenda = input.nextInt();
                if (anoVenda < 2023) System.out.println("O ano inserido não é válido!");
            } while (anoVenda < 2023);

            diaAtual = currentdate.getDayOfMonth();
            mesAtual = LocalDate.EPOCH.getMonthValue();
            anoAtual = currentdate.getYear();

            if(anoAtual > anoVenda)
                System.out.println("A data tem de ser válida!");
            else if(anoAtual == anoVenda && mesAtual > mesVenda)
                System.out.println("A data tem de ser válida!");
            else if(anoAtual == anoVenda && mesAtual == mesVenda && diaAtual >= diaVenda)
                System.out.println("A data tem de ser válida!");
            else if((anoAtual == anoVenda && mesAtual < mesVenda) || (anoAtual < anoVenda && mesAtual == mesVenda && diaAtual < diaVenda))
                nrVenda = venda.size();
            vend = new Venda(nrVenda, diaVenda, mesVenda, anoVenda, idCliente, idCarro);
            certo = true;
        } while (!certo);
        venda.add(vend);writeListVenda();

        return idCarro;
    }

    //DOING apagar venda (apenas dono consegue)
    //DOING altera estado do carro para DISPONIVEL
    public void apagarVenda(){}

    //DOING listar vendas -> dono e admin veem tudo
    //DOING cliente apenas vê as dele
    public void listarVenda(int user){}
}
