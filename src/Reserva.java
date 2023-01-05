import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
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

    public void adicionarReserva(int user) throws IOException {
        resLoad = Ficheiro.loadList("reservas", 6);
        Scanner input = new Scanner(System.in);
        LocalDate currentdate = LocalDate.now();
        Reserva res1 = null;
        boolean certo = false;

        int diaAtual;
        int mesAtual;
        int anoAtual;

        System.out.println(resLoad);
        System.out.println("Criação de reserva!");
        System.out.println("Número do carro que deseja reservar: ");
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
                System.out.println("A data tem de ser válida!1");
            else if(anoAtual == anoVisita && mesAtual > mesVisita)
                    System.out.println("A data tem de ser válida!2");
            else if(anoAtual == anoVisita && mesAtual == mesVisita && diaAtual >= diaVisita)
                System.out.println("A data tem de ser válida!3");
            else if((anoAtual == anoVisita && mesAtual < mesVisita) || (anoAtual < anoVisita && mesAtual == mesVisita && diaAtual < diaVisita))
                nrReserva = resLoad.size();
                res1 = new Reserva(nrReserva, diaVisita, mesVisita, anoVisita, user, idCarro);
                certo = true;
                //TODO verificar
        } while (!certo);
        // nrReserva = resLoad.size();
        System.out.println(res1);
        // Reserva res1 = new Reserva(nrReserva, diaVisita, mesVisita, anoVisita, user, idCarro);
        resLoad.add(res1);
        System.out.println(resLoad);
        Ficheiro.escreverFicheiroReserva("reservas", resLoad);
    }

    //DONE alterarDataVisita
//    public void alterarDataVisita(int nrReserva, LocalDate novaDataVisita) {
//        for (int i = 0; i < reservas.size(); i++) {
//            if (reservas.get(i).getNrReserva() == nrReserva) {
//                reservas.get(i).setDataVisita(novaDataVisita);
//            }
//        }
//    }

    //DONE apagarReserva
    public void apagarReserva(int nrReserva) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getNrReserva() == nrReserva) {
                reservas.remove(i);
            }
        }
    }
}