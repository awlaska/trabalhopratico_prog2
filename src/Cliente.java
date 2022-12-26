import ENUM.tipoUser;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Cliente extends Utilizador implements IListar{
    public Cliente() throws IOException {super();}
    LinkedHashMap<Integer, List<String>> utilizadores = Ficheiro.loadMap("utilizadores", 6);

    //TODO completar switch do menu
    /*
    Apenas pode ver registos que lhe digam respeito (estão associados ao seu id)

    Listar Veiculos (Apenas os que tem estado DISPONIVEL):
    -Pode escolher um para reserva (diz o id do carro)

    Listar Compras (Os veiculos comprados tem id do user associado e estado igual a VENDIDO)

    Listar Reservas:
    -Alterar data da visita ao stand
    -Cancelar/Apagar reserva (Muda estado do veiculo de Reservado para Disponivel)

    Ver Perfil:
    -Lista a info do user que fez login

    Editar Perfil:
    -edita só
     */
    public void menuC(int idUserAtual) throws IOException, UtilizadorException {
        Scanner input = new Scanner(System.in);

        System.out.println("Id do user atual: " + idUserAtual);

        System.out.print("0 - Sair\n1 - Listar veiculos\n2 - Listar compras\n3 - Listar reservas\n4 - Apagar Reserva\n5 - Alterar Data de Visita\n6 - Ver/Editar perfil\n>> ");
        int op = input.nextInt();

        switch (op) {
            case 0 -> {Ficheiro.escreverFicheiro("utilizadores", utilizadores);break;}
            case 1 -> listarVeiculos();
            case 2 -> listarCompras();
            case 3 -> listarReservas();
            case 4 -> {/*apagarReserva();*/}
            case 5 -> {/*alterarData();*/}
            case 6 -> editarUser(idUserAtual);
            default -> throw new IllegalStateException("Unexpected value: " + op);
        }
    }

    private void editarUser(int idUserAtual) throws UtilizadorException, IOException {
        Scanner input = new Scanner(System.in);

        //TODO print dos valores que correspondem ao idUserAtual, perguntar o que quer alterar, criar switch com alterações

        Ficheiro.escreverFicheiro("utilizadores", utilizadores);
        menuC(idUserAtual);
    }

    //TODO fazer metodos
    @Override
    public void listarCompras() {

    }
    @Override
    public void listarUser() {

    }
    @Override
    public void listarReservas() {

    }
    @Override
    public void listarVeiculos() {

    }
}
