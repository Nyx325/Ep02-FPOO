package logica;

import java.io.IOException;
import java.util.List;
import persistencia.entidad.Almacenable;
import persistencia.repositorio.RepositorioCliente;

public class LogicaCliente {
    private RepositorioCliente repositorioCliente;

    public LogicaCliente() throws IOException {
        this.repositorioCliente = new RepositorioCliente();
    }

    public List<Almacenable> obtenerClientes() throws IOException {
        return this.repositorioCliente.getLista();   
    }
}