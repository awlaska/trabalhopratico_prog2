import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ficheiro {
    @Test
    public void CriarFicheiro(){
        try {
            File infoC = new File("src/Ficheiros/info.txt");
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
