import ENUM.estadoVeiculo;
import java.io.IOException;
import java.util.*;

public class Veiculo{
    private int numCarro;
    private String marca;
    private String modelo;
    private String dataManufatura;
    private String matricula;
    private float precoBase;
    private estadoVeiculo estado = estadoVeiculo.DISPONIVEL;

    protected LinkedHashMap<Integer, List<String>> veiculos = new LinkedHashMap<>();

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

    //DOING verificar se o novo tem matricula já existente no map
    //DOING corrigir ciclo while caso algo errado volta a pedir dados
    //DOING path para o menu anterior
    public void adicionarVeiculo() throws IOException {
        List dados = new ArrayList();
        loadMapVeiculo();

//        while (!veiculos.containsValue(dados1)) {
        Scanner adicionar = new Scanner(System.in);
        Scanner adicionarfl = new Scanner(System.in);
        System.out.print("Marca\n>> ");
        this.marca = adicionar.nextLine();
        System.out.print("Modelo\n>> ");
        this.modelo = adicionar.nextLine();
        System.out.print("Matricula\n>> ");
        this.matricula = adicionar.nextLine();
        System.out.print("Data entrada no stand (dd-mm-aaaa)\n>> ");
        this.dataManufatura = adicionar.nextLine();
        System.out.print("Preço base\n>> ");
        this.precoBase = adicionarfl.nextFloat();
        this.estado = estadoVeiculo.DISPONIVEL;

        for (int i = 0; i <= veiculos.size(); i++) {
            if (!veiculos.containsKey(i))
                numCarro = i;
        }

        dados.add(0, marca);
        dados.add(1, modelo);
        dados.add(2, matricula);
        dados.add(3, dataManufatura);
        dados.add(4, precoBase);
        dados.add(5, estado.toString());

        if (veiculos.containsValue(dados)) {
            System.out.println("Matricula ja existente!");
        } else {
            veiculos.put(numCarro, dados);writeMapVeiculo();
            System.out.println(veiculos);
            System.out.println("\n\n");
        }
//        }
    }

    //TODO alterar estado veiculo
    //DOING path para o menu anterior
    public void alterarEstado() throws IOException {
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
        writeMapVeiculo();
//        menuD();
    }

    //DOING corrigir listar veiculo (caso não esteja em estado ATIVO o cliente não pode ver)
    //DOING path para o menu anterior
    public void listarVeiculos(int idUserAtual) throws IOException {
    loadMapVeiculo();
    //TODO verificar qual o user que está a visualizar e qual a permissão que tem
        //if(idUserAtual contem tipo != 'CLIENTE')
        System.out.println("\nid -> marca, modelo, matricula, data de entrada, estado");
        for (Map.Entry<Integer, List<String>> entry : veiculos.entrySet())
                System.out.println(entry.getKey() +
                        " -> " + entry.getValue().get(0) +
                        ", " + entry.getValue().get(1) +
                        ", " + entry.getValue().get(2) +
                        ", " + entry.getValue().get(3) +
                        ", " + entry.getValue().get(4) +
                        ", " + entry.getValue().get(5));
        System.out.println();
        //else
        System.out.println("\nid -> marca, modelo, matricula, data de entrada");
        for (Map.Entry<Integer, List<String>> entry : veiculos.entrySet())
            if (entry.getValue().contains("DISPONIVEL")){
                System.out.println(entry.getKey() +
                        " -> " + entry.getValue().get(0) +
                        ", " + entry.getValue().get(1) +
                        ", " + entry.getValue().get(2) +
                        ", " + entry.getValue().get(3) +
                        ", " + entry.getValue().get(4));
            }
        System.out.println();
    }
}