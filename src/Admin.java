import java.io.IOException;
import java.util.Scanner;

public class Admin extends Utilizador implements IMenu {

    public Admin() throws IOException {
        super();
    }

    //DONE melhorar menus -> criar mais submenus
    //DONE adicionar métodos que faltam
    //DONE adicionar métodos que faltam de guardar ao sair do programa
    public void menuA(int idUser) throws IOException, UtilizadorException {
        Scanner input = new Scanner(System.in);

        System.out.println(">>Menu Administrador<<");
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
        System.out.print("0 - Sair\n1 - Menu Anterior\n2 - Apagar Utilizador\n3 - Alterar Tipo Utilizador\n4 - Listar Utilizadores\n>> ");
        int op = input.nextInt();
        System.out.println();

        switch (op) {
            case 0 -> {
                break;
            }
            case 1 -> {
                menuA(idUser);
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
        System.out.print("0 - Sair\n1 - Menu Anterior\n2 - Alterar Estado Veiculo\n3 - Listar Veiculos\n>> ");
        int op = input.nextInt();
        System.out.println();

        switch (op) {
            case 0 -> {
                break;
            }
            case 1 -> {
                menuA(idUser);
            }
            case 2 -> {
                veic.alterarEstado(idUser);
            }
            case 3 -> {
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
        System.out.print("0 - Sair\n1 - Menu Anterior\n2 - Alterar Data Visita\n3 - Cancelar Reserva\n4 - Listar Reservas\n>> ");
        int op = input.nextInt();
        System.out.println();

        switch (op) {
            case 0 -> {
                break;
            }
            case 1 -> {
                menuA(idUser);
            }
            case 2 -> {
                reserva.alterarDataVisita(idUser);
            }
            case 3 -> {
                reserva.cancelarReserva(idUser);
            }
            case 4 -> {
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
        System.out.print("0 - Sair\n1 - Menu Anterior\n2 - Listar Vendas\n>> ");
        int op = input.nextInt();
        System.out.println();

        switch (op) {
            case 0 -> {
                break;
            }
            case 1 -> {
                menuA(idUser);
            }
            case 2 -> {
                venda.listarVenda(idUser);
                System.out.println("\n\n");
                menuVendas(idUser);
            }
            default -> throw new IllegalStateException("Unexpected value: " + op);
        }
    }
}
