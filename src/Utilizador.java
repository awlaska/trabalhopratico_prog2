import java.util.*;

public class Utilizador {

    protected Map<String, String> dados;
    //TODO map com: username; morada, nrtelemovel,
    // protected Map<String, List<elemento>>;
    private int nrUtilizadores;

    public Utilizador(){nrUtilizadores++;}

    public Utilizador(String user, String pass){
        this.dados = new HashMap<>();
        nrUtilizadores++;
    }

    public int getNrUtilizadores(){
        return this.nrUtilizadores;
    }

    public String getUsername(){
        return this.dados.keySet().toString();
    }
    public String getPassword(){
        return this.dados.values().toString();
    }

//    public void apresentaDados(){
//        for(var dado : dados.entrySet()) {
//            System.out.println("Username: " + dado.getKey() + "\tPassword: " + dado.getValue());
//        }
//    }


}