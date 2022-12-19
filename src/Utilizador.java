import ENUM.tipoUser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Utilizador {
    public Map<Integer, List<String>> user;
    public List<String> info;
    protected String username;
    protected String password;
    protected String nome;
    protected String nrTelemovel;
    protected int id;
    protected tipoUser tipo;
    protected List<String> list = new ArrayList<>();
    protected LinkedHashMap<Integer, List<String>> map = new LinkedHashMap<Integer, List<String>>();

    public Utilizador(){}

    public Utilizador(String user, String pass, String nome, String nrTelemovel, int id, tipoUser tipo){
        this.username = user;
        this.password = pass;
        this.nome = nome;
        this.nrTelemovel = nrTelemovel;
        this.tipo = null;
        this.id = id;
        List<String> list = new ArrayList<>();
        LinkedHashMap<Integer, List<String>> map = new LinkedHashMap<Integer, List<String>>();
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

    public void login() throws UtilizadorException, IOException {
        Scanner logIn = new Scanner(System.in);

//        while(!map.containsValue(uname) && !map.containsValue(pword)) {
            System.out.print(">> Username: ");
            String uname = logIn.nextLine();
            System.out.print(">> Password: ");
            String pword = logIn.nextLine();
            System.out.println("done");

            // mapa -> get indice 0 (1a lista) -> get nome (1o da lista)
            if(map.get(0).get(0).equals(uname)) {
                System.out.println("sucesso");
            }
//                if(map.get(tipo).equals("NULL")) {
//                    throw new UtilizadorException("Aguarde ativação do administrador!");
//                }
//                if(map.get(tipo).equals("ADMIN")) {
//                    Admin admin = new Admin();
//                    admin.menu();
//                }
//                if(map.get(tipo).equals("DONO")) {
//                    DonoStand dono = new DonoStand();
//                    dono.menu();
//                }
//                if(map.get(tipo).equals("CLIENTE")) {
//                    Cliente cliente = new Cliente();
//                    cliente.menu();
//                }
//        }
    }

    public void signUp() throws UtilizadorException, IOException {
        Scanner signUp = new Scanner(System.in);
        System.out.print(">> Username: ");
        String username = signUp.nextLine();
        System.out.print(">> Password: ");
        String password = signUp.nextLine();
        System.out.print(">> Nome: ");
        String nome = signUp.nextLine();
        System.out.print(">> Número de telemovel: ");
        String nrTelemovel = signUp.nextLine();
        tipoUser tipo = tipoUser.NULL;

        for(int i = 1; i <= map.size(); i++){
            if(!map.containsKey(i)){
                id = i;
            }
        }

        if(map.containsValue(list))
            throw new UtilizadorException("User já existente!");
        else
            list.add(username);
            list.add(password);
            list.add(nome);
            list.add(nrTelemovel);
            list.add(tipo.toString());
            this.map.put(id, list);
            System.out.println("Sucesso a inserir!");
            apresentaDados();
            Ficheiro.escreverFicheiro("utilizadores", map);
    }

    public void apresentaDados(){
        for(Map.Entry<Integer, List<String>> info: map.entrySet()) {
            System.out.println(info.getValue()+ ", ");
        }
    }
}