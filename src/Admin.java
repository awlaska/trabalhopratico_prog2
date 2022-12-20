import java.util.Scanner;

public class Admin extends Utilizador implements IListar{
    public Admin(){super();}

    //TODO completar switch do menu
        /*
        Gerir Users:
        - Alterar tipo de user
        - Apagar user

        Gerir Registos:
        -Apagar Venda
        -Apagar Reserva
         */
    public void menu(){
        Scanner input = new Scanner(System.in);
        System.out.print("0 - Sair || 1 - LogOut || 2 - Gerir Users || 3 - Gerir Registos");
        int op = input.nextInt();
        switch (op) {
            case 0:
                return;
        }
    }

    public void alterarTipoUser(){

    }
    public void apagarUser(){}

    //TODO listagens:
        /*
        O Admin consegue ver o mesmo que o Dono + contas de outros admins
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
