import java.io.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Ficheiro {
    public static void escreverFicheiro(LinkedHashMap<Integer, List<String>> map) throws IOException {
        try {
            File utilizadores = new File("src/Ficheiros/" + "utilizadores" + ".csv");
            BufferedWriter bf = null;
            bf = new BufferedWriter(new FileWriter(utilizadores));
            for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
                bf.write(entry.getKey() + ";" + entry.getValue());
                bf.newLine();
            }
            bf.flush();
            System.out.println("Escreveu com successo.");
        }catch (IOException e) {
            System.out.println("Ocorreu um erro.");
            e.printStackTrace();
        }
    }

//    public void escreverFicheiro(String ficheiro, String utilizador, String donoStand, String veiculo, String dataReserva){
//        try {
//            FileWriter infoE = new FileWriter("src/Ficheiros/" + ficheiro + ".csv");
//            infoE.write(utilizador + ";" + donoStand + ";" + veiculo + ";" + dataReserva + "\n");
//            infoE.close();
//            System.out.println("Escreveu com successo.");
//        } catch (IOException e) {
//            System.out.println("Ocorreu um erro.");
//            e.printStackTrace();
//        }
//    }
}
