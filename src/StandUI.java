import java.io.IOException;
import java.util.*;


public class StandUI { //DONE :D
    public static void main(String[] args) throws UtilizadorException, IOException {
        Utilizador user = new Utilizador();
        LinkedHashMap<Integer, List<String>> utilizadores = Ficheiro.loadMap("utilizadores", 6);

//        Veiculo veiculo = new Veiculo();
//        veiculos = Ficheiro.loadMap("veiculos", x);

        Scanner input = new Scanner(System.in);

        System.out.println("1 - Login\n2 - Signup\n0 - Sair");
        System.out.print(">> ");
        int op = input.nextInt();

        //TODO adicionar escrita dos ficheiros em falta (veiculos, reservas, vendas)
        switch (op) {
            case 0 -> {Ficheiro.escreverFicheiro("utilizadores", utilizadores);return;}
            case 1 -> user.login(utilizadores);
            case 2 -> user.signUp(utilizadores);
            default -> {break;}
        }
    }
}
