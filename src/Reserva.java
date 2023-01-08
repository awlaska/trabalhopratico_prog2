import ENUM.estadoReserva;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Reserva {
    protected ArrayList<Reserva> resLoad = new ArrayList<>();
    protected estadoReserva estado;
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

    public int getNrReserva() {
        return nrReserva;
    }

    public int getDiaVisita() {
        return diaVisita;
    }

    public void setDiaVisita(int diaVisita) {
        this.diaVisita = diaVisita;
    }

    public int getMesVisita() {
        return mesVisita;
    }

    public void setMesVisita(int mesVisita) {
        this.mesVisita = mesVisita;
    }

    public int getAnoVisita() {
        return anoVisita;
    }

    public void setAnoVisita(int anoVisita) {
        this.anoVisita = anoVisita;
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

    //done path para o menu anterior
    //DONE Clean up do método
    //DONE metodo while caso o veiculo n esteja disponivel para pedir novamente um id de veiculo
    //DONE alterar o estado do veiculo para RESERVADO quando uma reserva é concluida
    //DONE apenas permitir reservar veiculos que se encontram no estado DISPONIVEL
    public void adicionarReserva(int user) throws IOException, UtilizadorException {
        Scanner input = new Scanner(System.in);
        Reserva res1 = null;
        boolean certo = false;
        int nrRes;

        v.loadMapVeiculo();
        v.listarVeiculos(user);

        System.out.println("\n>>Criar Reserva<<");
        System.out.print("ID do carro que deseja reservar\n>> ");
        idCarro = input.nextInt();
        if (v.veiculos.get(idCarro).get(5).equals("DISPONIVEL")) {
            System.out.print("\nData para visitar o Stand\n");
            do {
                atribuirData();
                nrRes = resLoad.size();
                res1 = new Reserva(nrRes, diaVisita, mesVisita, anoVisita, user, idCarro, estadoReserva.CRIADA);
                certo = true;
            } while (!certo);
            resLoad.add(res1);
            writeListReserva();
            reservarVeic(idCarro);
            menuReservaAnt(user);
        } else {
            System.out.println("O veiculo selecionado não se encontra disponivel para reserva!");
            adicionarReserva(user);
        }
    }

    //DONE alterar estado do veiculo de DISPONIVEL para reservado
    public void reservarVeic(int idCarro) throws IOException {
        v.loadMapVeiculo();
        v.veiculos.get(idCarro).set(5, "RESERVADO");
        v.writeMapVeiculo();
        v.loadMapVeiculo();
    }

    public void reativarVeic(int idCarro) throws IOException {
        v.loadMapVeiculo();
        v.veiculos.get(idCarro).set(5, "DISPONIVEL");
        v.writeMapVeiculo();
        v.loadMapVeiculo();
    }


    //DONE reduzir redundancia (não fazer a verificação de validade duas vezes)
    public void atribuirData() {
        Scanner input = new Scanner(System.in);
        LocalDate currentdate = LocalDate.now();
        int diaAtual = currentdate.getDayOfMonth(), mesAtual = LocalDate.EPOCH.getMonthValue(), anoAtual = currentdate.getYear();
        do {
            System.out.print("\nDia >> ");
            diaVisita = input.nextInt();
            if (diaVisita > 31) System.out.println("O dia inserido não é válido!");
        } while (diaVisita > 31);
        do {
            System.out.print("\nMês >> ");
            mesVisita = input.nextInt();
            if (mesVisita > 12) System.out.println("O mês inserido não é válido!");
        } while (mesVisita > 12);
        do {
            System.out.print("\nAno >> ");
            anoVisita = input.nextInt();
            if (anoVisita < 2023) System.out.println("O ano inserido não é válido!");
        } while (anoVisita < 2023);

        if (anoAtual > anoVisita)
            System.out.println("A data tem de ser válida!");
        else if (anoAtual == anoVisita && mesAtual > mesVisita)
            System.out.println("A data tem de ser válida!");
        else if (anoAtual == anoVisita && mesAtual == mesVisita && diaAtual >= diaVisita)
            System.out.println("A data tem de ser válida!");
        else if ((anoAtual == anoVisita && mesAtual < mesVisita) || (anoAtual < anoVisita && mesAtual == mesVisita && diaAtual < diaVisita))
            ;
    }

    //DONE alterarDataVisita -> apenas permite alterar as reservas que contem o idUser passado como parametro
    //DONE path para o menu anterior
    public void alterarDataVisita(int idUser) throws IOException, UtilizadorException {
        Utilizador user = new Utilizador();
        Scanner input1 = new Scanner(System.in);
        Reserva resD = null;

        loadListReserva();
        user.loadMapUtilizador();
        listarRes(idUser);

        System.out.println("\n>>Alterar Data Visita<<");
        System.out.print("Reserva que deseja alterar\n>> ");
        int resAlt = input1.nextInt();

        for (Reserva entry : resLoad) {
            if (user.utilizadores.get(idUser).get(4).equals("CLIENTE")) {//CLIENTE
                if (entry.getNrReserva() == resAlt) {
                    if (entry.getIdCliente() == idUser) {
                        System.out.print("Data para visitar o Stand\n");
                        atribuirData();
                        entry.setDiaVisita(diaVisita);
                        entry.setMesVisita(mesVisita);
                        entry.setAnoVisita(anoVisita);
                        int diaNovo = entry.getDiaVisita(), mesNovo = entry.getMesVisita(), anoNovo = entry.getAnoVisita(),
                                nrRes = entry.getNrReserva(), idCar = entry.getIdCarro();

                        resD = new Reserva(nrRes, diaNovo, mesNovo, anoNovo, idUser, idCar, estadoReserva.CRIADA);
                        resLoad.set(entry.getNrReserva(), resD);
                        System.out.println(resLoad);
                        writeListReserva();
                        menuReservaAnt(idUser);
                    } else {
                        System.out.println("!Não tem permissão para alterar esta reserva!");
                        alterarDataVisita(idUser);
                    }
                }
            } else if (user.utilizadores.get(idUser).get(4).equals("DONO") || user.utilizadores.get(idUser).get(4).equals("ADMIN")) {//DONO E ADMIN
                if (entry.getNrReserva() == resAlt) {
                    System.out.print("Data para visitar o Stand\n>> ");
                    atribuirData();
                    entry.setDiaVisita(diaVisita);
                    entry.setMesVisita(mesVisita);
                    entry.setAnoVisita(anoVisita);
                    int diaNovo = entry.getDiaVisita(), mesNovo = entry.getMesVisita(), anoNovo = entry.getAnoVisita(),
                            iUser = entry.getIdCliente(), nrRes = entry.getNrReserva(), idCar = entry.getIdCarro();

                    resD = new Reserva(nrRes, diaNovo, mesNovo, anoNovo, iUser, idCar, estadoReserva.CRIADA);
                    resLoad.set(entry.getNrReserva(), resD);
                    System.out.println(resLoad);
                    writeListReserva();
                    menuReservaAnt(idUser);
                }
            }
        }
    }

    //DONE apagarReserva -> corrigir e testar o método
    //DONE cliente apenas pode apagar as dele
    //DONE dono e admin podem apagar a reserva que quiser
    public void cancelarReserva(int idUser) throws IOException, UtilizadorException {
        Utilizador user = new Utilizador();
        Scanner input1 = new Scanner(System.in);
        Reserva resD = null;
        user.loadMapUtilizador();
        loadListReserva();

        System.out.println("\n>>Cancelar Reserva<<");
        System.out.print("Reserva que deseja cancelar\n>> ");
        int resAlt = input1.nextInt();
        for (Reserva entry : resLoad) {
            if (user.utilizadores.get(idUser).get(4).equals("CLIENTE")) {//CLIENTE
                if (entry.getNrReserva() == resAlt) {
                    if (entry.getIdCliente() == idUser) {
                        int dia = entry.getDiaVisita(), mes = entry.getMesVisita(), ano = entry.getAnoVisita(),
                                nrRes = entry.getNrReserva(), idCar = entry.getIdCarro();
                        resD = new Reserva(resAlt, dia, mes, ano, idUser, idCar, estadoReserva.CANCELADA);
                        resLoad.set(entry.getNrReserva(), resD);
                        reativarVeic(idCarro);
                        writeListReserva();
                        menuReservaAnt(idUser);
                    } else {
                        System.out.println("!Não tem permissão para cancelar esta reserva!");
                        cancelarReserva(idUser);
                    }
                }
            } else if (user.utilizadores.get(idUser).get(4).equals("DONO") || user.utilizadores.get(idUser).get(4).equals("ADMIN")) {//DONO E ADMIN
                if (entry.getNrReserva() == resAlt) {
                    int dia = entry.getDiaVisita(), mes = entry.getMesVisita(), ano = entry.getAnoVisita(),
                            nrRes = entry.getNrReserva(), idCli = entry.getIdCliente(), idCar = entry.getIdCarro();
                    resD = new Reserva(resAlt, dia, mes, ano, idCli, idCar, estadoReserva.CANCELADA);
                    resLoad.set(entry.getNrReserva(), resD);
                    reativarVeic(idCarro);
                    writeListReserva();
                    menuReservaAnt(idUser);
                }
            }
        }
    }

    public void menuReservaAnt(int idUser) throws IOException, UtilizadorException {
        Cliente cliente = new Cliente();
        DonoStand dono = new DonoStand();
        Admin admin = new Admin();
        Utilizador user = new Utilizador();
        user.loadMapUtilizador();
        if (user.utilizadores.get(idUser).get(4).equals("ADMIN")) {
            admin.menuReservas(idUser);
        } else if (user.utilizadores.get(idUser).get(4).equals("DONO")) {
            dono.menuReservas(idUser);
        } else if (user.utilizadores.get(idUser).get(4).equals("CLIENTE")) {
            cliente.menuReservas(idUser);
        }
    }

    //DONE verificar se é cliente e imprmir apenas o que lhe diz respeito
    //DONE Listagem de reservas está a listar várias vezes o mesmo
    public void listarRes(int idUser) throws IOException {
        Utilizador uM = new Utilizador();
        loadListReserva();
        uM.loadMapUtilizador();

        if (uM.utilizadores.get(idUser).get(4).contentEquals("CLIENTE")) {
            System.out.print("\nNum. Reserva, dia, mês, ano, id user, id carro, estado");
            for (Reserva entry : resLoad)
                if (entry.getIdCliente() == idUser)
                    System.out.print(entry);
        } else { //DOING Listagem de reservas por ordem de data de visita, data mais proxima para menos
            System.out.print("\nNum. Reserva, dia, mês, ano, id user, id carro, estado");
            for (Reserva entry : resLoad)
                System.out.print(entry);
        }
    }

    //DONE
    @Override
    public String toString() {
        System.out.println();
        return this.getNrReserva() + ", "
                + this.getDiaVisita() + ", "
                + this.getMesVisita() + ", "
                + this.getAnoVisita() + ", "
                + this.getIdCliente() + ", "
                + this.getIdCarro() + ", "
                + this.getEstado();
    }
}