import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Reserva extends Stand {
    private int nrReserva;
    private int diaVisita;
    private int mesVisita;
    private int anoVisita;
    private int idCliente;
    private int idCarro;
    protected ArrayList<Reserva> reserva = Ficheiro.loadList("reservas", 6);
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

    //DONE adicionarReserva a list ?? que list?
    public void adicionarReserva(int user) throws IOException {
        Scanner input = new Scanner(System.in);
        LocalDate currentdate = LocalDate.now();

        int diaAtual;
        int mesAtual;
        int anoAtual;

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
            mesAtual = Integer.parseInt(String.valueOf(currentdate.getMonth()));
            anoAtual = currentdate.getYear();

            if((diaAtual < diaVisita) && (mesAtual< mesVisita) && (anoAtual < anoVisita)) System.out.println("A data tem de ser válida!");
        } while ((diaAtual < diaVisita) && (mesAtual< mesVisita) && (anoAtual < anoVisita));
        nrReserva = reserva.size();

        Reserva res = new Reserva(nrReserva, diaVisita, mesVisita, anoVisita, user, idCarro);
        reserva.add(res);
        Ficheiro.escreverFicheiroReserva("reservas", reserva);
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