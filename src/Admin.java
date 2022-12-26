import java.io.IOException;
import java.util.*;

public class Admin extends Utilizador implements IListar{
    public Admin() throws IOException {super();}
    LinkedHashMap<Integer, List<String>> users = Ficheiro.loadMap("utilizadores", 6);

    //TODO completar switch do menu
    //DONE Gerir Users:
    //DONE - Alterar tipo de user
    //TODO - Apagar user
    //DONE Gerir Registos:
    //DOING -Apagar Venda
    //DOING -Apagar Reserva

    //--> MENUS
    public void menuA() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.print("0 - Sair\n1 - Listagens\n2 - Alterar Tipo de User\n3 - Apagar User\n4 - Apagar Venda\n5 - Apagar Reserva\n>> ");
        int op = input.nextInt();
        switch (op) {
            case 0 -> {return;}
            case 1 -> {listagens();break;}
            //TODO perguntar ao user quais apagar ou alterar
            case 2 -> {alterarTipoUser();break;}
            case 3 -> {apagarUser();break;}
            //TODO meter para pedir qual venda e reserva a apagar
            case 4 -> {apagarVenda(1);break;}
            case 5 -> {apagarReserva();break;}
            default -> {break;}
        }
    }

    public void listagens() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.print("0 - Sair\n1 - Retroceder\n2 - Listar User\n3 - Listar Veiculos\n4 - Listar Compras\n5 - Listar Reservas\n>> ");
        int op = input.nextInt();
        switch (op) {
            case 0 -> {return;}
            case 1 -> {menuA();}
            case 2 -> {listarUser();}
            case 3 -> {listarVeiculos();}
            case 4 -> {listarCompras();}
            case 5 -> {listarReservas();}
            default -> {break;}
        }
    }

    //-->METODOS ALTERAÇÃO E REMOÇÃO DE DADOS
    public void alterarTipoUser() throws IOException {
        Scanner inputint = new Scanner(System.in);
        Scanner inputstring = new Scanner(System.in);
        System.out.println(users);

        System.out.println("\n!!Alteração do tipo de user!!");
        System.out.print("ID do user a alterar: \n>> ");
        int id = inputint.nextInt();
        System.out.print("Tipo de user a atribuir (ADMIN, DONO, CLIENTE): \n>> ");
        String tipo = inputstring.nextLine();


        if (tipo.equalsIgnoreCase("ADMIN") || tipo.equalsIgnoreCase("DONO") || tipo.equalsIgnoreCase("CLIENTE")) {
            users.get(id).set(4, tipo.toUpperCase());
        } else {
            System.out.println("Tipo inválido!");
        }

        Ficheiro.escreverFicheiro("utilizadores", users);
    }

    public void apagarUser() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println(users);
        System.out.println("!!Apagar user!!");
        System.out.print("ID do user a apagar: \n>> ");
        int id = input.nextInt();

        for (int i = 0; i < 5; i++)
            users.get(id).set(i, "null");

        Ficheiro.escreverFicheiro("utilizadores", users);
    }

    //TODO apagarVenda e apagarReserva
    private void apagarVenda(int nr) {
//        for (int i = 0; i < venda.length()) {
//
//        }
    }
    private void apagarReserva() {}

    //TODO listagens: O Admin consegue ver o mesmo que o Dono + contas de outros admins

    //--> METODOS LISTAGEM
    @Override
    public void listarCompras() throws IOException {
//        System.out.println(compras + "\n");
        menuA();
    }

    @Override
    public void listarUser() throws IOException {
        System.out.println(users + "\n");
        menuA();
    }

    @Override
    public void listarReservas() throws IOException {
//        System.out.println(reservas + "\n");
        menuA();
    }

    @Override
    public void listarVeiculos() throws IOException {
//        System.out.println(veiculos);
        menuA();
    }
}
