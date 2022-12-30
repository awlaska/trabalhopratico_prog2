import ENUM.estadoVeiculo;
import ENUM.tipoUser;

import java.io.IOException;
import java.util.*;

public class DonoStand extends Utilizador implements IListar {
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
            case 3 -> adicionarVeiculo(veiculos);
            case 4 -> alterarEstado();
            case 5 -> apagarVeiculo();
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

    //TODO verificar se existe no map
    protected void adicionarVeiculo(LinkedHashMap<Integer, List<String>> map) throws UtilizadorException, IOException {
        List dados = new ArrayList();

//        while (!veiculos.containsValue(dados1)) {
            Scanner adicionar = new Scanner(System.in);
            System.out.print("Marca\n>> ");
            String marca = adicionar.nextLine();
            System.out.print("Modelo\n>> ");
            String modelo = adicionar.nextLine();
            System.out.print("Matricula\n>> ");
            String matricula = adicionar.nextLine();
            System.out.print("Data entrada no stand (dd-mm-aaaa)\n>> ");
            String data = adicionar.nextLine();
            estadoVeiculo tipo = estadoVeiculo.DISPONIVEL;
//            dados1.add(0,matricula);

            for (int i = 0; i <= map.size(); i++) {
                if (!map.containsKey(i)) {
                    id = i;
                }
            }

            dados.add(0, marca);
            dados.add(1, modelo);
            dados.add(2, matricula);
            dados.add(3, data);
            dados.add(4, tipo.toString());

//            boolean existe = false;
//            for (int i = 0; i < veiculos.size(); i++) {
//                if(veiculos.get(i).contains(matricula)){
//                    existe = true;
//                }
//            }

            if (map.containsValue(dados)) {
                System.out.println("Matricula ja existente!");
            } else {
                map.put(id, dados);
                Ficheiro.escreverFicheiro2("veiculos", map);
                System.out.println(veiculos);
                System.out.println("\n\n");
                menuD();
            }
//        }
    }

    private void alterarEstado() throws UtilizadorException, IOException {
        Scanner inputint = new Scanner(System.in);
        Scanner inputstring = new Scanner(System.in);

        listarVeiculos();

        System.out.println("\n!!Alteração do estado do veiculo!!");
        System.out.print("ID do veiculo:\n>> ");
        int id = inputint.nextInt();
        System.out.print("Estado a atribuir (DESATIVADO, RESERVADO, VENDIDO): \n>> ");
        String estado = inputstring.nextLine();


        if (estado.equalsIgnoreCase("DESATIVADO") || estado.equalsIgnoreCase("RESERVADO") || estado.equalsIgnoreCase("VENDIDO")) {
            veiculos.get(id).set(4, estado.toUpperCase());
        } else {
            System.out.println("Tipo inválido!");
        }

        Ficheiro.escreverFicheiro("veiculos", veiculos);
        menuD();
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
        menuD();
    }

    //TODO listagens:
        /*
        DONE Consegue ver tudo menos as contas de admins
        DOING Listagem de reservas por ordem de data de visita, data mais proxima para menos
         */


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
