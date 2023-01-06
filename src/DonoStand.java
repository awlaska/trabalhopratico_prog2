import ENUM.estadoVeiculo;
import ENUM.tipoUser;
import java.io.IOException;
import java.util.*;

public class DonoStand extends Utilizador {
    public DonoStand() throws IOException {
        super();
    }

    //DOING melhorar menus -> criar mais submenus
    //DOING adicionar métodos que faltam
    //DOING adicionar métodos que faltam de guardar ao sair do programa
    protected void menuD(int idUser) throws IOException, UtilizadorException {
        Scanner input = new Scanner(System.in);

        System.out.print("1 - LogOut\n2 - Apagar cliente\n3 - Adicionar Veiculo\n4 - Alterar Estado Veiculo\n5 - Apagar Veiculo\n6 - Listagens\n0 - Sair\n>> ");
        int op = input.nextInt();System.out.println();

        switch (op) {
            case 0 -> {writeMapUtilizador();veic.writeMapVeiculo();break;}
            case 1 -> menuInicial();
            case 2 -> apagarUsers();
            case 3 -> veic.adicionarVeiculo();
            case 4 -> veic.alterarEstado();
            case 5 -> veic.apagarVeiculo();
            case 6 -> menuListagens();
            default -> throw new IllegalStateException("Unexpected value: " + op);
        }
    }

    //DOING adicionar métodos que faltam
    //DOING adicionar métodos que faltam de guardar ao sair do programa
    protected void menuListagens() throws IOException, UtilizadorException {
        Scanner input = new Scanner(System.in);

        System.out.println("1 - Listar Clientes\n2 - Listar Vendas\n3 - Listar Reservas\n4 - Listar Veiculos\n0 - Sair\n>> ");
        int op = input.nextInt();System.out.println();

        switch (op) {
            case 0 -> {writeMapUtilizador();veic.writeMapVeiculo();break;}
            case 1 -> listarUsers(id);
            case 2 -> {break;}//listarCompras();
            case 3 -> reserva.listarRes(id);
            case 4 -> veic.listarVeiculos(id);
            default -> throw new IllegalStateException("Unexpected value: " + op);
        }
    }
}
