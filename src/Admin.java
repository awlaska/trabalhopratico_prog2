import java.io.IOException;
import java.util.*;

public class Admin extends Utilizador implements IListar{
    public Admin() throws IOException {super();}
    LinkedHashMap<Integer, List<String>> users = Ficheiro.loadMap("utilizadores", 6);

//  TODO completar switch do menu
//        Gerir Users:
//        - Alterar tipo de user
//        - Apagar user
//        Gerir Registos:
//        -Apagar Venda
//        -Apagar Reserva

    //--> MENUS
    public void menuA(){
        Scanner input = new Scanner(System.in);
        System.out.print("0 - Sair\n1 - Listagens\n2 - Alterar tipo de user\n3 - Apagar user\n4- algo registos...\n>> ");
        int op = input.nextInt();
        switch (op) {
            case 0 -> {return;}
            case 1 -> {listagens();break;}
            case 2 -> {alterarTipoUser();break;}
            case 3 -> {apagarUser();break;}
            default -> {break;}
        }
    }

    public void listagens(){
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
    public void alterarTipoUser(){
        listarUser();
        System.out.println("!!Alteração do tipo de user!!");
        System.out.print("ID do user a alterar: \n>> ");
        //Logic goes here
        System.out.print("\nTipo de user a atribuir (ADMIN, DONO, CLIENTE): \n>> ");
        //Logic goes here
    }
    public void apagarUser(){
        listarUser();
        System.out.println("!!Apagar user!!");
        System.out.print("ID do user a apagar: \n>> ");
        //Logic goes here
    }

    //TODO listagens: O Admin consegue ver o mesmo que o Dono + contas de outros admins

    //--> METODOS LISTAGEM
    @Override
    public void listarCompras() {
//        System.out.println(compras + "\n");
        menuA();
    }

    @Override
    public void listarUser() {
        System.out.println(users + "\n");
        menuA();
    }

    @Override
    public void listarReservas() {
//        System.out.println(reservas + "\n");
        menuA();
    }

    @Override
    public void listarVeiculos() {
//        System.out.println(veiculos);
        menuA();
    }
}
