import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class DonoStand extends Utilizador implements IListar{

    //TODO completar switch do menu
        /*
        Gerir Users:
        -Apagar user (apenas clientes)

        Gerir Registos:
        -chamar metodo de adicionar veiculo (Veiculo)
        -Apagar Venda
        -Apagar Reserva
        -Alterar estado de um veiculo
        -Alterar dados de um veiculo
        -Alterar data de visita
        -Apagar veiculo
         */
    public void menu(){
        Scanner input = new Scanner(System.in);
        System.out.print("0 - Sair || 1 - LogOut || 2 - Gerir Users || 3 - Gerir Registos");
        int op = input.nextInt();
        switch (op) {
            case 0:
                listarCompras();
        }
    }
    //TODO listagens:
        /*
        Consegue ver tudo menos as contas de de admins
        Listagem de reservas por ordem de ddata de visita, data mais proxima para menos
         */
    @Override
    public void listarCompras() {

    }
    @Override
    public void listarUser(LinkedHashMap<Integer, List<String>> map) {

    }
    @Override
    public void listarReservas() {

    }
    @Override
    public void listarVeiculos() {

    }
}
