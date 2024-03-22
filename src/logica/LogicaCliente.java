package logica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import persistencia.entidad.Almacenable;
import persistencia.entidad.Cliente;
import persistencia.repositorio.RepositorioCliente;

public class LogicaCliente extends Logica {

    public LogicaCliente() throws IOException {
        repo = new RepositorioCliente();
    }

    public List<Almacenable> buscar(String email){
        List<Almacenable> resultBusq = new ArrayList<>();

        for(Almacenable c:repo.getLista()){
            Cliente busqueda = (Cliente) c;
            if(busqueda.getEmail().equals(email)){
                resultBusq.add(c);
            }
        }

        return resultBusq;
    }
}
