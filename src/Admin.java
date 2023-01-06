import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Admin extends Utilizador{

    public Admin() throws IOException {
        super();
    }

    //DOING melhorar menus -> criar mais submenus
    //DOING adicionar métodos que faltam
    //DOING adicionar métodos que faltam de guardar ao sair do programa
    protected void menuA(int idUser) throws IOException, UtilizadorException {
        loadMapUtilizador();
        Scanner input = new Scanner(System.in);

        System.out.print("1 - LogOut\n2 - Listagens\n3 - Alterar Tipo de User\n4 - Apagar User\n5 - Apagar Veiculo\n6 - Apagar Venda\n7 - Apagar Reserva\n0 - Sair\n>> ");
        int op = input.nextInt();System.out.println();

        switch (op) {
            case 0 -> {writeMapUtilizador();veic.writeMapVeiculo();break;}
            case 1 -> {menuInicial();}
            case 2 -> {listagens(idUser);break;}
            case 3 -> {alterarTipoUser();break;}
            case 4 -> {apagarUsers();break;}
            case 5 -> {veic.apagarVeiculo();break;}
            case 6 -> {break;}//venda.apagarVenda();
            case 7 -> {break;}//res.apagarReserva();
            default -> throw new IllegalStateException("Unexpected value: " + op);
        }
    }

    //DOING adicionar métodos que faltam
    //DOING adicionar métodos que faltam de guardar ao sair do programa
    private void listagens(int idUser) throws IOException, UtilizadorException {
        Scanner input = new Scanner(System.in);

        System.out.print("2 - Listar User\n3 - Listar Veiculos\n4 - Listar Compras\n5 - Listar Reservas\n0 - Sair\n1 - Retroceder\n>> ");
        int op = input.nextInt();System.out.println();

        switch (op) {
            case 0 -> {writeMapUtilizador();break;}
            case 1 -> {menuA(idUser);}
            case 2 -> {listarUsers(idUser);}
            case 3 -> {veic.listarVeiculos(idUser);}
            case 4 -> {}//venda.listarCompras(idUser);
            case 5 -> {reserva.listarRes(idUser);}
            default -> throw new IllegalStateException("Unexpected value: " + op);
        }
    }
}
