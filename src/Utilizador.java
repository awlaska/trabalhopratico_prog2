import java.util.*;

public class Utilizador {
    protected String username;
    protected String password;
    protected String morada;
    protected int nrTelemovel;
    private int nrUtilizadores = 0;

    public Utilizador(){nrUtilizadores++;}

    public Utilizador(String user, String pass){

        nrUtilizadores++;
    }

    public int getNrUtilizadores(){
        return this.nrUtilizadores;
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

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public int getNrTelemovel() {
        return nrTelemovel;
    }

    public void setNrTelemovel(int nrTelemovel) {
        this.nrTelemovel = nrTelemovel;
    }

    //    public void apresentaDados(){
//        for(var dado : dados.entrySet()) {
//            System.out.println("Username: " + this.username + "\tPassword: " + this.pass);
//        }
//    }
}