import java.io.*;
import java.util.*;

public class Ficheiro {
    //DOING teste
//    public static void main(String[] args) throws IOException {
//        try {
//            loadMap("utilizadores");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    //Escrever no ficheiro utilizadores
    public static void escreverFicheiro(String ficheiro, LinkedHashMap<Integer, List<String>> map) throws IOException {
        try {
            File utilizadores = new File("src/Ficheiros/" + ficheiro + ".csv");
            BufferedWriter bf = null;
            bf = new BufferedWriter(new FileWriter(utilizadores));
            for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
                int key = entry.getKey();
                String user = entry.getValue().get(0);
                String password = entry.getValue().get(1);
                String nome = entry.getValue().get(2);
                String nr = entry.getValue().get(3);
                String tipo = entry.getValue().get(4);
                bf.write(key + ";" + user + ";" + password + ";" + nome + ";" + nr + ";" + tipo);
                bf.newLine();
            }
            bf.flush();
            System.out.println("Escreveu com successo.");
        }catch (IOException e) {
            System.out.println("Ocorreu um erro.");
            e.printStackTrace();
        }
    }

    //TODO escrever no ficheiro veiculos
    //TODO escrever no ficheiro reservas
    //TODO escrever no ficheiro vendas

    public static LinkedHashMap<Integer, List<String>> loadMap(String ficheiro, int size) throws IOException {
        LinkedHashMap<Integer, List<String>> userData = new LinkedHashMap<>();
        String currentLine = "";
        String[] valuesTMP;

        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader("src/Ficheiros/" + ficheiro + ".csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while ((currentLine = bf.readLine()) != null) {
            valuesTMP = currentLine.split("\n");
            List<String> values = new ArrayList<>();
            String key = valuesTMP[0].split(";")[0].trim();
            int nkey = Integer.parseInt(key);
            for (int i = 1; i < size; i++) {
                values.add(valuesTMP[0].split(";")[i].trim());
            }
            userData.put(nkey, values); // <--this line was moved out from internal for loop
        }
        return userData;
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
