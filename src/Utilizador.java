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

    public void login() throws UtilizadorException{
        Scanner logIn = new Scanner(System.in);
        String uname = "", pword = "";

        while(!(map.get(username).equals(uname)) && !(map.get(password).equals(pword))) {
            System.out.print(">> Username: ");
            uname = logIn.nextLine();
            System.out.print(">> Password: ");
            pword = logIn.nextLine();
        }
            if(user.get(username).equals(uname) && user.get(password).equals(pword)){
                if(user.get(tipo).equals("null")) {
                    throw new UtilizadorException("Aguarde ativação do administrador!");
                }
                if(user.get(tipo).equals("ADMIN")) {
                    Admin admin = new Admin();
                    admin.menu();
                }
                if(user.get(tipo).equals("DONO")) {
                    DonoStand dono = new DonoStand();
                    dono.menu();
                }
                if(user.get(tipo).equals("CLIENTE")) {
                    Cliente cliente = new Cliente();
                    cliente.menu();
                }
            }
            else
                throw new UtilizadorException("Dados de acesso errados!");
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
            Ficheiro.escreverFicheiro(map);
    }

    public void apresentaDados(){
        for(Map.Entry<Integer, List<String>> info: map.entrySet()) {
            System.out.println(info.getValue()+ ", ");
        }
    }
}