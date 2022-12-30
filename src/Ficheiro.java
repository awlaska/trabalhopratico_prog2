import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Ficheiro {
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
            System.out.println("Escreveu com successo.\n");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro.\n");
            e.printStackTrace();
        }
    }
    public static void escreverFicheiro2(String ficheiro, LinkedHashMap<Integer, List<String>> map) throws IOException {
        try {
            File veiculos = new File("src/Ficheiros/" + ficheiro + ".csv");
            BufferedWriter bf = null;
            bf = new BufferedWriter(new FileWriter(veiculos));
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
            System.out.println("Escreveu com successo.\n");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro.\n");
            e.printStackTrace();
        }
    }

    public static void escreverFicheiroVeiculo(String ficheiro, LinkedHashMap<Integer, List<String>> map) {
        try {
            File veiculos = new File("src/Ficheiros/" + ficheiro + ".csv");
            BufferedWriter bf = null;
            bf = new BufferedWriter(new FileWriter(veiculos));
            for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
                int key = entry.getKey();
                String marca = entry.getValue().get(0);
                String modelo = entry.getValue().get(1);
                String matricula = entry.getValue().get(2);
                String data = entry.getValue().get(3);
                String tipo = entry.getValue().get(4);
                bf.write(key + ";" + marca + ";" + modelo + ";" + matricula + ";" + data + ";" + tipo);
                bf.newLine();
            }
            bf.flush();
            System.out.println("Escreveu com successo.\n");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro.\n");
            e.printStackTrace();
        }
    }

    public static LinkedHashMap<Integer, List<String>> loadMap(String ficheiro, int size) throws IOException {
        LinkedHashMap<Integer, List<String>> data = new LinkedHashMap<>();
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
            data.put(nkey, values); // <--this line was moved out from internal for loop
        }
        return data;
    }

    public static void saveAll(LinkedHashMap<Integer, List<String>> mapU, LinkedHashMap<Integer, List<String>> mapV) throws IOException {
        escreverFicheiro("utilizadores", mapU);
        escreverFicheiroVeiculo("veiculos", mapV);
    }
}
