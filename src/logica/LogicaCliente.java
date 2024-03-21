package logica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import persistencia.entidad.Almacenable;
import persistencia.entidad.Cliente;
import persistencia.repositorio.RepositorioCliente;

public class LogicaCliente {
    private RepositorioCliente repoC;

    public LogicaCliente() throws IOException {
        this.repoC = new RepositorioCliente();
    }

    public RepositorioCliente getRepo() throws IOException {
        return this.repoC;   
    }

    public void agregarCliente(Cliente c){
        for(Almacenable cliente:repoC.getLista()){
            if(c.equals((Cliente)cliente)){
                System.out.println("Cliente ya existente");
                return;
            }
        }

        repoC.add(c);
    }

    public long buscarCliente(Cliente c){
        long i = 0;
        for(Almacenable cliente:repoC.getLista()){
            if(c.equals((Cliente)cliente)){
                return i;
            }
            i++;
        }

        return -1;
    }

    public List<Almacenable> buscarClientes(String nombre, String apellidos){
        List<Almacenable> resultBusq = new ArrayList<>();

        for(Almacenable c:repoC.getLista()){
            Cliente busqueda = (Cliente) c;
            if(
                busqueda.getNombre().equals(nombre) &&
                busqueda.getApellidos().equals(apellidos)
            )
            {
                resultBusq.add(c);
            }
        }

        return resultBusq;
    }

    public void remove(Cliente c){
        repoC.getLista().remove(c);
    }

    public void remove(int index){
        repoC.getLista().remove(index);
    }
}
