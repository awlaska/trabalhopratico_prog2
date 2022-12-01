import java.util.Scanner;

public class UI {
    public int Escolha() {
        int valor = 0;
        Scanner escolha = new Scanner(System.in);

        System.out.print(">> ");
        valor = escolha.nextInt();

        return valor;
    }

    public void Inicial() {
        /*
        1-cliente
        2-Dono stand
        3-Admin
         */

        System.out.println("1 - Cliente | 2 - Dono stand | 3 - Admin | 0 - Sair");
        int idUser = Escolha();
        while (idUser < 3 && idUser > 0) {
            switch (idUser) {
                case 1:
                    System.out.println("Cliente");
                    break;
                case 2:
                    System.out.println("Dono stand");
                    break;
                case 3:
                    System.out.println("Admin");
                    break;
                case 0:
                    System.out.println("sair");
                default:
                    System.out.println("Sou feio!");
            }
        }
    }

    public void cliente() {

    }
}
