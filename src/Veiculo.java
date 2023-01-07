import ENUM.estadoVeiculo;

import java.io.IOException;
import java.util.*;

public class Veiculo {
    public LinkedHashMap<Integer, List<String>> veiculos = new LinkedHashMap<>();
    private int numCarro;
    private String marca;
    private String modelo;
    private String dataManufatura;
    private String matricula;
    private String precoBase;
    private estadoVeiculo estado = estadoVeiculo.DISPONIVEL;

    public Veiculo() throws IOException {

    }

    //DONE Load do mapa e Escrita do ficheiro
    public LinkedHashMap<Integer, List<String>> loadMapVeiculo() throws IOException {
        veiculos = Ficheiro.loadMap("veiculos", 7);
        return veiculos;
    }

    public void writeMapVeiculo() throws IOException {
        Ficheiro.escreverFicheiroVeiculo("veiculos", veiculos);
    }

    //DONE verificar se o novo tem matricula já existente no map
    //DOING corrigir ciclo while caso algo errado volta a pedir dados (kinda funciona), está sempre a pedir mesmo que n exista
    //DOING path para o menu anterior
    public void adicionarVeiculo(int idUser) throws IOException, UtilizadorException {
        List dados = new ArrayList();
        Scanner adicionar = new Scanner(System.in);
        loadMapVeiculo();
        boolean existe = false;

        System.out.print("Marca\n>> ");
        this.marca = adicionar.nextLine();
        System.out.print("Modelo\n>> ");
        this.modelo = adicionar.nextLine();
        System.out.print("Data manufatura (dd-mm-aaaa)\n>> ");
        this.dataManufatura = adicionar.nextLine();
        System.out.print("Matricula\n>> ");
        this.matricula = adicionar.nextLine();
        System.out.print("Preço base\n>> ");
        this.precoBase = adicionar.nextLine();
        this.estado = estadoVeiculo.DISPONIVEL;

        for (int i = 0; i <= veiculos.size(); i++) {
            if (!veiculos.containsKey(i)) {
                numCarro = i;
            }
        }

        for (int j = 0; j < veiculos.size(); j++) {
            if (veiculos.get(j).get(3).equalsIgnoreCase(matricula)) {
                existe = true;
            }
        }
        if (existe) {
            System.out.println("Matricula ja existente!");
            adicionarVeiculo(idUser);
        } else {
            dados.add(0, marca);
            dados.add(1, modelo);
            dados.add(2, dataManufatura);
            dados.add(3, matricula.toUpperCase());
            dados.add(4, precoBase);
            dados.add(5, estado.toString());

            veiculos.put(numCarro, dados);
            writeMapVeiculo();
            menuVeiculoAnt(idUser);
        }
    }

    //DONE alterar estado veiculo
    //DOING path para o menu anterior
    public void alterarEstado(int idUser) throws IOException, UtilizadorException {
        Scanner inputint = new Scanner(System.in);
        Scanner inputstring = new Scanner(System.in);

        listarVeiculos(idUser);

        System.out.println("\n!!Alteração do estado do veiculo!!");
        System.out.print("ID do veiculo:\n>> ");
        int id = inputint.nextInt();
        System.out.print("Estado a atribuir (DISPONIVEL, DESATIVADO, RESERVADO, VENDIDO): \n>> ");
        String estado = inputstring.nextLine();


        if (estado.equalsIgnoreCase("DESATIVADO") ||
                estado.equalsIgnoreCase("RESERVADO") ||
                estado.equalsIgnoreCase("VENDIDO") ||
                estado.equalsIgnoreCase("DISPONIVEL")) {
            veiculos.get(id).set(5, estado.toUpperCase());
        } else {
            System.out.println("Tipo inválido!");
            alterarEstado(idUser);
        }
        writeMapVeiculo();
        menuVeiculoAnt(idUser);
    }

    //DOING fazer o método
    public void apagarVeiculo(int idUser) throws IOException, UtilizadorException {}

    //DONE corrigir listar veiculo (caso não esteja em estado ATIVO o cliente não pode ver)
    //DOING path para o menu anterior
    public void listarVeiculos(int idUserAtual) throws IOException {
        Utilizador uM = new Utilizador();
        uM.loadMapUtilizador();
        loadMapVeiculo();
        if (uM.utilizadores.get(idUserAtual).get(4).equals("CLIENTE")) {
            System.out.println("\nid -> marca, modelo, data manufatura, matricula, preço base");
            for (Map.Entry<Integer, List<String>> entry : veiculos.entrySet())
                if (entry.getValue().contains("DISPONIVEL")) {
                    System.out.println(entry.getKey() +
                            " -> " + entry.getValue().get(0) +
                            ", " + entry.getValue().get(1) +
                            ", " + entry.getValue().get(2) +
                            ", " + entry.getValue().get(3) +
                            ", " + entry.getValue().get(4) + "€");
                }
            System.out.println();
        } else {
            System.out.println("\nid -> marca, modelo, data manufatura, matricula, preço base, estado");
            for (Map.Entry<Integer, List<String>> entry : veiculos.entrySet())
                System.out.println(entry.getKey() +
                        " -> " + entry.getValue().get(0) +
                        ", " + entry.getValue().get(1) +
                        ", " + entry.getValue().get(2) +
                        ", " + entry.getValue().get(3) +
                        ", " + entry.getValue().get(4) + "€ " +
                        ", " + entry.getValue().get(5));
            System.out.println();
        }
    }

    public void menuVeiculoAnt(int idUser) throws IOException, UtilizadorException {
        Cliente cliente = new Cliente();
        DonoStand dono = new DonoStand();
        Admin admin = new Admin();
        Utilizador user = new Utilizador();
        user.loadMapUtilizador();
        if (user.utilizadores.get(idUser).get(4).equals("ADMIN")) {
            admin.menuVeiculos(idUser);
        } else if (user.utilizadores.get(idUser).get(4).equals("DONO")) {
            dono.menuVeiculos(idUser);
        } else if (user.utilizadores.get(idUser).get(4).equals("CLIENTE")) {
            cliente.menuVeiculos(idUser);
        }
    }
}