import java.io.IOException;

public interface IListar {
    void listarVeiculos() throws IOException, UtilizadorException;

    void listarReservas() throws IOException, UtilizadorException;

    void listarCompras() throws IOException, UtilizadorException;

    void listarUsers() throws IOException, UtilizadorException;
}
