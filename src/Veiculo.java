import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Veiculo {
    //private String marca;
    //private String modelo;
    //private Date dataStand;

    private Map<Integer, List<String, Date>> veiculo;

    private int quantidadeCarros;

    public Veiculo(Integer codigo, String marca, String modelo, Date dataEntradaStand){
        this.marca = new HashMap<>();
        this.modelo = new HashMap<>();
        this.dataEntradaStand = new HashMap<>();
        this.marca.put(codigo, marca);
        this.modelo.put(codigo, modelo);
        this.dataEntradaStand.put(codigo, dataEntradaStand);
        quantidadeCarros++;
    }

    public void apresentaDados(){
        for(int i = 0; i < quantidadeCarros; i++){
                System.out.print("Marca: " + this.marca.get(i) + "Modelo: " + this.modelo.get(i)
                        + "Data de entrada no stand" + this.dataEntradaStand.get(i));
        }
    }
}