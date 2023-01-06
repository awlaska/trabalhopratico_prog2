import ENUM.tipoUser;
import java.io.IOException;
import java.util.*;

public class Utilizador {
    protected String username;
    protected String password;
    protected String nome;
    protected String nrTelemovel;
    protected int id;
    protected tipoUser tipo;

    protected LinkedHashMap<Integer, List<String>> utilizadores = new LinkedHashMap<>();
    protected List<String> dados;

    public Utilizador() throws IOException {}

    public Utilizador(String user, String pass, String nome, String nrTelemovel, tipoUser tipo) throws IOException {
        this.username = user;
        this.password = pass;
        this.nome = nome;
        this.nrTelemovel = nrTelemovel;
        this.tipo = null;
    }

    Veiculo veic = new Veiculo();
    Reserva reserva = new Reserva();
    Venda venda = new Venda();

    //DONE Load do mapa e Escrita do ficheiro
    public LinkedHashMap<Integer, List<String>> loadMapUtilizador() throws IOException {
        this.utilizadores = Ficheiro.loadMap("utilizadores", 6);
        return utilizadores;
    }
    public void writeMapUtilizador() throws IOException {
        Ficheiro.escreverFicheiroUtilizador("utilizadores", utilizadores);
    }

    //DONE Menu inicial
    public void menuInicial() throws IOException, UtilizadorException {
        loadMapUtilizador();
        Scanner input = new Scanner(System.in);

        System.out.println(">>Menu Inicial<<");
        System.out.print("1 - Login\n2 - Signup\n0 - Sair\n>> ");
        int op = input.nextInt();
        System.out.println();

        //TODO adicionar escrita dos ficheiros em falta (veiculos, reservas, vendas)
        switch (op) {
            case 0 -> {break;}
            case 1 -> login(utilizadores);
            case 2 -> signUp(utilizadores);
            default -> throw new IllegalStateException("Unexpected value: " + op);
        }
    }

    //DOING while para que passa dados outra vez e não parar de correr
    protected void login(LinkedHashMap<Integer, List<String>> map) throws UtilizadorException, IOException {
        Scanner logIn = new Scanner(System.in);
        String uname = "", pword = "";

        while (!map.containsValue(uname) && !map.containsValue(pword)) {
            System.out.print("Username\n>> ");
            uname = logIn.nextLine();
            System.out.print("Password\n>> ");
            pword = logIn.nextLine();

            for (int i = 0; i < map.size(); i++) {
                if (map.get(i).get(0).equals(uname)) {
                    id = i;
                }
            }

            if (map.get(id).get(0).equals(uname) && map.get(id).get(1).equals(pword)) {
                System.out.println("User autenticado!");
                System.out.println();
            } else {
                throw new UtilizadorException("User não existente!");
            }

            if (!map.get(id).get(4).equals("NULL")) {
                if (map.get(id).get(4).equals("ADMIN")) {
                    Admin admin = new Admin();
                    admin.menuA(id);
                    break;
                }
                if (map.get(id).get(4).equals("DONO")) {
                    DonoStand dono = new DonoStand();
                    dono.menuD(id);
                    break;
                }
                if (map.get(id).get(4).equals("CLIENTE")) {
                    Cliente cliente = new Cliente();
                    cliente.menuC(id);
                    break;
                }
            } else {
                throw new UtilizadorException("!!Aguarde ativação do administrador!!");
            }
        }
    }

    //DOING Corrigir ciclo while caso algo errado volta a pedir dados
    protected void signUp(LinkedHashMap<Integer, List<String>> map) throws UtilizadorException, IOException {
        this.dados = new ArrayList();
        Scanner signup = new Scanner(System.in);

        //TODO meter while a funcionar
//        while (map.get(0).get(0).equals(username)){
            System.out.print("Username\n>> ");
            this.username = signup.nextLine();
            System.out.print("Password\n>> ");
            this.password = signup.nextLine();
            System.out.print("Nome\n>> ");
            this.nome = signup.nextLine();
            System.out.print("Número de telemovel\n>> ");
            this.nrTelemovel = signup.nextLine();
            this.tipo = tipoUser.NULL;

            for (int i = 0; i <= map.size(); i++) {
                if (!map.containsKey(i))
                    id = i;
            }

            dados.add(0, username);
            dados.add(1, password);
            dados.add(2, nome);
            dados.add(3, nrTelemovel);
            dados.add(4, tipo.toString());

            if (map.get(0).get(0).equals(username)) {
                throw new UtilizadorException("!!User já existente!!");
            } else {
                map.put(id, dados);
                writeMapUtilizador();
                System.out.println("\n\n");
                menuInicial();
            }
        }

