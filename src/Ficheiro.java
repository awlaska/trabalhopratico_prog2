import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Ficheiro {
    public static void escreverFicheiro(String ficheiro, LinkedHashMap<Integer, List<String>> map) throws IOException {
        try {
            File file = new File("src/Ficheiros/" + ficheiro + ".csv");
            BufferedWriter bf = null;
            bf = new BufferedWriter(new FileWriter(file));
            for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
                bf.write(entry.getKey()
                        + ";" + entry.getValue().get(0)
                        + ";" + entry.getValue().get(1)
                        + ";" + entry.getValue().get(2)
                        + ";" + entry.getValue().get(3)
                        + ";" + entry.getValue().get(4));
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
                bf.write(entry.getKey()
                        + ";" + entry.getValue().get(0)
                        + ";" + entry.getValue().get(1)
                        + ";" + entry.getValue().get(2)
                        + ";" + entry.getValue().get(3)
                        + ";" + entry.getValue().get(4));
                bf.newLine();
            }
            bf.flush();
            System.out.println("Escreveu com successo.\n");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro.\n");
            e.printStackTrace();
        }
    }

    public static void escreverFicheiroReserva(String ficheiro, List<Reserva> reserva) throws IOException {
        try {
            File reservas = new File("src/Ficheiros/" + ficheiro + ".csv");
            BufferedWriter bf = null;
            bf = new BufferedWriter(new FileWriter(reservas));
            for (Reserva entry : reserva) {
                bf.write(entry.getNrReserva()
                        + ";" + entry.getDiaVisita()
                        + ";" + entry.getMesVisita()
                        + ";" + entry.getAnoVisita()
                        + ";" + entry.getIdCliente()
                        + ";" + entry.getIdCarro());
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

    public static ArrayList<Reserva> loadList(String ficheiro, int size) throws IOException {
        ArrayList<Reserva> res = new ArrayList<>();
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
            ArrayList<String> values = new ArrayList<>();
            for (int i = 1; i < size; i++) {
                values.add(valuesTMP[0].split(";")[i].trim());
            }

            int nrRes = Integer.parseInt(values.get(0));
            int diaVis = Integer.parseInt(values.get(1));
            int mesVis = Integer.parseInt(values.get(2));
            int anoVis = Integer.parseInt(values.get(3));
            int nUser = Integer.parseInt(values.get(4));
            int nCarro = Integer.parseInt(values.get(5));

            res.add(new Reserva(nrRes, diaVis, mesVis, anoVis, nUser, nCarro));
        }
//        }
        return res;
    }

    public static void saveAll(LinkedHashMap<Integer, List<String>> mapU, LinkedHashMap<Integer, List<String>> mapV) throws IOException {
        escreverFicheiro("utilizadores", mapU);
        escreverFicheiroVeiculo("veiculos", mapV);
    }
}
