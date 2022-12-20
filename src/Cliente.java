import java.util.Scanner;

public class Cliente extends Utilizador implements IListar{
    public void menu(){
        Scanner input = new Scanner(System.in);
        System.out.print("0 - Sair || 1 - Listar veiculos || 2 - Listar compras || 3 - Listar reservas || 4 - Ver Perfil");
        int op = input.nextInt();
        switch (op) {
            case 0:
                return;
            case 1:
                listarVeiculos();
            case 2:
                listarCompras();
            case 3:
                listarReservas();
            case 4:
                listarUser();
        }
    }

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
