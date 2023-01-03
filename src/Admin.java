import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Admin extends Utilizador implements IListar {
    LinkedHashMap<Integer, List<String>> utilizadores = Ficheiro.loadMap("utilizadores", 6);
    LinkedHashMap<Integer, List<String>> veiculos = Ficheiro.loadMap("veiculos", 6);

    public Admin() throws IOException {
        super();
    }

    //DONE Gerir Users:
    //DONE - Alterar tipo de user
    //DONE - Apagar user
    //DONE Gerir Registos:
    //DOING -Apagar Venda
    //DOING -Apagar Reserva

    //--> MENUS
    protected void menuA() throws IOException, UtilizadorException {
        Scanner input = new Scanner(System.in);

        System.out.print("1 - LogOut\n2 - Listagens\n3 - Alterar Tipo de User\n4 - Apagar User\n5 - Apagar Veiculo\n6 - Apagar Venda\n7 - Apagar Reserva\n0 - Sair\n>> ");
        int op = input.nextInt();

        System.out.println();

        switch (op) {
            case 0 -> {
                Ficheiro.escreverFicheiro("utilizadores", utilizadores);
                break;
            }
            case 1 -> {
                menuIncial();
            }
            case 2 -> {
                listagens();
                break;
            }
            //DONE perguntar ao user quais apagar ou alterar
            case 3 -> {
                alterarTipoUser();
                break;
            }
            case 4 -> {
                apagarUser();
                break;
            }
            case 5 -> {
                apagarVeiculo();
                break;
            }
            //TODO meter para pedir qual venda e reserva a apagar
            case 6 -> {
                apagarVenda();
                break;
            }
            case 7 -> {
                apagarReserva();
                break;
            }
            default -> throw new IllegalStateException("Unexpected value: " + op);
        }
    }

    private void listagens() throws IOException, UtilizadorException {
        Scanner input = new Scanner(System.in);

        System.out.print("2 - Listar User\n3 - Listar Veiculos\n4 - Listar Compras\n5 - Listar Reservas\n0 - Sair\n1 - Retroceder\n>> ");
        int op = input.nextInt();

        System.out.println();

        switch (op) {
            case 0 -> {
                Ficheiro.escreverFicheiro("utilizadores", utilizadores);
                break;
            }
            case 1 -> {
                menuA();
            }
            case 2 -> {
                listarUsers();
            }
            case 3 -> {
                listarVeiculos();
            }
            case 4 -> {
                listarCompras();
            }
            case 5 -> {
                listarReservas();
            }
            default -> throw new IllegalStateException("Unexpected value: " + op);
        }
    }

    //-->METODOS ALTERAÇÃO E REMOÇÃO DE DADOS
    private void alterarTipoUser() throws IOException, UtilizadorException {
        Scanner inputint = new Scanner(System.in);
        Scanner inputstring = new Scanner(System.in);

        for (Map.Entry<Integer, List<String>> entry : utilizadores.entrySet())
            System.out.println(entry.getKey() + "->" + entry.getValue());

        System.out.println("\n!!Alteração do tipo de user!!");
        System.out.print("ID do user a alterar: \n>> ");
        int id = inputint.nextInt();
        System.out.print("Tipo de user a atribuir (ADMIN, DONO, CLIENTE): \n>> ");
        String tipo = inputstring.nextLine();


        if (tipo.equalsIgnoreCase("ADMIN") || tipo.equalsIgnoreCase("DONO") || tipo.equalsIgnoreCase("CLIENTE")) {
            utilizadores.get(id).set(4, tipo.toUpperCase());
        } else {
            System.out.println("Tipo inválido!");
        }

        Ficheiro.escreverFicheiro("utilizadores", utilizadores);
        menuA();
    }

    private void apagarUser() throws IOException, UtilizadorException {
        Scanner input = new Scanner(System.in);

        for (Map.Entry<Integer, List<String>> entry : utilizadores.entrySet()) {
            System.out.println("ID: " + entry.getKey() + "->" + entry.getValue());
        }

        System.out.println("!!Apagar user!!");
        System.out.print("ID do user a apagar: \n>> ");
        int id = input.nextInt();

        for (int i = 0; i < 5; i++)
            utilizadores.get(id).set(i, "null");

        Ficheiro.escreverFicheiro("utilizadores", utilizadores);
        menuA();
    }

    private void apagarVeiculo() throws IOException, UtilizadorException {
        Scanner input = new Scanner(System.in);

        listarVeiculos();

        System.out.println("\n!!Apagar veiculo!!");
        System.out.print("ID do veiculo: \n>> ");
        int id = input.nextInt();

        for (int i = 0; i < 5; i++)
            veiculos.get(id).set(i, "null");

        Ficheiro.escreverFicheiro("veiculos", veiculos);
        menuA();
    }
    //TODO apagarVenda e apagarReserva
    private void apagarVenda() {
//        for (int i = 0; i < venda.length()) {
//
//        }
    }

    private void apagarReserva() {
    }

    //TODO listagens: O Admin consegue ver o mesmo que o Dono + contas de outros admins

    //--> METODOS LISTAGEM
    @Override
    public void listarCompras() throws IOException, UtilizadorException {
//        System.out.println("\nid -> username, password, nome, telefone");
//        for (Map.Entry<Integer, List<String>> entry : utilizadores.entrySet())
//            System.out.println(entry.getKey() +
//                    " -> " + entry.getValue().get(0) +
//                    ", " + entry.getValue().get(1) +
//                    ", " + entry.getValue().get(2) +
//                    ", " + entry.getValue().get(3));
        System.out.println();
        menuA();
    }

    @Override
    public void listarUsers() throws IOException, UtilizadorException {
        System.out.println("\nid -> username, password, nome, telefone, estado");
        for (Map.Entry<Integer, List<String>> entry : utilizadores.entrySet())
            System.out.println(entry.getKey() +
                    " -> " + entry.getValue().get(0) +
                    ", " + entry.getValue().get(1) +
                    ", " + entry.getValue().get(2) +
                    ", " + entry.getValue().get(3) +
                    ", " + entry.getValue().get(4));
        System.out.println();
        menuA();
    }

    @Override
    public void listarReservas() throws IOException, UtilizadorException {
//        System.out.println("\nid -> username, password, nome, telefone");
//        for (Map.Entry<Integer, List<String>> entry : utilizadores.entrySet())
//            System.out.println(entry.getKey() +
//                    " -> " + entry.getValue().get(0) +
//                    ", " + entry.getValue().get(1) +
//                    ", " + entry.getValue().get(2) +
//                    ", " + entry.getValue().get(3));
        System.out.println();
        menuA();
    }

    @Override
    public void listarVeiculos() throws IOException, UtilizadorException {
        System.out.println("\nid -> marca, modelo, matricula, data de entrada, estado");
        for (Map.Entry<Integer, List<String>> entry : veiculos.entrySet())
                System.out.println(entry.getKey() +
                        " -> " + entry.getValue().get(0) +
                        ", " + entry.getValue().get(1) +
                        ", " + entry.getValue().get(2) +
                        ", " + entry.getValue().get(3) +
                        ", " + entry.getValue().get(4));
        System.out.println();
        menuA();
    }
}
