import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Cliente extends Utilizador {
    LinkedHashMap<Integer, List<String>> utilizadores = Ficheiro.loadMap("utilizadores", 6);
    LinkedHashMap<Integer, List<String>> veiculos = Ficheiro.loadMap("veiculos", 6);
    public Cliente() throws IOException {
        super();
    }

    //TODO completar switch do menu
    /*
    Apenas pode ver registos que lhe digam respeito (estão associados ao seu id)

    Listar Veiculos (Apenas os que tem estado DISPONIVEL):
    -Pode escolher um para reserva (diz o id do carro)

    Listar Compras (Os veiculos comprados tem id do user associado e estado igual a VENDIDO)

    Listar Reservas:
    -Alterar data da visita ao stand
    -Cancelar/Apagar reserva (Muda estado do veiculo de Reservado para Disponivel)

    Ver Perfil:
    -Lista a info do user que fez login

    Editar Perfil:
    -edita só
     */
    public void menuC(int idUserAtual) throws IOException, UtilizadorException {
        Scanner input = new Scanner(System.in);

        System.out.println("Id do user atual: " + idUserAtual);

<<<<<<< Updated upstream
        System.out.print("1 - Listar veiculos\n2 - Listar compras\n3 - Listar reservas\n4 - Apagar Reserva\n5 - Alterar Data de Visita\n6 - Ver/Editar perfil\n0 - Sair\n>> ");
=======
        System.out.print("0 - Sair\n1 - Listar veiculos\n2 - Listar compras\n3 - Listar reservas\n4 - Criar Reserva\n5 - Alterar Data de Visita\n6 - Ver/Editar perfil\n>> ");
>>>>>>> Stashed changes
        int op = input.nextInt();

        switch (op) {
            case 0 -> {Ficheiro.saveAll(utilizadores, veiculos);}
            case 1 -> listarVeiculos();
            case 2 -> listarCompras();
            case 3 -> listarReservas();
            case 4 -> {reserva.adicionarReserva(idUserAtual);}
            case 5 -> {/*alterarData();*/}
            case 6 -> editarUser(idUserAtual);
            default -> throw new IllegalStateException("Unexpected value: " + op);
        }
    }

    private void editarUser(int idUserAtual) throws UtilizadorException, IOException {
        Scanner input = new Scanner(System.in);
        Scanner inputOP = new Scanner(System.in);
        int op = -1;
        while (op != 0) {
            //DONE print dos valores que correspondem ao idUserAtual
            listarUsers(idUserAtual);
            System.out.println("\n!!Editar perfil!!\n");
            System.out.print("0 - Sair\n1 - Username\n2 - Password\n3 - Nome\n4 - Telefone\n>> ");
            op = inputOP.nextInt();
            switch (op) {
                case 0 -> {
                    Ficheiro.saveAll(utilizadores, veiculos);
                    menuC(idUserAtual);
                }
                case 1 -> {
                    System.out.print("Username: \n>> ");
                    String user = input.nextLine();
                    utilizadores.get(idUserAtual).set(0, user);
                }
                case 2 -> {
                    System.out.print("Password: \n>> ");
                    String pass = input.nextLine();
                    utilizadores.get(idUserAtual).set(1, pass);
                }
                case 3 -> {
                    System.out.print("Nome: \n>> ");
                    String nome = input.nextLine();
                    utilizadores.get(idUserAtual).set(2, nome);
                }
                case 4 -> {
                    System.out.print("Telefone: \n>> ");
                    String tele = input.nextLine();
                    utilizadores.get(idUserAtual).set(4, tele);
                }
                default -> throw new IllegalStateException("Unexpected value: " + op);
            }
        }
    }

    //TODO fazer metodos
    public void listarCompras() {
        System.out.println();
    }

    private void listarUsers(int idUserAtual) {
        System.out.println("\nid -> username, password, nome, telefone");
        for (Map.Entry<Integer, List<String>> entry : utilizadores.entrySet())
            if (entry.getKey().equals(idUserAtual))
                System.out.println(entry.getKey() +
                        " -> " + entry.getValue().get(0) +
                        ", " + entry.getValue().get(1) +
                        ", " + entry.getValue().get(2) +
                        ", " + entry.getValue().get(3));
        System.out.println();
    }

    public void listarReservas() {
        System.out.println();

    }

    public void listarVeiculos() {
        System.out.println("\nid -> marca, modelo, matricula, data de entrada");
        for (Map.Entry<Integer, List<String>> entry : veiculos.entrySet())
            if (entry.getValue().contains("DISPONIVEL")){
                System.out.println(entry.getKey() +
                        " -> " + entry.getValue().get(0) +
                        ", " + entry.getValue().get(1) +
                        ", " + entry.getValue().get(2) +
                        ", " + entry.getValue().get(3));
            }
        System.out.println();

    }
}
