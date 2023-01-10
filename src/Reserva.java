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

    public void adicionarReserva(int user) throws IOException, UtilizadorException {
        Scanner input = new Scanner(System.in);
        Reserva res1 = null;
        boolean certo = false;

        v.loadMapVeiculo();
        v.listarVeiculos(user);
        loadListReserva();

        System.out.println("\n>>Criar Reserva<<");
        System.out.print("ID do carro que deseja reservar\n>> ");
        idCarro = input.nextInt();
        if (v.veiculos.get(idCarro).get(5).equals("DISPONIVEL")) {
            System.out.print("\nData para visitar o Stand\n");
            do {
                atribuirData();
                nrReserva = resLoad.size();
                res1 = new Reserva(nrReserva, diaVisita, mesVisita, anoVisita, user, idCarro, estadoReserva.CRIADA);
                certo = true;
            } while (!certo);
            resLoad.add(res1); writeListReserva();
            reservarVeic(idCarro);
            menuReservaAnt(user);
        } else {
            System.out.println("!O veiculo selecionado não se encontra disponivel para reserva!");
            adicionarReserva(user);
        }
    }

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
            if (user.utilizadores.get(idUser).get(4).equals("CLIENTE")) {
                if (entry.getNrReserva() == resAlt) {
                    if (entry.getIdCliente() == idUser) {
                        System.out.print("\nData para visitar o Stand\n");
                        atribuirData();
                        entry.setDiaVisita(diaVisita); entry.setMesVisita(mesVisita); entry.setAnoVisita(anoVisita);
                        int diaNovo = entry.getDiaVisita(), mesNovo = entry.getMesVisita(), anoNovo = entry.getAnoVisita(),
                                nrRes = entry.getNrReserva(), idCar = entry.getIdCarro();

                        resD = new Reserva(nrRes, diaNovo, mesNovo, anoNovo, idUser, idCar, estadoReserva.CRIADA);
                        resLoad.set(entry.getNrReserva(), resD); writeListReserva();
                        menuReservaAnt(idUser);
                    } else {
                        System.out.println("!Não tem permissão para alterar esta reserva!");
                        alterarDataVisita(idUser);
                    }
                }
            } else if (user.utilizadores.get(idUser).get(4).equals("DONO") || user.utilizadores.get(idUser).get(4).equals("ADMIN")) {//DONO E ADMIN
                if (entry.getNrReserva() == resAlt) {
                    System.out.print("\nData para visitar o Stand\n");
                    atribuirData();
                    entry.setDiaVisita(diaVisita); entry.setMesVisita(mesVisita); entry.setAnoVisita(anoVisita);
                    int diaNovo = entry.getDiaVisita(), mesNovo = entry.getMesVisita(), anoNovo = entry.getAnoVisita(),
                            iUser = entry.getIdCliente(), nrRes = entry.getNrReserva(), idCar = entry.getIdCarro();

                    resD = new Reserva(nrRes, diaNovo, mesNovo, anoNovo, iUser, idCar, estadoReserva.CRIADA);
                    resLoad.set(entry.getNrReserva(), resD); writeListReserva();
                    menuReservaAnt(idUser);
                }
            }
        }
    }

    public void cancelarReserva(int idUser) throws IOException, UtilizadorException {
        Utilizador user = new Utilizador();
        Scanner input1 = new Scanner(System.in);
        Reserva resD = null;

        user.loadMapUtilizador();
        loadListReserva();
        listarRes(idUser);

        System.out.println("\n>>Cancelar Reserva<<");
        System.out.print("Reserva que deseja cancelar\n>> ");
        int resAlt = input1.nextInt();
        for (Reserva entry : resLoad) {
            if (user.utilizadores.get(idUser).get(4).equals("CLIENTE")) {
                if (entry.getNrReserva() == resAlt) {
                    if (entry.getIdCliente() == idUser) {
                        int dia = entry.getDiaVisita(), mes = entry.getMesVisita(), ano = entry.getAnoVisita(),
                                nrRes = entry.getNrReserva(), idCar = entry.getIdCarro();
                        resD = new Reserva(resAlt, dia, mes, ano, idUser, idCar, estadoReserva.CANCELADA);
                        resLoad.set(entry.getNrReserva(), resD); writeListReserva();
                        reativarVeic(idCarro);
                        menuReservaAnt(idUser);
                    } else {
                        System.out.println("!Não tem permissão para cancelar esta reserva!");
                        cancelarReserva(idUser);
                    }
                }
            } else {
                if (entry.getNrReserva() == resAlt) {
                    int dia = entry.getDiaVisita(), mes = entry.getMesVisita(), ano = entry.getAnoVisita(),
                            nrRes = entry.getNrReserva(), idCli = entry.getIdCliente(), idCar = entry.getIdCarro();
                    resD = new Reserva(resAlt, dia, mes, ano, idCli, idCar, estadoReserva.CANCELADA);
                    resLoad.set(entry.getNrReserva(), resD); writeListReserva();

                    reativarVeic(idCar);
                    menuReservaAnt(idUser);
                }
            }
        }
    }

    public void atribuirData() {
        Scanner input = new Scanner(System.in);
        LocalDate currentdate = LocalDate.now();
        int diaAtual = currentdate.getDayOfMonth(), mesAtual = LocalDate.EPOCH.getMonthValue(), anoAtual = currentdate.getYear();
        do {
            System.out.print("\nAno\n>> ");
            anoVisita = input.nextInt();
            if (anoAtual <= anoVisita) System.out.println("!O ano inserido não é válido!");
        } while (anoAtual <= anoVisita);
        do {
            System.out.print("\nMês\n>> ");
            mesVisita = input.nextInt();
            if (anoAtual == anoVisita && mesAtual > mesVisita) System.out.println("!O mês inserido não é válido!");
        } while (anoAtual == anoVisita && mesAtual > mesVisita);
        do {
            System.out.print("\nDia\n>> ");
            diaVisita = input.nextInt();
            if (anoAtual == anoVisita && mesAtual == mesVisita && diaAtual > diaVisita) System.out.println("!O dia inserido não é válido!");
        } while (anoAtual == anoVisita && mesAtual == mesVisita && diaAtual > diaVisita);
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

    public void listarRes(int idUser) throws IOException {
        Utilizador uM = new Utilizador();

        loadListReserva();
        uM.loadMapUtilizador();

        if (uM.utilizadores.get(idUser).get(4).contentEquals("CLIENTE")) {
            System.out.println("\n>>Reservas<<");
            System.out.println("\nNum. Reserva, dia, mês, ano, id user, id carro, estado");
            for (Reserva entry : resLoad)
                if (entry.getIdCliente() == idUser)
                    System.out.print(entry);
        } else {
            System.out.println("\n>>Reservas<<");
            System.out.println("\nNum. Reserva, dia, mês, ano, id user, id carro, estado");
            for (Reserva entry : resLoad) {
                System.out.print(entry);
            }
        }
    }

    @Override
    public String toString() {
        return this.getNrReserva() + ", "
                + this.getDiaVisita() + ", "
                + this.getMesVisita() + ", "
                + this.getAnoVisita() + ", "
                + this.getIdCliente() + ", "
                + this.getIdCarro() + ", "
                + this.getEstado() + "\n";
    }
}