import java.io.IOException;
import java.util.Scanner;

public class DonoStand extends Utilizador implements IMenu {
    public DonoStand() throws IOException {
        super();
    }

    //DONE melhorar menus -> criar mais submenus
    //DONE adicionar métodos que faltam
    //DONE adicionar métodos que faltam de guardar ao sair do programa
    protected void menuD(int idUser) throws IOException, UtilizadorException {
        Scanner input = new Scanner(System.in);

        System.out.println(">>Menu Dono Stand<<");
        System.out.print("0 - Sair\n1 - LogOut\n2 - Utilizadores\n3 - Veiculos\n4 - Reservas\n5 - Vendas\n>> ");
        int op = input.nextInt();
        System.out.println();

        switch (op) {
            case 0 -> {
                break;
            }
            case 1 -> {
                menuInicial();
            }
            case 2 -> {
                menuUtilizadores(idUser);
            }
            case 3 -> {
                menuVeiculos(idUser);
            }
            case 4 -> {
                menuReservas(idUser);
            }
            case 5 -> {
                menuVendas(idUser);
            }
            default -> throw new IllegalStateException("Unexpected value: " + op);
        }
    }

    public void menuUtilizadores(int idUser) throws IOException, UtilizadorException {
        Scanner input = new Scanner(System.in);

        System.out.println(">>Menu Utilizadores<<");
        System.out.print("0 - Sair\n1 - Menu Anterior\n2 - Apagar Utilizador\n3 - Alterar Tipo de Utilizador\n4 - Listar Utilizadores\n>> ");
        int op = input.nextInt();
        System.out.println();

        switch (op) {
            case 0 -> {
                break;
            }
            case 1 -> {
                menuD(idUser);
            }
            case 2 -> {
                apagarUsers(idUser);
            }
            case 3 -> {
                alterarTipoUser(idUser);
            }
            case 4 -> {
                listarUsers(idUser);
                System.out.println("\n\n");
                menuUtilizadores(idUser);
            }
            default -> throw new IllegalStateException("Unexpected value: " + op);
        }
    }

    public void menuVeiculos(int idUser) throws IOException, UtilizadorException {
        Scanner input = new Scanner(System.in);

        System.out.println(">>Menu Veiculos<<");
        System.out.print("0 - Sair\n1 - Menu Anterior\n2 - Adicionar Veiculo\n3 - Alterar Estado Veiculo\n4 - Listar Veiculos\n>> ");
        int op = input.nextInt();
        System.out.println();

        switch (op) {
            case 0 -> {
                break;
            }
            case 1 -> {
                menuD(idUser);
            }
            case 2 -> {
                veic.adicionarVeiculo(idUser);
            }
            case 3 -> {
                veic.alterarEstado(idUser);
            }
            case 4 -> {
                veic.listarVeiculos(idUser);
                System.out.println("\n\n");
                menuVeiculos(idUser);
            }
            default -> throw new IllegalStateException("Unexpected value: " + op);
        }
    }

    public void menuReservas(int idUser) throws IOException, UtilizadorException {
        Scanner input = new Scanner(System.in);

        System.out.println(">>Menu Reservas<<");
        System.out.print("0 - Sair\n1 - Menu Anterior\n2 - Alterar Data Visita\n3 - Listar Reservas\n>> ");
        int op = input.nextInt();
        System.out.println();

        switch (op) {
            case 0 -> {
                break;
            }
            case 1 -> {
                menuD(idUser);
            }
            case 2 -> {
                reserva.alterarDataVisita(idUser);
            }
            case 4 -> {
                reserva.apagarReserva(idUser);
            }
            case 5 -> {
                reserva.listarRes(idUser);
                System.out.println("\n\n");
                menuReservas(idUser);
            }
            default -> throw new IllegalStateException("Unexpected value: " + op);
        }
    }

    public void menuVendas(int idUser) throws IOException, UtilizadorException {
        Scanner input = new Scanner(System.in);

        System.out.println(">>Menu Vendas<<");
        System.out.print("0 - Sair\n1 - Menu Anterior\n2 - Adicionar Venda\n3 - Apagar Venda\n4 - Listar Vendas\n>> ");
        int op = input.nextInt();
        System.out.println();

        switch (op) {
            case 0 -> {
                break;
            }
            case 1 -> {
                menuD(idUser);
            }
            case 2 -> {
                venda.adicionarVenda(idUser);
            }
            case 3 -> {
                venda.apagarVenda();
            }
            case 4 -> {
                venda.listarVenda(idUser);
                System.out.println("\n\n");
                menuVendas(idUser);
            }
            default -> throw new IllegalStateException("Unexpected value: " + op);
        }
    }
}
