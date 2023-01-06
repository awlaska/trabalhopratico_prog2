import ENUM.estadoReserva;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class Reserva {
    private int nrReserva;
    private int diaVisita;
    private int mesVisita;
    private int anoVisita;
    private int idCliente;
    private int idCarro;
    protected estadoReserva estado;
    protected ArrayList<Reserva> resLoad = new ArrayList<>();

    public Reserva() throws IOException {}

    public Reserva(int nrReserva, int diaVisita, int mesVisita, int anoVisita, int idCliente, int idCarro, estadoReserva estado) throws IOException {
        this.nrReserva = nrReserva;
        this.diaVisita = diaVisita;
        this.mesVisita = mesVisita;
        this.anoVisita = anoVisita;
        this.idCliente = idCliente;
        this.idCarro = idCarro;
        this.estado = estado;
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
    public estadoReserva getEstado() {
        return estado;
    }

    public ArrayList<Reserva> loadListReserva() throws IOException {
        resLoad = Ficheiro.loadListReserva("reservas", 6);
        return resLoad;
    }
    public void writeListReserva() throws IOException {
        Ficheiro.escreverFicheiroReserva("reservas", resLoad);
    }

    //DOING o método tem de ser verificado, funciona mas pode ter "lixo"
    //DOING path para o menu anterior
    //DOING alterar o estado do veiculo para RESERVADO quando uma reserva é concluida
    //DOING apenas permitir reservar veiculos que se encontram no estado DISPONIVEL
    public int adicionarReserva(int user) throws IOException {
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
                res1 = new Reserva(nrRes, diaVisita, mesVisita, anoVisita, user, idCarro, estadoReserva.CRIADA);
                certo = true;
        } while (!certo);
        resLoad.add(res1);
        writeListReserva();

        return idCarro;
    }

    //DOING alterarDataVisita -> apenas permite alterar as reservas que contem o idUser passado como parametro
    //DOING path para o menu anterior
    public void alterarDataVisita(int idUser) {
//        for (int i = 0; i < reservas.size(); i++) {
//            if (reservas.get(i).getNrReserva() == nrReserva) {
//                //...
//            }
//        }
    }

    //DOING apagarReserva -> corrigir e testar o método
    //DOING cliente apenas pode apagar as dele
    //DOING dono e admin podem apagar a reserva que quiser
    public void apagarReserva(int idUser) {
//        for (int i = 0; i < reservas.size(); i++) {
//            if (reservas.get(i).getNrReserva() == nrReserva) {
//                reservas.remove(i);
//            }
//        }
    }

    //DOING Listagem de reservas por ordem de data de visita, data mais proxima para menos
    //DOING !!se der tempo!! listar em conjunto a info do carro reservado
    public void listarRes(int idUser) throws IOException {
        //if(idUserAtual contem tipo != 'CLIENTE')
        System.out.println("\nNum. Reserva, dia, mês, ano, id user, id carro");
        //TODO se id passado for de tipo "CLIENTE" apenas mostra o que tiver id dele
        //else
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