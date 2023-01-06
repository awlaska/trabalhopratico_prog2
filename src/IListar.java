import java.io.IOException;

public interface IListar {
    void listarVeiculos(int idUserAtual) throws IOException, UtilizadorException;

    void listarReservas(int idUserAtual) throws IOException, UtilizadorException;

    void listarCompras(int idUserAtual) throws IOException, UtilizadorException;

    void listarUsers(int idUserAtual) throws IOException, UtilizadorException;
}
