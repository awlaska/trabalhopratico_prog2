import ENUM.tipoUser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Utilizador { //DONE :D
    protected String username;
    protected String password;
    protected String nome;
    protected String nrTelemovel;
    protected int id;
    protected tipoUser tipo;

    public Utilizador() throws IOException {}

    public Utilizador(String user, String pass, String nome, String nrTelemovel, int id, tipoUser tipo) throws IOException {
        this.username = user;
        this.password = pass;
        this.nome = nome;
        this.nrTelemovel = nrTelemovel;
        this.tipo = null;
        this.id = id;
    }

    public void menuIncial() throws IOException, UtilizadorException {
        LinkedHashMap<Integer, List<String>> utilizadores = Ficheiro.loadMap("utilizadores", 6);
        LinkedHashMap<Integer, List<String>> veiculos = Ficheiro.loadMap("veiculos", 6);
        Scanner input = new Scanner(System.in);

        System.out.print("1 - Login\n2 - Signup\n0 - Sair\n>> ");
        int op = input.nextInt();

        System.out.println();

        //TODO adicionar escrita dos ficheiros em falta (veiculos, reservas, vendas)
        switch (op) {
            case 0 -> {Ficheiro.saveAll(utilizadores, veiculos);break;}
            case 1 -> login(utilizadores);
            case 2 -> signUp(utilizadores);
            default -> throw new IllegalStateException("Unexpected value: " + op);
        }
    }

    protected void login(LinkedHashMap<Integer, List<String>> map) throws UtilizadorException, IOException {
        Scanner logIn = new Scanner(System.in);
        String uname = "", pword = "";

        while (!map.containsValue(uname) && !map.containsValue(pword)) {
            System.out.print("Username\n>> ");
            uname = logIn.nextLine();
            System.out.print("Password\n>> ");
            pword = logIn.nextLine();

            for (int i = 0; i < map.size(); i++) {
                if (map.get(i).get(0).equals(uname)) {
                    id = i;
                }
            }

            if (map.get(id).get(0).equals(uname) && map.get(id).get(1).equals(pword)) {
                System.out.println("User autenticado!");
                System.out.println();
            } else {
                throw new UtilizadorException("User não existente!");
            }

            if (!map.get(id).get(4).equals("NULL")) {
                if (map.get(id).get(4).equals("ADMIN")) {
                    Admin admin = new Admin();
                    admin.menuA();
                    break;
                }
                if (map.get(id).get(4).equals("DONO")) {
                    DonoStand dono = new DonoStand();
                    dono.menuD();
                    break;
                }
                if (map.get(id).get(4).equals("CLIENTE")) {
                    Cliente cliente = new Cliente();
                    cliente.menuC(id);
                    break;
                }
            } else {
                throw new UtilizadorException("!!Aguarde ativação do administrador!!");
            }
        }
    }

    //TODO verificar se existe no map
    protected void signUp(LinkedHashMap<Integer, List<String>> map) throws UtilizadorException, IOException {
        List dados = new ArrayList();

        while (!map.get(0).get(0).equals(username)) {
            Scanner signup = new Scanner(System.in);
            System.out.print("Username\n>> ");
            this.username = signup.nextLine();
            System.out.print("Password\n>> ");
            this.password = signup.nextLine();
            System.out.print("Nome\n>> ");
            this.nome = signup.nextLine();
            System.out.print("Número de telemovel\n>> ");
            this.nrTelemovel = signup.nextLine();
            this.tipo = tipoUser.NULL;

            for (int i = 0; i <= map.size(); i++) {
                if (!map.containsKey(i)) {
                    id = i;
                }
            }

            dados.add(0, username);
            dados.add(1, password);
            dados.add(2, nome);
            dados.add(3, nrTelemovel);
            dados.add(4, tipo.toString());

            if (map.get(0).get(0).equals(username)) {
                throw new UtilizadorException("!!User já existente!!");
            } else {
                map.put(id, dados);
                Ficheiro.escreverFicheiro("utilizadores", map);
                System.out.println("\n\n");
                menuIncial();
            }
        }
    }
}