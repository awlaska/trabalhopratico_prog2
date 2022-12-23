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
        System.out.println("0 - Sair || 1 - LogOut || 2 - Gerir Users || 3 - Gerir Registos");
        System.out.print(">> ");
        int op = input.nextInt();
        switch (op) {
            case 0:
                return;
        }
    }

    public void gerirUser(){
        Scanner input = new Scanner(System.in);
        System.out.print("0 - Sair || 1 - Retoceder || 2 - Alterar tipo de user || 3 - Apagar User \n>> ");
        int op = input.nextInt();
        switch (op){
            case 0:
                return;
            case 1:
                break;
            case 2:
                alterarTipoUser();
            case 3:
                apagarUser();
        }
    }
    public void alterarTipoUser(){
        listarUser();
        System.out.println("!!Alteração do tipo de user!!");
        System.out.print("ID do user a alterar: \n>> ");
        //Logic goes here
        System.out.print("\nTipo de user a atribuir (ADMIN, DONO, CLIENTE): \n>> ");
        //Logic goes here
    }
    public void apagarUser(){
        listarUser();
        System.out.println("!!Apagar user!!");
        System.out.print("ID do user a apagar: \n>> ");
        //Logic goes here
    }

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
