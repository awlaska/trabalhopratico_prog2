import java.io.IOException;

public class StandUI { //DONE :D
    public static void main(String[] args) throws UtilizadorException, IOException {
        Utilizador user = new Utilizador();
        user.menuInicial();
    }
}

//TODO Alterar List para Map nas reservas
//TODO Alterar List do Map utilizadores e veiculos de String para os tipos de classe