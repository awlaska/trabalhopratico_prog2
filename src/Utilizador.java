public class Utilizador {
    private String username;
    private String password;

    public Utilizador(String user, String pass){
        this.username = user;
        this.password = pass;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return this.password;
    }

}