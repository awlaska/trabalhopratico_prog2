import ENUM.tipoUser;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Cliente extends Utilizador implements IListar{

    public Cliente(){super();}

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
    public void menu(int idUserAtual){
        Scanner input = new Scanner(System.in);
        System.out.println("0 - Sair || 1 - Listar veiculos || 2 - Listar compras || 3 - Listar reservas || 4 - Ver perfil || 5 - Editar perfil");
        System.out.println(">> ");
        System.out.println("Id do user atual: " + idUserAtual);
        int op = input.nextInt();
        switch (op) {
            case 0:
                return;
            case 1:
                listarVeiculos();
            case 2:
                listarCompras();
            case 3:
                listarReservas();
            case 4:
//                listarUser();
        }
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
