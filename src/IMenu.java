import java.io.IOException;

public interface IMenu {
    void menuUtilizadores(int idUser) throws IOException, UtilizadorException;

    void menuVeiculos(int idUser) throws IOException, UtilizadorException;

    void menuReservas(int idUser) throws IOException, UtilizadorException;

    void menuVendas(int idUser) throws IOException, UtilizadorException;
}
