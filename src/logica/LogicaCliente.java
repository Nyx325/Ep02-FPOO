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

    public void agregarCliente(Cliente c) throws IOException {
        for(Almacenable cliente:repoC.getLista()){
            Cliente c2 = (Cliente)cliente;
            if(c.equals(c2)){
                System.out.println("Cliente ya existente");
                return;
            }

            if(c.getEmail().equals(c2.getEmail())){
                System.out.println("Otro cliente ya cuenta con este email");
                return;
            }

            if(c.getTelefono().equals(c2.getTelefono())){
                System.out.println("Otro cliente ya cuenta con este telefono");
                return;
            }
        }

        repoC.add(c);
        repoC.guardar();
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

    public List<Almacenable> buscarClientes(String email){
        List<Almacenable> resultBusq = new ArrayList<>();

        for(Almacenable c:repoC.getLista()){
            Cliente busqueda = (Cliente) c;
            if(busqueda.getEmail().equals(email)){
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
