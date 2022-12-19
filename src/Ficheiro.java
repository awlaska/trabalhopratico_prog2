import java.io.*;
import java.util.*;

public class Ficheiro {
//    public static void main(String[] args) {
//        loadMap("utilizadores");
//    }
    public static void escreverFicheiro(String ficheiro, LinkedHashMap<Integer, List<String>> map) throws IOException {
        try {
            File utilizadores = new File("src/Ficheiros/" + ficheiro + ".csv");
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

    public static LinkedHashMap<Integer, List<String>> loadMap(String ficheiro){
        File utilizadores = new File("src/Ficheiros/" + ficheiro + ".csv");
        Scanner scanner = null;
        LinkedHashMap<Integer, List<String>> map = new LinkedHashMap<>();
        try {
            scanner = new Scanner(utilizadores);
            while (scanner.hasNext()) {
                //Dividir Key do resto
                String line = scanner.nextLine();
                List<String> list = Arrays.asList(line.split(";"));
                System.out.println(list);
                String indice = list.get(0);
                System.out.println(indice);
                //---------------------------
                //tornar String em List
                String replace = line.replace("[","");
                String replace1 = replace.replace("]","");
//                String list2 = list.remove(0);
                List<String> list3 = Arrays.asList(replace1.split(";"));
                System.out.println(list3);
                //mudar list3 para string e dps list4 dividir list3 com ,
                List<String> list4 = new ArrayList<String>(list3);
                List<String> list5 = new ArrayList<String>(new ArrayList<String>(Arrays.asList(list4.split(",")));


                //Fazer put das keys e dos values
//                map.put(indice, listFinal);
            }
        }catch (InputMismatchException e) {
            System.out.println ("Mismatch exception:" + e );
        }
        catch (FileNotFoundException e) {
            System.out.println ("Ficheiro não encontrado!");
            System.exit (0);
        }
        return map;
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
