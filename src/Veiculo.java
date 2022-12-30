import ENUM.estadoVeiculo;

import java.io.IOException;
import java.util.Date;

public class Veiculo extends Stand{
    //TODO metodos:
        /*
        Criar list para armazenar veiculos
        adicionar veiculo á list
        editar info de um veiculo na list
        alterar estado do veiculo
        remover veiculo da list
        */

    private int numCarro;
    private String marca;
    private String modelo;
    private Date dataStand;
    private String matricula;
    private final estadoVeiculo estado = estadoVeiculo.DISPONIVEL;

    public Veiculo() throws IOException {
        super();
    }

    public Veiculo(Integer codigo, String marca, String modelo, String matricula, Date dataEntradaStand) throws IOException {
        super();
        this.numCarro = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.dataStand = dataEntradaStand;
    }
}