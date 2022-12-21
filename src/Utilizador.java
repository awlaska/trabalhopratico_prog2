import ENUM.tipoUser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Utilizador { //DONE :D
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

    public void login(LinkedHashMap<Integer, List<String>> map) throws UtilizadorException, IOException {
        Scanner logIn = new Scanner(System.in);
        String uname = "", pword = "";

        while(!map.containsValue(uname) && !map.containsValue(pword)) {
            System.out.print(">> Username: ");
            uname = logIn.nextLine();
            System.out.print(">> Password: ");
            pword = logIn.nextLine();
            System.out.println("done");

            for (int i = 0; i < map.size(); i++) {
                if(map.get(i).get(0).equals(uname)){
                    id = i;
                }
            }

            // mapa -> get indice 0 (1a lista) -> get nome (1o da lista)
            if(map.get(id).get(0).equals(uname) ) {
                System.out.println("User existe");
            } else {
                throw new UtilizadorException("User não existente!");
            }

            if (map.get(id).get(4).equals("NULL")) {
                throw new UtilizadorException("Aguarde ativação do administrador!");
            }
            if (map.get(id).get(4).equals("ADMIN")) {
                Admin admin = new Admin();
                admin.menu();
            }
            if (map.get(id).get(4).equals("DONO")) {
                DonoStand dono = new DonoStand();
                dono.menu();
            }
            if (map.get(id).get(4).equals("CLIENTE")) {
                Cliente cliente = new Cliente();
                cliente.menu();
            }
        }
    }

    public void signUp(LinkedHashMap<Integer, List<String>> map) throws UtilizadorException, IOException {
        Scanner signup = new Scanner(System.in);
        System.out.print(">> Username: ");
        String username = signup.nextLine();
        System.out.print(">> Password: ");
        String password = signup.nextLine();
        System.out.print(">> Nome: ");
        String nome = signup.nextLine();
        System.out.print(">> Número de telemovel: ");
        String nrTelemovel = signup.nextLine();
        tipoUser tipo = tipoUser.NULL;

        for(int i = 1; i <= map.size(); i++){
            if(!map.containsKey(i)){
                id = i;
            }
        }

        list.add(username);
        list.add(password);
        list.add(nome);
        list.add(nrTelemovel);
        list.add(tipo.toString());
        System.out.println(list);

        if(map.containsValue(list))
            throw new UtilizadorException("User já existente!");
        else{
            map.put(id, list);
            System.out.println("Sucesso a inserir!");
            Ficheiro.escreverFicheiro("utilizadores", map);
            }
    }
}