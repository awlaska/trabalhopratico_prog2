public class main {
    public static void main(String[] args) {
        Utilizador user = new Utilizador("user1", "pass1");

        Ficheiro ficheiro = new Ficheiro();
        ficheiro.CriarFicheiro();
        ficheiro.EscreverFicheiro(user.getUsername(), user.getPassword());
    }
}