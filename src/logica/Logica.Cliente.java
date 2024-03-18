package logica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import persistencia.entidad.Cliente;
import persistencia.repositorio.RepositorioCliente;

public class LogicaCliente {
    private RepositorioCliente repositorioCliente;

    public LogicaCliente() {
        this.repositorioCliente = new RepositorioCliente();
    }

    public List<Cliente> obtenerClientes() throws IOException {
        return this.repositorioCliente.obtenerClientes();   
    }
}