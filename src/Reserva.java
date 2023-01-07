import ENUM.estadoReserva;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Reserva {
    protected estadoReserva estado;
    protected ArrayList<Reserva> resLoad = new ArrayList<>();
    Veiculo v = new Veiculo();
    private int nrReserva;
    private int diaVisita;
    private int mesVisita;
    private int anoVisita;
    private int idCliente;
    private int idCarro;

    public Reserva() throws IOException {
    }

    public Reserva(int nrReserva, int diaVisita, int mesVisita, int anoVisita, int idCliente, int idCarro, estadoReserva estado) throws IOException {
        this.nrReserva = nrReserva;
        this.diaVisita = diaVisita;
        this.mesVisita = mesVisita;
        this.anoVisita = anoVisita;
        this.idCliente = idCliente;
        this.idCarro = idCarro;
        this.estado = estado;
    }

    public void setDiaVisita(int diaVisita) {
        this.diaVisita = diaVisita;
    }
    public void setMesVisita(int mesVisita) {
        this.mesVisita = mesVisita;
    }
    public void setAnoVisita(int anoVisita) {
        this.anoVisita = anoVisita;
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
        resLoad = Ficheiro.loadListReserva("reservas", 7);
        return resLoad;
    }
    public void writeListReserva() throws IOException {
        Ficheiro.escreverFicheiroReserva("reservas", resLoad);
    }

    //DOING path para o menu anterior
    //DONE Clean up do método
    //DOING metodo while caso o veiculo n esteja disponivel para pedir novamente um id de veiculo
    //DONE alterar o estado do veiculo para RESERVADO quando uma reserva é concluida
    //DONE apenas permitir reservar veiculos que se encontram no estado DISPONIVEL
    public int adicionarReserva(int user) throws IOException {
        v.loadMapVeiculo();
        Scanner input = new Scanner(System.in);
        Reserva res1 = null;
        boolean certo = false;
        int nrRes;

        listarRes(user);

        System.out.println("\n>>Criar Reserva<<");
        System.out.println("ID do carro que deseja reservar: ");
        idCarro = input.nextInt();
        if (v.veiculos.get(idCarro).get(5).equals("DISPONIVEL")) {
            System.out.println("Data para visitar o Stand:");
            do {
                atribuirData();
                nrRes = resLoad.size();
                res1 = new Reserva(nrRes, diaVisita, mesVisita, anoVisita, user, idCarro, estadoReserva.CRIADA);
                certo = true;
            } while (!certo);
            resLoad.add(res1);
            writeListReserva();
            reservarVeic(idCarro);
        } else {
            System.out.println("O veiculo selecionado não se encontra disponivel para reserva!");
        }
        return idCarro;
    }

    //DONE alterar estado do veiculo de DISPONIVEL para reservado
    public void reservarVeic(int idCarro) throws IOException {
        v.loadMapVeiculo();
        v.veiculos.get(idCarro).set(5, "RESERVADO");
        v.writeMapVeiculo();
        v.loadMapVeiculo();
    }

    //DONE reduzir redundancia (não fazer a verificação de validade duas vezes)
    public void atribuirData(){
        Scanner input = new Scanner(System.in);
        LocalDate currentdate = LocalDate.now();
        int diaAtual = currentdate.getDayOfMonth(), mesAtual = LocalDate.EPOCH.getMonthValue(), anoAtual = currentdate.getYear();
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

        if (anoAtual > anoVisita)
            System.out.println("A data tem de ser válida!");
        else if (anoAtual == anoVisita && mesAtual > mesVisita)
            System.out.println("A data tem de ser válida!");
        else if (anoAtual == anoVisita && mesAtual == mesVisita && diaAtual >= diaVisita)
            System.out.println("A data tem de ser válida!");
        else if ((anoAtual == anoVisita && mesAtual < mesVisita) || (anoAtual < anoVisita && mesAtual == mesVisita && diaAtual < diaVisita));
    }

    //DOING alterarDataVisita -> apenas permite alterar as reservas que contem o idUser passado como parametro
    //DOING path para o menu anterior
    public void alterarDataVisita(int idUser) throws IOException, UtilizadorException {
//        Cliente cliente = new Cliente();
        Scanner input = new Scanner(System.in);
        Reserva resD = null;
//        listarRes(idUser);

        System.out.println("\n>>Alterar Data Visita<<");
        System.out.print("Reserva que deseja alterar\n>> ");
        int resAlt = input.nextInt();
        for (Reserva entry : resLoad) {
            if (entry.getNrReserva() == resAlt) {
                if (entry.getIdCliente() == idUser) {
                    System.out.print("Data para visitar o Stand\n>> ");

                    atribuirData();
                    entry.setDiaVisita(diaVisita);
                    entry.setMesVisita(mesVisita);
                    entry.setAnoVisita(anoVisita);

                    int diaNovo = entry.getDiaVisita();
                    int mesNovo = entry.getMesVisita();
                    int anoNovo = entry.getAnoVisita();
                    int nrRes = entry.getNrReserva();
                    int idCar = entry.getIdCarro();

                    resD = new Reserva(nrRes, diaNovo, mesNovo, anoNovo, idUser, idCar, estadoReserva.CRIADA);
                    resLoad.set(entry.getNrReserva(), resD);
//                    System.out.println(resLoad);
                    writeListReserva();
//                    cliente.menuReservas(idUser);
                } //else {
//                    System.out.println("!Não tem permissão para alterar esta reserva!");
//                    alterarDataVisita(idUser);
//                }
            }
        }
    }

    //DOING apagarReserva -> corrigir e testar o método
    //DOING cliente apenas pode apagar as dele
    //DOING dono e admin podem apagar a reserva que quiser
    public void apagarReserva(int idUser) throws IOException {
        listarRes(idUser);
//        for (int i = 0; i < reservas.size(); i++) {
//            if (reservas.get(i).getNrReserva() == nrReserva) {
//                reservas.remove(i);
//            }
//        }
    }

    //DONE verificar se é cliente e imprmir apenas o que lhe diz respeito
    //DOING Listagem de reservas por ordem de data de visita, data mais proxima para menos
    public void listarRes(int idUser) throws IOException {
        Utilizador uM = new Utilizador();
        loadListReserva();
        uM.loadMapUtilizador();

        if (uM.utilizadores.get(idUser).get(4).equals("CLIENTE")) {
            System.out.println("\nNum. Reserva, dia, mês, ano, id user, id carro, estado");
            for (Reserva entry : resLoad) {
                if (entry.getIdCliente() == idUser)
                    System.out.print(resLoad);
            }
        } else {
            System.out.println("\nNum. Reserva, dia, mês, ano, id user, id carro, estado");
            for (Reserva entry : resLoad) {
                System.out.print(resLoad);
            }
        }
    }

    //DONE
    @Override
    public String toString() {
        return "\n" + this.getNrReserva() + ", "
                + this.getDiaVisita() + ", "
                + this.getMesVisita() + ", "
                + this.getAnoVisita() + ", "
                + this.getIdCliente() + ", "
                + this.getIdCarro() + ", "
                + this.getEstado();
    }
}