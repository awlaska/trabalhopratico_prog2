import ENUM.tipoUser;

import java.io.IOException;
import java.util.*;

public class Utilizador {
    public LinkedHashMap<Integer, List<String>> utilizadores = new LinkedHashMap<>();
    protected String username;
    protected String password;
    protected String nome;
    protected String nrTelemovel;
    protected int id;
    protected tipoUser tipo;
    protected List<String> dados;

    Veiculo veic = new Veiculo();
    Reserva reserva = new Reserva();
    Venda venda = new Venda();

    public Utilizador() throws IOException {
    }

    public Utilizador(String user, String pass, String nome, String nrTelemovel, tipoUser tipo) throws IOException {
        this.username = user;
        this.password = pass;
        this.nome = nome;
        this.nrTelemovel = nrTelemovel;
        this.tipo = null;
    }

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
            case 0 -> {
                break;
            }
            case 1 -> login();
            case 2 -> signUp();
            default -> throw new IllegalStateException("Unexpected value: " + op);
        }
    }

    //DOING while para que passa dados outra vez e não parar de correr
    public void login() throws UtilizadorException, IOException {
        Scanner logIn = new Scanner(System.in);
        String uname = "", pword = "";

        loadMapUtilizador();

        System.out.print("Username\n>> ");
        uname = logIn.nextLine();
        System.out.print("Password\n>> ");
        pword = logIn.nextLine();

        for (int i = 0; i < utilizadores.size(); i++) {
            if (utilizadores.get(i).get(0).equals(uname)) {
                id = i;
            }
        }

        if (utilizadores.get(id).get(0).equals(uname) && utilizadores.get(id).get(1).equals(pword)) {
            System.out.println("User autenticado!\n");
        } else {
            throw new UtilizadorException("User não existente!");
        }

        if (utilizadores.get(id).get(4).equals("NULL")) {
            throw new UtilizadorException("!!Aguarde ativação do administrador!!");
        } else if (utilizadores.get(id).get(4).equals("APAGADO")) {
            throw new UtilizadorException("!!Utilizador Apagado!!");
        } else {
            menuAnt(id);
        }
    }

    //DOING rever ciclo while caso algo errado volta a pedir dados
    protected void signUp() throws UtilizadorException, IOException {
        this.dados = new ArrayList();
        Scanner signup = new Scanner(System.in);

        loadMapUtilizador();

        System.out.print("Username\n>> ");
        this.username = signup.nextLine();
        System.out.print("Password\n>> ");
        this.password = signup.nextLine();
        System.out.print("Nome\n>> ");
        this.nome = signup.nextLine();
        System.out.print("Número de telemovel\n>> ");
        this.nrTelemovel = signup.nextLine();
        this.tipo = tipoUser.NULL;

        for (int i = 0; i <= utilizadores.size(); i++) {
            if (!utilizadores.containsKey(i))
                id = i;
        }
        if (!utilizadores.get(0).get(0).contains(username)) {
            throw new UtilizadorException("!Username não é válido!");
        }

        dados.add(0, username);
        dados.add(1, password);
        dados.add(2, nome);
        dados.add(3, nrTelemovel);
        dados.add(4, tipo.toString());

        if (utilizadores.get(0).get(0).contains(username)) {
            throw new UtilizadorException("!!User já existente!!");
        } else {
            utilizadores.put(id, dados);
            writeMapUtilizador();
            menuInicial();
        }
    }

    //DONE ver menus (path para o menu anterior)
    protected void editarUser(int idUserAtual) throws UtilizadorException, IOException {
        Admin admin = new Admin();
        Cliente cliente = new Cliente();
        DonoStand dono = new DonoStand();
        Scanner input = new Scanner(System.in);
        Scanner inputOP = new Scanner(System.in);

        loadMapUtilizador();

        int op = -1;
        String user, pass, nome, tele;

        while (op != 0) {
            listarUsers(idUserAtual);
            System.out.println("\n>>Editar perfil<<\n");
            System.out.print("0 - Sair\n1 - Username\n2 - Password\n3 - Nome\n4 - Telefone\n>> ");
            op = inputOP.nextInt();

            switch (op) {
                case 0 -> {
                    menuAnt(idUserAtual);
                }
                case 1 -> {
                    do {
                        System.out.print("Username: \n>> ");
                        user = input.nextLine();
                        if (!utilizadores.get(0).get(0).contains(user)) {
                            System.out.println("!Username não é válido!");
                        } else {
                            utilizadores.get(idUserAtual).set(0, user);
                        }
                    } while (!utilizadores.get(0).get(0).contains(user));
                }
                case 2 -> {
                    System.out.print("Password: \n>> ");
                    pass = input.nextLine();
                    utilizadores.get(idUserAtual).set(1, pass);
                }
                case 3 -> {
                    System.out.print("Nome: \n>> ");
                    nome = input.nextLine();
                    utilizadores.get(idUserAtual).set(2, nome);
                }
                case 4 -> {
                    System.out.print("Telefone: \n>> ");
                    tele = input.nextLine();
                    utilizadores.get(idUserAtual).set(3, tele);
                }
                default -> throw new IllegalStateException("Unexpected value: " + op);
            }
            writeMapUtilizador();
            menuAnt(idUserAtual);
        }
    }

    //DONE path para o menu anterior
    protected void apagarUsers(int idUserAtual) throws IOException, UtilizadorException {
        Admin admin = new Admin();
        Cliente cliente = new Cliente();
        DonoStand dono = new DonoStand();
        loadMapUtilizador();
        Scanner input = new Scanner(System.in);

        listarUsers(id);

        System.out.println("\n!!Apagar cliente!!");
        System.out.print("ID do cliente a apagar: \n>> ");
        int id = input.nextInt();

        if (utilizadores.containsKey(id)) {
            utilizadores.get(id).set(4, "APAGADO");
        } else {
            System.out.println("!Utilizador não é válido!");
            apagarUsers(idUserAtual);
        }
        writeMapUtilizador();
        menuAnt(idUserAtual);
    }

    //DONE path para o menu anterior
    protected void alterarTipoUser(int idUser) throws IOException, UtilizadorException {
        loadMapUtilizador();
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
            alterarTipoUser(idUser);
        }

        writeMapUtilizador();
        menuAnt(idUser);
    }

    public void menuAnt(int idUser) throws IOException, UtilizadorException {
        Cliente cliente = new Cliente();
        DonoStand dono = new DonoStand();
        Admin admin = new Admin();
        loadMapUtilizador();
        if (utilizadores.get(idUser).get(4).equals("ADMIN")) {
            admin.menuA(idUser);
        } else if (utilizadores.get(idUser).get(4).equals("DONO")) {
            dono.menuD(idUser);
        } else if (utilizadores.get(idUser).get(4).equals("CLIENTE")) {
            cliente.menuC(idUser);
        }
    }

    //DONE path para o menu anterior
    //DONE adicionar ao método listarUsers if() de forma a verificar o id e mostrar consoante a permissão
    public void listarUsers(int idUserAtual) throws IOException, UtilizadorException {
        loadMapUtilizador();
        if (utilizadores.get(idUserAtual).get(4).contains("CLIENTE")) {
            System.out.println("\n>>Utilizador Atual<<");
            System.out.println("id -> username, password, nome, telefone");
            for (Map.Entry<Integer, List<String>> entry : utilizadores.entrySet())
                if (entry.getKey().equals(idUserAtual))
                    System.out.println(entry.getKey() +
                            " -> " + entry.getValue().get(0) +
                            ", " + entry.getValue().get(1) +
                            ", " + entry.getValue().get(2) +
                            ", " + entry.getValue().get(3));
            System.out.println();
        } else {
            System.out.println("\n>>Utilizadores no Sistema<<");
            System.out.println("id -> username, password, nome, telefone, tipo");
            for (Map.Entry<Integer, List<String>> entry : utilizadores.entrySet())
                System.out.println(entry.getKey() +
                        " -> " + entry.getValue().get(0) +
                        ", " + entry.getValue().get(1) +
                        ", " + entry.getValue().get(2) +
                        ", " + entry.getValue().get(3) +
                        ", " + entry.getValue().get(4));
            System.out.println("\n>>Utilizador Atual<<");
            System.out.println("id -> username, password, nome, telefone, estado");
            for (Map.Entry<Integer, List<String>> entry : utilizadores.entrySet())
                if (entry.getKey().equals(idUserAtual))
                    System.out.println(entry.getKey() +
                            " -> " + entry.getValue().get(0) +
                            ", " + entry.getValue().get(1) +
                            ", " + entry.getValue().get(2) +
                            ", " + entry.getValue().get(3) +
                            ", " + entry.getValue().get(4));
            System.out.println();
        }
    }

    public void listarClientes() throws IOException, UtilizadorException {
        loadMapUtilizador();
        System.out.println("\n>>Clientes<<");
        System.out.println("id -> username, password, nome, telefone, tipo");
        for (Map.Entry<Integer, List<String>> entry : utilizadores.entrySet()) {
            if (entry.getValue().contains("CLIENTE")) {
                System.out.println(entry.getKey() +
                        " -> " + entry.getValue().get(0) +
                        ", " + entry.getValue().get(1) +
                        ", " + entry.getValue().get(2) +
                        ", " + entry.getValue().get(3) +
                        ", " + entry.getValue().get(4));
            }
        }
    }

    public String tipoDeUser(int idUser) {
        return utilizadores.get(idUser).get(4);
    }
}