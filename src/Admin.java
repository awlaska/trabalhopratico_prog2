import java.util.Scanner;

public class Admin extends Utilizador implements IListar{
    public Admin(){super();}
    public void menu(){
        Scanner input = new Scanner(System.in);
        System.out.print("0 - Sair || 1 - LogOut || 2 - Gerir Users || 3 - Gerir Registos");
        int op = input.nextInt();
        switch (op) {
            case 0:
                listarCompras();
        }
    }

    //Alterar Tipo User TODO
    public boolean alterarTipoUser(){


        return false;
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
