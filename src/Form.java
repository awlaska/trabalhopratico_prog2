import java.util.*;

public class Form extends Utilizador{
    private String username;
    private String password;

    Scanner input = new Scanner(System.in);

    public Form(){
        super();
    }

    public void login(){
        System.out.print("Username: ");
        username = input.nextLine();
        System.out.print("Password: ");
        password = input.nextLine();
    }

    public boolean verificarSeExiste(String username, String password) throws SignUpException {
        boolean existe = false;

        for (int i = 0; i < super.getNrUtilizadores(); i++) {
            if(super.getUsername().equals(username) && super.getPassword().equals(password)){
                existe = true;
            }
        }
        return existe;
    }

    //TODO ver se o user existe e entrar como eles (ver quais metodos se aplicam)
    public void signup(){
        System.out.print("Username: ");
        username = input.nextLine();
        System.out.print("Password: ");
        password = input.nextLine();
        System.out.println("Nome: ");
        nome = input.nextLine();
        System.out.print("Morada: ");
        morada = input.nextLine();
    }

//    public void loadToMap(String username, String password) throws SignUpException {
//        if(verificarSeExiste(username, password))
//            throw new SignUpException("O user já existe!");
//        else{
//            super.dados.put(username, password);
//        }
//    }

    //TODO nr min de letras para user e passe
}
