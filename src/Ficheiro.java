import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ficheiro {
    public void CriarFicheiro(){
        File infoC = new File("src/Ficheiros/info.csv");
    }

    public void EscreverFicheiro(String user, String password){
        try {
            FileWriter infoE = new FileWriter("src/Ficheiros/info.csv");
            infoE.write(user + ";" + password);
            infoE.close();
            System.out.println("Escreveu com successo.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro.");
            e.printStackTrace();
        }
    }
}
