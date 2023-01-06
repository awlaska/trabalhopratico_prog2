import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Cliente extends Utilizador {
    public Cliente() throws IOException {
        super();
    }

    //DOING melhorar menus -> criar mais submenus
    //DOING adicionar métodos que faltam
    //DOING adicionar métodos que faltam de guardar ao sair do programa
    public void menuC(int idUserAtual) throws IOException, UtilizadorException {
        Scanner input = new Scanner(System.in);

        System.out.println("Id do user atual: " + idUserAtual);
        System.out.print("1 - Listar veiculos\n2 - Listar compras\n3 - Listar reservas\n4 - Apagar Reserva\n5 - Alterar Data de Visita\n6 - Apagar Reserva\n7 - Ver/Editar perfil\n0 - Sair\n>> ");
        int op = input.nextInt();

        switch (op) {
            case 0 -> {writeMapUtilizador();veic.writeMapVeiculo();break;}
            case 1 -> veic.listarVeiculos(idUserAtual);
            case 2 -> {}//listarCompras(idUserAtual);
            case 3 -> {reserva.listarRes(idUserAtual); }
            case 4 -> {reserva.adicionarReserva(idUserAtual);}
            case 5 -> {reserva.alterarDataVisita(idUserAtual);}
            case 6 -> {reserva.apagarReserva(idUserAtual);}
            case 7 -> editarUser(idUserAtual);
            default -> throw new IllegalStateException("Unexpected value: " + op);
        }
    }
}
