import ENUM.estadoReserva;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Ficheiro {
    public static void escreverFicheiroUtilizador(String ficheiro, LinkedHashMap<Integer, List<String>> map) throws IOException {
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
        } catch (IOException e) {
            System.out.println("\nOcorreu um erro.\n");
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
                        + ";" + entry.getValue().get(4)
                        + ";" + entry.getValue().get(5));
                bf.newLine();
            }
            bf.flush();
        } catch (IOException e) {
            System.out.println("\nOcorreu um erro.\n");
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
            data.put(nkey, values);
        }
        return data;
    }

    //DONE LISTS
    public static void escreverFicheiroReserva(String ficheiro, ArrayList<Reserva> reserva) throws IOException {
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
                        + ";" + entry.getIdCarro()
                        + ";" + entry.getEstado());
                bf.newLine();
            }
            bf.flush();
        } catch (IOException e) {
            System.out.println("\nOcorreu um erro.\n");
            e.printStackTrace();
        }
    }

    public static ArrayList<Reserva> loadListReserva(String ficheiro, int size) throws IOException {
        ArrayList<Reserva> res = new ArrayList<>();
        String currentLine = "";
        String[] valuesTMP;
        BufferedReader bf = null;

        try {
            bf = new BufferedReader(new FileReader("src/Ficheiros/" + ficheiro + ".csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int nrRes = 0, diaVis = 0, mesVis = 0, anoVis = 0, nUser = 0, nCarro = 0;
        estadoReserva estado;

        while ((currentLine = bf.readLine()) != null) {
            valuesTMP = currentLine.split("\n");
            List<String> values = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                values.add(valuesTMP[0].split(";")[i].trim());
            }

            nrRes = Integer.parseInt(values.get(0));
            diaVis = Integer.parseInt(values.get(1));
            mesVis = Integer.parseInt(values.get(2));
            anoVis = Integer.parseInt(values.get(3));
            nUser = Integer.parseInt(values.get(4));
            nCarro = Integer.parseInt(values.get(5));
            estado = estadoReserva.valueOf(values.get(6));

            res.add(new Reserva(nrRes, diaVis, mesVis, anoVis, nUser, nCarro, estado));
        }
        return res;
    }

    public static void escreverFicheiroVenda(String ficheiro, ArrayList<Venda> venda) throws IOException {
        try {
            File vendas = new File("src/Ficheiros/" + ficheiro + ".csv");
            BufferedWriter bf = null;
            bf = new BufferedWriter(new FileWriter(vendas));
            for (Venda entry : venda) {
                bf.write(entry.getNrVenda()
                        + ";" + entry.getDiaVenda()
                        + ";" + entry.getMesVenda()
                        + ";" + entry.getAnoVenda()
                        + ";" + entry.getIdCliente()
                        + ";" + entry.getIdCarro()
                        + ";" + entry.getValor());
                bf.newLine();
            }
            bf.flush();
        } catch (IOException e) {
            System.out.println("\nOcorreu um erro.\n");
            e.printStackTrace();
        }
    }

    public static ArrayList<Venda> loadListVenda(String ficheiro, int size) throws IOException {
        ArrayList<Venda> venda = new ArrayList<>();
        String currentLine = "";
        String[] valuesTMP;
        BufferedReader bf = null;
        int nrVenda = 0, diaVend = 0, mesVend = 0, anoVend = 0, nUser = 0, nCarro = 0;
        double valor = 0.0;

        try {
            bf = new BufferedReader(new FileReader("src/Ficheiros/" + ficheiro + ".csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while ((currentLine = bf.readLine()) != null) {
            valuesTMP = currentLine.split("\n");
            List<String> values = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                values.add(valuesTMP[0].split(";")[i].trim());
            }

            nrVenda = Integer.parseInt(values.get(0));
            diaVend = Integer.parseInt(values.get(1));
            mesVend = Integer.parseInt(values.get(2));
            anoVend = Integer.parseInt(values.get(3));
            nUser = Integer.parseInt(values.get(4));
            nCarro = Integer.parseInt(values.get(5));
            valor = Double.parseDouble(values.get(6));

            venda.add(new Venda(nrVenda, diaVend, mesVend, anoVend, nUser, nCarro, valor));
        }
        return venda;
    }
}
