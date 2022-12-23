import ENUM.tipoUser;
import java.io.*;
import java.util.*;

public class Utilizador { //DONE :D
    protected String username;
    protected String password;
    protected String nome;
    protected String nrTelemovel;
    protected int id;
    protected tipoUser tipo;
    protected List<String> dados;

    public Utilizador(){}
    public Utilizador(String user, String pass, String nome, String nrTelemovel, int id, tipoUser tipo){
        this.username = user;
        this.password = pass;
        this.nome = nome;
        this.nrTelemovel = nrTelemovel;
        this.tipo = null;
        this.id = id;
        dados = new ArrayList<>();
    }

    public int getNrUtilizadores(){
        return this.id;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getNrTelemovel() {
        return nrTelemovel;
    }
    public void setNrTelemovel(String nrTelemovel) {
        this.nrTelemovel = nrTelemovel;
    }

    //-->MENU INICIAL
    public void menuIncial() throws IOException, UtilizadorException {
        LinkedHashMap<Integer, List<String>> utilizadores = Ficheiro.loadMap("utilizadores", 6);
        Scanner input = new Scanner(System.in);

        System.out.println("1 - Login\n2 - Signup\n0 - Sair");
        System.out.print(">> ");
        int op = input.nextInt();

        //TODO adicionar escrita dos ficheiros em falta (veiculos, reservas, vendas)
            switch (op) {
            case 0 -> {Ficheiro.escreverFicheiro("utilizadores", utilizadores);return;}
            case 1 -> login(utilizadores);
            case 2 -> signUp(utilizadores);
            default -> {break;}
        }
    }

    //--> Métodos de verificaçção e criação de utilizadores
    protected void login(LinkedHashMap<Integer, List<String>> map) throws UtilizadorException, IOException {
        Scanner logIn = new Scanner(System.in);
        String uname = "", pword = "";

        while(!map.containsValue(uname) && !map.containsValue(pword)) {
            System.out.print("Username\n>> ");
            uname = logIn.nextLine();
            System.out.print("Password\n>> ");
            pword = logIn.nextLine();

            for (int i = 0; i < map.size(); i++) {
                if(map.get(i).get(0).equals(uname)){
                    id = i;
                }
            }

            // mapa -> get indice 0 (1a lista) -> get nome (1o da lista)
            if(map.get(id).get(0).equals(uname) && map.get(id).get(1).equals(pword)) {
                System.out.println("User autenticado!");
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
                    dono.menu();
                    break;
                }
                if (map.get(id).get(4).equals("CLIENTE")) {
                    Cliente cliente = new Cliente();
                    cliente.menu(id);
                    break;
                }
            } else {
                throw new UtilizadorException("!!Aguarde ativação do administrador!!");
            }
        }
    }
    protected void signUp(LinkedHashMap<Integer, List<String>> map) throws UtilizadorException, IOException {
        Scanner signup = new Scanner(System.in);
        System.out.print("Username\n>> ");
        String username = signup.nextLine();
        System.out.print("Password\n>> ");
        String password = signup.nextLine();
        System.out.print("Nome\n>> ");
        String nome = signup.nextLine();
        System.out.print("Número de telemovel\n>> ");
        String nrTelemovel = signup.nextLine();
        tipoUser tipo = tipoUser.NULL;

        for(int i = 1; i <= map.size(); i++){
            if(!map.containsKey(i)){
                id = i;
            }
        }

        dados.add(username);
        dados.add(password);
        dados.add(nome);
        dados.add(nrTelemovel);
        dados.add(tipo.toString());
        System.out.println(dados);

        if(map.containsValue(dados)) {
            throw new UtilizadorException("!!User já existente!!");
        }else{
            map.put(id, dados);
            System.out.println("!!Sucesso a inserir!!");
            Ficheiro.escreverFicheiro("utilizadores", map);
            }
    }
}