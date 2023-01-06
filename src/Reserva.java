import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Reserva extends Stand {
    private int nrReserva;
    private int diaVisita;
    private int mesVisita;
    private int anoVisita;
    private int idCliente;
    private int idCarro;
    protected ArrayList<Reserva> resLoad = new ArrayList<>();
    public Reserva() throws IOException {}

    public Reserva(int nrReserva, int diaVisita, int mesVisita, int anoVisita, int idCliente, int idCarro) throws IOException {
        this.nrReserva = nrReserva;
        this.diaVisita = diaVisita;
        this.mesVisita = mesVisita;
        this.anoVisita = anoVisita;
        this.idCliente = idCliente;
        this.idCarro = idCarro;
    }

    public int getNrReserva() {
        return nrReserva;
    }
    public int getDiaVisita() {
        return diaVisita;
    }
    public int getMesVisita() {
        return mesVisita;
    }
    public int getAnoVisita() {
        return anoVisita;
    }
    public int getIdCliente() {
        return idCliente;
    }
    public int getIdCarro() {
        return idCarro;
    }

    public void loadListReserva() throws IOException {
//        veiculos = Ficheiro.loadMap("veiculos", 6);
    }

    public int adicionarReserva(int user) throws IOException {
        resLoad = Ficheiro.loadList("reservas", 6);
        Scanner input = new Scanner(System.in);
        LocalDate currentdate = LocalDate.now();
        Reserva res1 = null;
        boolean certo = false;

        int nrRes = 0;
        int diaAtual;
        int mesAtual;
        int anoAtual;

        listarRes(user);

        System.out.println("\nCriação de reserva!");
        System.out.println("ID do carro que deseja reservar: ");
        idCarro = input.nextInt();
        System.out.println("Data para visitar o Stand:");
        do {
            do {
                System.out.println("Dia >> ");
                diaVisita = input.nextInt();
                if (diaVisita > 31) System.out.println("O dia inserido não é válido!");
            } while (diaVisita > 31);
            do {
                System.out.println("Mês >> ");
                mesVisita = input.nextInt();
                if (mesVisita > 12) System.out.println("O mês inserido não é válido!");
            } while (mesVisita > 12);
            do {
                System.out.println("Ano >> ");
                anoVisita = input.nextInt();
                if (anoVisita < 2023) System.out.println("O ano inserido não é válido!");
            } while (anoVisita < 2023);

            diaAtual = currentdate.getDayOfMonth();
            mesAtual = LocalDate.EPOCH.getMonthValue();
            anoAtual = currentdate.getYear();

            if(anoAtual > anoVisita)
                System.out.println("A data tem de ser válida!");
            else if(anoAtual == anoVisita && mesAtual > mesVisita)
                    System.out.println("A data tem de ser válida!");
            else if(anoAtual == anoVisita && mesAtual == mesVisita && diaAtual >= diaVisita)
                System.out.println("A data tem de ser válida!");
            else if((anoAtual == anoVisita && mesAtual < mesVisita) || (anoAtual < anoVisita && mesAtual == mesVisita && diaAtual < diaVisita))
                nrRes = resLoad.size();
                res1 = new Reserva(nrRes, diaVisita, mesVisita, anoVisita, user, idCarro);
                certo = true;

            //TODO listar veiculos
            //TODO verificar se é possivel reservar veiculo escolhido
            //TODO alterar estado do veiculo selecionado (class veiculo ou aqui?)

        } while (!certo);
        resLoad.add(res1);
        Ficheiro.escreverFicheiroReserva("reservas", resLoad);

        return idCarro;
    }

    //DOING alterarDataVisita -> apenas permite alterar as que dizem respeito ás que tem aquele idUser
    public void alterarDataVisita(int idUser) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getNrReserva() == nrReserva) {
                //...
            }
        }
    }

    //TODO apagarReserva -> testar
    public void apagarReserva(int idUser) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getNrReserva() == nrReserva) {
                reservas.remove(i);
            }
        }
    }

    //DONE
    public void listarRes(int idUser) throws IOException {
        resLoad = Ficheiro.loadList("reservas", 6);
        System.out.println("\nNum. Reserva, dia, mês, ano, id user, id carro");
        //TODO recebe metodo load map do utilizador, se id passado for de tipo "CLIENTE" apenas mostra o que tiver id dele, caso contrario mostra tudo
//        if(){
//            for (Reserva reserva : resLoad) {
//                System.out.println(reserva);
//            }
//        }
    }

    //DONE
    @Override
    public String toString() {
        return  + this.getNrReserva() + ", "
                + this.getDiaVisita() + ", "
                + this.getMesVisita() + ", "
                + this.getAnoVisita() + ", "
                + this.getIdCliente() + ", "
                + this.getIdCarro() + ";";
    }
}