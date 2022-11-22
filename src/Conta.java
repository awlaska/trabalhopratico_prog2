import java.util.Map;
import java.util.Scanner;

public class Conta {
    //DOING 1. Um utilizador pode criar uma conta. Para aceder ao sistema, o utilizador deverá efetuar login.
    private Map<String , String> user;

    public void login(){
        Scanner usernamei = new Scanner(System.in);
        Scanner passwordi = new Scanner(System.in);
        System.out.println("Introduza o seu username: ");
        String u = usernamei.nextLine();
        System.out.println("Introduza a sua password: ");
        String p = passwordi.nextLine();
        user.put(u, p);
    }
    //TODO 2. O utilizador pode editar os dados da sua conta, nomeadamente o seu nome,
    // dados de autenticação e número habitual de horas de trabalho diário.
    private void editarConta(){
        Scanner usernamei = new Scanner(System.in);
        Scanner passwordi = new Scanner(System.in);
        System.out.println("Introduza o seu username: ");
        String u = usernamei.nextLine();
    }
}