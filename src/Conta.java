import java.util.Map;
import java.util.Scanner;

public class Conta {
    //TODO 1. Um utilizador pode criar uma conta. Para aceder ao sistema, o utilizador deverá efetuar login.
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
}