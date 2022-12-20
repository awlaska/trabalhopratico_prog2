import ENUM.estadoVeiculo;

import java.util.Date;

public class Veiculo {
    //TODO metodos:
        /*
        Criar list para armazenar veiculos
        adicionar veiculo á list
        editar info de um veiculo na list
        alterar estado do veiculo
        remover veiculo da list
        */
    private Utilizador donoStand;
    private int numCarro;
    private String marca;
    private String modelo;
    private Date dataStand;
    private estadoVeiculo estado = estadoVeiculo.DISPONIVEL;

    private int quantidadeCarros;

    public Veiculo(){
        this.quantidadeCarros++;
    }

    public Veiculo(Integer codigo, String marca, String modelo, Date dataEntradaStand){
        this.numCarro = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.dataStand = dataEntradaStand;
        quantidadeCarros++;
    }

    public void apresentaDados(){
        for(int i = 0; i < quantidadeCarros; i++){
                System.out.print("Marca: " + this.marca + "Modelo: " + this.modelo
                        + "Data de entrada no stand" + this.dataStand);
        }
    }
}