import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class User {
    private String username;
    private String password;

    public User(String user, String pass){
        this.username = user;
        this.password = pass;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return this.password;
    }

    public void CriarFicheiro(){
        try {
            File infoC = new File("info.txt");
            if (infoC.createNewFile()) {
                System.out.println("Ficheiro criado: " + infoC.getName());
            } else {
                System.out.println("Ficheiro já existente.");
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro.");
            e.printStackTrace();
        }
    }

    public void EscreverFicheiro(){
        try {
            FileWriter infoE = new FileWriter("info.txt");
            infoE.write("Files in Java might be tricky, but it is fun enough!");
            infoE.close();
            System.out.println("Escreveu com successo.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erros.");
            e.printStackTrace();
        }
    }

}