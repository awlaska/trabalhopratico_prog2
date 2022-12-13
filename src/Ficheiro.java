import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ficheiro {
    public void escreverFicheiro(String ficheiro, String user, String password, int nrPermissao){
        try {
            FileWriter infoE = new FileWriter("src/Ficheiros/" + ficheiro + ".csv");
            infoE.write(user + ";" + password + ";" + nrPermissao + "\n");
            infoE.close();
            System.out.println("Escreveu com successo.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro.");
            e.printStackTrace();
        }
    }

    public void escreverFicheiro(String ficheiro, String utilizador, String donoStand, String veiculo, String dataReserva){
        try {
            FileWriter infoE = new FileWriter("src/Ficheiros/" + ficheiro + ".csv");
            infoE.write(utilizador + ";" + donoStand + ";" + veiculo + ";" + dataReserva + "\n");
            infoE.close();
            System.out.println("Escreveu com successo.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro.");
            e.printStackTrace();
        }
    }
}
