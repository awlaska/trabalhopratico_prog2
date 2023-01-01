import ENUM.estadoVeiculo;

import java.io.IOException;
import java.util.*;

public class Veiculo extends Stand{
    //TODO metodos:
        /*
        Criar list para armazenar veiculos
        adicionar veiculo á list
        editar info de um veiculo na list
        alterar estado do veiculo
        remover veiculo da list
        */

    private int numCarro;
    private String marca;
    private String modelo;
    private String dataManufatura;
    private String matricula;
    private estadoVeiculo estado = estadoVeiculo.DISPONIVEL;

    LinkedHashMap<Integer, List<String>> veiculos = Ficheiro.loadMap("veiculos", 6);

    public Veiculo() throws IOException {
        super();
    }

    public void adicionarVeiculo(LinkedHashMap<Integer, List<String>> map) throws IOException {
        List dados = new ArrayList();

//        while (!veiculos.containsValue(dados1)) {
        Scanner adicionar = new Scanner(System.in);
        System.out.print("Marca\n>> ");
        this.marca = adicionar.nextLine();
        System.out.print("Modelo\n>> ");
        this.modelo = adicionar.nextLine();
        System.out.print("Matricula\n>> ");
        this.matricula = adicionar.nextLine();
        System.out.print("Data entrada no stand (dd-mm-aaaa)\n>> ");
        this.dataManufatura = adicionar.nextLine();
        this.estado = estadoVeiculo.DISPONIVEL;

        for (int i = 0; i <= map.size(); i++) {
            if (!map.containsKey(i)) {
                numCarro = i;
            }
        }

        dados.add(0, marca);
        dados.add(1, modelo);
        dados.add(2, matricula);
        dados.add(3, dataManufatura);
        dados.add(4, estado.toString());

        if (map.containsValue(dados)) {
            System.out.println("Matricula ja existente!");
        } else {
            map.put(numCarro, dados);
            Ficheiro.escreverFicheiro2("veiculos", map);
            System.out.println(veiculos);
            System.out.println("\n\n");
        }
//        }
    }
    //TODO verificar se existe no map


    public void alterarEstado() throws UtilizadorException, IOException {
        Scanner inputint = new Scanner(System.in);
        Scanner inputstring = new Scanner(System.in);

//        listarVeiculos();

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
//        menuD();
    }

    public void apagarVeiculo() throws IOException, UtilizadorException {
        Scanner input = new Scanner(System.in);

//        listarVeiculos();

        System.out.println("\n!!Apagar veiculo!!");
        System.out.print("ID do veiculo: \n>> ");
        int id = input.nextInt();

        for (int i = 0; i < 5; i++)
            veiculos.get(id).set(i, "null");

        Ficheiro.escreverFicheiro("veiculos", veiculos);
//        menuD();
    }

}