    //DOING metodo Guardar Tudo (guarda os mapas em ficheiro ao sair do programa)
    //DOING path para o menu anterior
    protected void editarUser(int idUserAtual) throws UtilizadorException, IOException {
        Scanner input = new Scanner(System.in);
        Scanner inputOP = new Scanner(System.in);
        int op = -1;
        while (op != 0) {
            listarUsers(idUserAtual);
            System.out.println("\n!!Editar perfil!!\n");
            System.out.print("0 - Sair\n1 - Username\n2 - Password\n3 - Nome\n4 - Telefone\n>> ");
            op = inputOP.nextInt();
            switch (op) {
                case 0 -> {
//                    Ficheiro.saveAll(utilizadores, veiculos);
//                    menuC(idUserAtual);
                }
                case 1 -> {
                    System.out.print("Username: \n>> ");
                    String user = input.nextLine();
                    utilizadores.get(idUserAtual).set(0, user);
                }
                case 2 -> {
                    System.out.print("Password: \n>> ");
                    String pass = input.nextLine();
                    utilizadores.get(idUserAtual).set(1, pass);
                }
                case 3 -> {
                    System.out.print("Nome: \n>> ");
                    String nome = input.nextLine();
                    utilizadores.get(idUserAtual).set(2, nome);
                }
                case 4 -> {
                    System.out.print("Telefone: \n>> ");
                    String tele = input.nextLine();
                    utilizadores.get(idUserAtual).set(3, tele);
                }
                default -> throw new IllegalStateException("Unexpected value: " + op);
            }
        }
    }

    //DOING path para o menu anterior
    protected void apagarUsers() throws IOException, UtilizadorException {
        Scanner input = new Scanner(System.in);

        listarUsers(id);

        System.out.println("\n!!Apagar cliente!!");
        System.out.print("ID do cliente a apagar: \n>> ");
        int id = input.nextInt();

        if (utilizadores.get(id).get(4).equals("CLIENTE")) {
            for (int i = 0; i < 5; i++)
                utilizadores.get(id).set(i, "null");
        } else {
            throw new UtilizadorException("Não tem permissões para apagar este utilizador!");
        }
        writeMapUtilizador();
//        menuD(id);
    }

    //DOING path para o menu anterior
    protected void alterarTipoUser() throws IOException, UtilizadorException {
        Scanner inputint = new Scanner(System.in);
        Scanner inputstring = new Scanner(System.in);

        for (Map.Entry<Integer, List<String>> entry : utilizadores.entrySet())
            System.out.println(entry.getKey() + "->" + entry.getValue());

        System.out.println("\n!!Alteração do tipo de user!!");
        System.out.print("ID do user a alterar: \n>> ");
        int id = inputint.nextInt();
        System.out.print("Tipo de user a atribuir (ADMIN, DONO, CLIENTE): \n>> ");
        String tipo = inputstring.nextLine();


        if (tipo.equalsIgnoreCase("ADMIN") || tipo.equalsIgnoreCase("DONO") || tipo.equalsIgnoreCase("CLIENTE")) {
            utilizadores.get(id).set(4, tipo.toUpperCase());
        } else {
            System.out.println("Tipo inválido!");
        }

        writeMapUtilizador();
//        menuA(id);
    }

    //DOING path para o menu anterior
    //DOING adicionar ao método listarUsers if() de forma a verificar o id e mostrar consoante a permissão
    public void listarUsers(int idUserAtual) throws IOException, UtilizadorException {
        //if(idUserAtual contem tipo != 'CLIENTE')
        System.out.println("\nid -> username, password, nome, telefone, tipo");
        for (Map.Entry<Integer, List<String>> entry : utilizadores.entrySet())
            System.out.println(entry.getKey() +
                    " -> " + entry.getValue().get(0) +
                    ", " + entry.getValue().get(1) +
                    ", " + entry.getValue().get(2) +
                    ", " + entry.getValue().get(3) +
                    ", " + entry.getValue().get(4));
        System.out.println();
        //else
        System.out.println("\nid -> username, password, nome, telefone");
        for (Map.Entry<Integer, List<String>> entry : utilizadores.entrySet())
            if (entry.getKey().equals(idUserAtual))
                System.out.println(entry.getKey() +
                        " -> " + entry.getValue().get(0) +
                        ", " + entry.getValue().get(1) +
                        ", " + entry.getValue().get(2) +
                        ", " + entry.getValue().get(3));
        System.out.println();
    }
}