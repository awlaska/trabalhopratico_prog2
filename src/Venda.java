import ENUM.estadoReserva;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Venda {
    protected ArrayList<Venda> venda = new ArrayList<>();
    Veiculo v = new Veiculo();
    Reserva r = new Reserva();
    private int nrVenda;
    private int diaVenda;
    private int mesVenda;
    private int anoVenda;
    private int idCliente;
    private int idCarro;
    private double valor;

    public Venda() throws IOException {
    }

    public Venda(int nrVenda, int diaVenda, int mesVenda, int anoVenda, int idCliente, int idCarro, double valor) throws IOException {
        this.nrVenda = nrVenda;
        this.diaVenda = diaVenda;
        this.mesVenda = mesVenda;
        this.anoVenda = anoVenda;
        this.idCliente = idCliente;
        this.idCarro = idCarro;
        this.valor = valor;
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

    public double getValor() {
        return valor;
    }

    public void loadListVenda() throws IOException {
        venda = Ficheiro.loadListVenda("vendas", 7);
    }

    public void writeListVenda() throws IOException {
        Ficheiro.escreverFicheiroVenda("Vendas", venda);
    }

    public void adicionarVenda(int user) throws IOException, UtilizadorException {
        Scanner input = new Scanner(System.in);

        listarVenda(user);

        System.out.println("\n\n>>Menu Venda<<");
        System.out.print("0 - Menu Anterior\n1 - Concluir Reserva\n2 - Criar Venda\n>> ");
        int op = input.nextInt();
        switch (op) {
            case 0 -> menuVendaAnt(user);
            case 1 -> concluirReserva(user);
            case 2 -> criarVenda(user);
            default -> throw new IllegalStateException("Unexpected value: " + op);
        }
    }

    public void concluirReserva(int idUser) throws IOException, UtilizadorException {
        Scanner input = new Scanner(System.in);
        Reserva resD;
        Venda vend;

        r.loadListReserva();
        v.loadMapVeiculo();
        r.listarRes(idUser);

        System.out.println("\n>>Concluir Reserva<<");
        System.out.print("Número da reserva que pretende concluir\n>>");
        int nrReserva = input.nextInt();
        for (Reserva entry : r.resLoad) {
            if (entry.getNrReserva() == nrReserva) {
                int nrRes = entry.getNrReserva(), idCli = entry.getIdCliente(), idCar = entry.getIdCarro();
                diaVenda = entry.getDiaVisita(); mesVenda = entry.getMesVisita(); anoVenda = entry.getAnoVisita();
                valor = Double.parseDouble(v.veiculos.get(idCar).get(4));
                nrVenda = venda.size();

                resD = new Reserva(nrRes, diaVenda, mesVenda, anoVenda, idCli, idCar, estadoReserva.CONLCUIDA);
                vend = new Venda(nrVenda, diaVenda, mesVenda, anoVenda, idCli, idCar, valor);

                r.resLoad.set(entry.getNrReserva(), resD); r.writeListReserva();
                venderVeic(idCar); v.writeMapVeiculo();

                venda.add(vend); writeListVenda();

                menuVendaAnt(idUser);
            } else {
                System.out.println("!Valor não é permitido!");
                concluirReserva(idUser);
            }
        }
    }

    public void criarVenda(int idUser) throws IOException, UtilizadorException {
        Scanner input = new Scanner(System.in);
        Utilizador u = new Utilizador();
        Venda vend;
        boolean certo;

        v.loadMapVeiculo();
        v.listarVeiculosDisponiveis();

        System.out.println("\n>>Criar Venda<<");
        System.out.print("ID do carro que deseja vender\n>> ");
        idCarro = input.nextInt();

        u.listarClientes();
        System.out.print("\nID do cliente\n>> ");
        idCliente = input.nextInt();
        if (v.veiculos.get(idCarro).get(5).equals("DISPONIVEL")) {
            System.out.print("\nData da Venda\n");
            do {
                atribuirData();
                valor = Double.parseDouble(v.veiculos.get(idCarro).get(4));
                nrVenda = venda.size();
                vend = new Venda(nrVenda, diaVenda, mesVenda, anoVenda, idCliente, idCarro, valor);
                certo = true;
            } while (!certo);
            venda.add(vend); writeListVenda();
            venderVeic(idCarro); v.writeMapVeiculo();
            menuVendaAnt(idUser);
        } else {
            System.out.println("!O veiculo selecionado não se encontra disponivel para reserva!");
            criarVenda(idUser);
        }
    }

    public void venderVeic(int idCarro) throws IOException {
        v.loadMapVeiculo();
        v.veiculos.get(idCarro).set(5, "VENDIDO");
        v.writeMapVeiculo();
        v.loadMapVeiculo();
    }

    public void atribuirData() {
        Scanner input = new Scanner(System.in);
        LocalDate currentdate = LocalDate.now();
        int diaAtual = currentdate.getDayOfMonth(), mesAtual = LocalDate.EPOCH.getMonthValue(), anoAtual = currentdate.getYear();

        do {
            System.out.print("\nAno\n>> ");
            anoVenda = input.nextInt();
            if (anoAtual <= anoVenda) System.out.println("!O ano inserido não é válido!");
        } while (anoAtual <= anoVenda);
        do {
            System.out.print("\nMês\n>> ");
            mesVenda = input.nextInt();
            if (anoAtual == anoVenda && mesAtual > mesVenda) System.out.println("!O mês inserido não é válido!");
        } while (anoAtual == anoVenda && mesAtual > mesVenda);
        do {
            System.out.print("\nDia\n>> ");
            diaVenda = input.nextInt();
            if (anoAtual == anoVenda && mesAtual == mesVenda && diaAtual > diaVenda) System.out.println("!O dia inserido não é válido!");
        } while (anoAtual == anoVenda && mesAtual == mesVenda && diaAtual > diaVenda);
    }

    public void menuVendaAnt(int idUser) throws IOException, UtilizadorException {
        Cliente cliente = new Cliente();
        DonoStand dono = new DonoStand();
        Admin admin = new Admin();
        Utilizador user = new Utilizador();
        user.loadMapUtilizador();
        if (user.utilizadores.get(idUser).get(4).equals("ADMIN")) {
            admin.menuVendas(idUser);
        } else if (user.utilizadores.get(idUser).get(4).equals("DONO")) {
            dono.menuVendas(idUser);
        } else if (user.utilizadores.get(idUser).get(4).equals("CLIENTE")) {
            cliente.menuVendas(idUser);
        }
    }

    public void listarVenda(int idUser) throws IOException {
        Utilizador uM = new Utilizador();
        loadListVenda();
        uM.loadMapUtilizador();

        if (uM.utilizadores.get(idUser).get(4).equals("CLIENTE")) {
            System.out.println("\n>>Compras Efetuadas<<");
            System.out.println("Num. Venda, dia, mês, ano, id cliente, id carro, valor");
            for (Venda entry : venda)
                if (entry.getIdCliente() == idUser)
                    System.out.print(entry);
        } else {
            System.out.println("\n>>Vendas<<");
            System.out.println("Num. Venda, dia, mês, ano, id cliente, id carro, valor");
            for (Venda entry : venda)
                System.out.print(entry);
        }
    }

    @Override
    public String toString() {
        return this.getNrVenda() + ", "
                + this.getDiaVenda() + ", "
                + this.getMesVenda() + ", "
                + this.getAnoVenda() + ", "
                + this.getIdCliente() + ", "
                + this.getIdCarro() + ", "
                + this.getValor() + " €\n";
    }
}
