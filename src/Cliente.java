import java.io.IOException;
import java.util.Scanner;

public class Cliente extends Utilizador implements IMenu {
    public Cliente() throws IOException {
        super();
    }

    //DONE melhorar menus -> criar mais submenus
    //DONE adicionar métodos que faltam
    public void menuC(int idUser) throws IOException, UtilizadorException {
        Scanner input = new Scanner(System.in);

        System.out.println(">>Menu Cliente<<");
        System.out.print("0 - Sair\n1 - LogOut\n2 - Utilizadores\n3 - Veiculos\n4 - Reservas\n5 - Vendas\n>> ");
        int op = input.nextInt();

        switch (op) {
            case 0 -> {
                break;
            }
            case 1 -> {
                menuInicial();
            }
            case 2 -> menuUtilizadores(idUser);
            case 3 -> menuVeiculos(idUser);
            case 4 -> menuReservas(idUser);
            case 5 -> menuVendas(idUser);
            default -> throw new IllegalStateException("Unexpected value: " + op);
        }
    }

    public void menuUtilizadores(int idUser) throws IOException, UtilizadorException {
        Scanner input = new Scanner(System.in);

        System.out.println(">>Menu Utilizador<<");
        System.out.print("0 - Sair\n1 - Menu Anterior\n2 - Editar Informação\n3 - Listar Informação\n>> ");
        int op = input.nextInt();
        System.out.println();

        switch (op) {
            case 0 -> {
            }
            case 1 -> {
                menuInicial();
            }
            case 2 -> {
                editarUser(idUser);
            }
            case 3 -> {
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
        System.out.print("0 - Sair\n1 - Menu Anterior\n2 - Listar Veiculos\n>> ");
        int op = input.nextInt();
        System.out.println();

        switch (op) {
            case 0 -> {
                break;
            }
            case 1 -> {
                menuC(idUser);
            }
            case 2 -> {
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
        System.out.print("0 - Sair\n1 - Menu Anterior\n2 - Criar Reserva\n3 - Alterar Data Visita\n4 - Cancelar Reserva\n5 - Listar Reservas\n>> ");
        int op = input.nextInt();
        System.out.println();

        switch (op) {
            case 0 -> {
                break;
            }
            case 1 -> {
                menuC(idUser);
            }
            case 2 -> {
                reserva.adicionarReserva(idUser);
            }
            case 3 -> {
                reserva.alterarDataVisita(idUser);
            }
            case 4 -> {
                reserva.cancelarReserva(idUser);
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
        System.out.print("0 - Sair\n1 - Menu Anterior\n2 - Listar Compras\n>> ");
        int op = input.nextInt();
        System.out.println();

        switch (op) {
            case 0 -> {
                break;
            }
            case 1 -> {
                menuC(idUser);
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
