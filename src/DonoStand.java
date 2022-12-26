import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DonoStand extends Utilizador implements IListar{
    public DonoStand() throws IOException {super();}
    LinkedHashMap<Integer, List<String>> utilizadores = Ficheiro.loadMap("utilizadores", 6);
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
    protected void menuD() throws IOException, UtilizadorException {
        Scanner input = new Scanner(System.in);

        System.out.print("0 - Sair\n1 - LogOut\n2 - Apagar cliente\n3 - Gerir Registos\n>> ");
        int op = input.nextInt();

        System.out.println();

        switch (op) {
            case 0 -> {Ficheiro.escreverFicheiro("utilizadores", utilizadores);break;}
            case 1 -> menuIncial();
            case 2 -> apagarCliente();
            case 3 -> gerirRegistos();
            default -> throw new IllegalStateException("Unexpected value: " + op);
        }
    }

    //TODO menu de gestao de registos
    private void gerirRegistos() throws IOException {
        Scanner input = new Scanner(System.in);

        System.out.print("0 - Sair\n1 - LogOut\n2 - Apagar cliente\n3 - Gerir Registos\n>> ");
        int op = input.nextInt();

        System.out.println();

        switch (op) {
            case 0 -> {Ficheiro.escreverFicheiro("utilizadores", utilizadores);break;}
            default -> throw new IllegalStateException("Unexpected value: " + op);
        }
    }

    private void apagarCliente() throws IOException, UtilizadorException {
        Scanner input = new Scanner(System.in);

        for (Map.Entry<Integer,List<String>> entry : utilizadores.entrySet()){
            if (entry.getValue().contains("CLIENTE")){
                System.out.println("ID: " + entry.getKey() + "->" + entry.getValue());
            }
        }

        System.out.println("\n!!Apagar cliente!!");
        System.out.print("ID do cliente a apagar: \n>> ");
        int id = input.nextInt();

        if(utilizadores.get(id).get(4).equals("CLIENTE")) {
            for (int i = 0; i < 5; i++)
                utilizadores.get(id).set(i, "null");
        } else {
            throw new UtilizadorException("Não tem permissões para apgar este utilizador!");
        }

        Ficheiro.escreverFicheiro("utilizadores", utilizadores);
        menuD();
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
    public void listarUser() {

    }
    @Override
    public void listarReservas() {

    }
    @Override
    public void listarVeiculos() {

    }
}
