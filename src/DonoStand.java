import ENUM.estadoVeiculo;
import ENUM.tipoUser;

import java.io.IOException;
import java.util.*;

public class DonoStand extends Utilizador implements IListar {
    Veiculo veic = new Veiculo();
    LinkedHashMap<Integer, List<String>> utilizadores = Ficheiro.loadMap("utilizadores", 6);
    LinkedHashMap<Integer, List<String>> veiculos = Ficheiro.loadMap("veiculos", 6);
    public DonoStand() throws IOException {
        super();
    }

    //TODO completar switch do menu
        /*
        Gerir Registos:
        -chamar metodo de adicionar veiculo (Veiculo)
        -Apagar Venda
        -Apagar Reserva
        -Alterar estado de um veiculo
        -Alterar dados de um veiculo
        -Alterar data de visita
        -Apagar veiculo
         */
    protected void menuD() throws IOException, UtilizadorException {
        LinkedHashMap<Integer, List<String>> utilizadores = Ficheiro.loadMap("utilizadores", 6);
        LinkedHashMap<Integer, List<String>> veiculos = Ficheiro.loadMap("veiculos", 6);
        Scanner input = new Scanner(System.in);

        System.out.print("0 - Sair\n1 - LogOut\n2 - Apagar cliente\n3 - Adicionar Veiculo\n4 - Alterar Estado Veiculo\n5 - Apagar Veiculo\n6 - Listagens\n>> ");
        int op = input.nextInt();

        System.out.println();

        switch (op) {
            case 0 -> {Ficheiro.saveAll(utilizadores, veiculos);break;}
            case 1 -> menuIncial();
            case 2 -> apagarCliente();
            case 3 -> veic.adicionarVeiculo(veiculos);
            case 4 -> veic.alterarEstado();
            case 5 -> veic.apagarVeiculo();
            case 6 -> menuListagens();
            default -> throw new IllegalStateException("Unexpected value: " + op);
        }
    }

    protected void menuListagens() throws IOException, UtilizadorException {
        LinkedHashMap<Integer, List<String>> utilizadores = Ficheiro.loadMap("utilizadores", 6);
        LinkedHashMap<Integer, List<String>> veiculos = Ficheiro.loadMap("veiculos", 6);
        Scanner input = new Scanner(System.in);

        System.out.println("0 - Sair\n1 - Listar Clientes\n2 - Listar Vendas\n3 - Listar Reservas\n4 - Listar Veiculos\n>> ");
        int op = input.nextInt();

        switch (op) {
            case 0 -> {Ficheiro.saveAll(utilizadores, veiculos);break;}
            case 1 -> listarUsers();
            case 2 -> listarCompras();
            case 3 -> listarReservas();
            case 4 -> listarVeiculos();
            default -> throw new IllegalStateException("Unexpected value: " + op);
        }
    }
    
    //TODO listagens:
        /*
        DONE Consegue ver tudo menos as contas de admins
        DOING Listagem de reservas por ordem de data de visita, data mais proxima para menos
         */

    private void apagarCliente() throws IOException, UtilizadorException {
        Scanner input = new Scanner(System.in);

        listarUsers();

        System.out.println("\n!!Apagar cliente!!");
        System.out.print("ID do cliente a apagar: \n>> ");
        int id = input.nextInt();

        if (utilizadores.get(id).get(4).equals("CLIENTE")) {
            for (int i = 0; i < 5; i++)
                utilizadores.get(id).set(i, "null");
        } else {
            throw new UtilizadorException("Não tem permissões para apgar este utilizador!");
        }

        Ficheiro.escreverFicheiro("utilizadores", utilizadores);
        menuD();
    }

    @Override
    public void listarCompras() throws IOException, UtilizadorException {
        System.out.println();
    }

    @Override
    public void listarUsers() throws IOException, UtilizadorException {
        System.out.println("\nid -> username, password, nome, telefone, tipo");
        for (Map.Entry<Integer, List<String>> entry : utilizadores.entrySet())
            if (entry.getValue().contains("CLIENTE")){
                System.out.println(entry.getKey() +
                        " -> " + entry.getValue().get(0) +
                        ", " + entry.getValue().get(1) +
                        ", " + entry.getValue().get(2) +
                        ", " + entry.getValue().get(3) +
                        ", " + entry.getValue().get(4));
            }
        System.out.println();
    }

    @Override
    public void listarReservas() throws IOException, UtilizadorException {
        System.out.println();
    }

    @Override
    public void listarVeiculos() throws IOException, UtilizadorException {
        LinkedHashMap<Integer, List<String>> veiculos = Ficheiro.loadMap("veiculos", 6);
        System.out.println("\nid -> marca, modelo, matricula, data de entrada, estado");
        for (Map.Entry<Integer, List<String>> entry : veiculos.entrySet())
                System.out.println(entry.getKey() +
                        " -> " + entry.getValue().get(0) +
                        ", " + entry.getValue().get(1) +
                        ", " + entry.getValue().get(2) +
                        ", " + entry.getValue().get(3) +
                        ", " + entry.getValue().get(4));
        System.out.println();
    }

}
