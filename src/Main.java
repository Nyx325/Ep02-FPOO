import java.io.IOException;

import persistencia.entidad.Cliente;
import persistencia.repositorio.RepositorioCliente;

/**@author rubenor*/
public class Main {
    public static void main(String[] args) throws IOException {
        RepositorioCliente repoC = new RepositorioCliente();

        repoC.add(new Cliente("Juan", "Juarez", "1", "2"));
        repoC.add(new Cliente("Jose", "Lopez", "1", "2"));

        System.out.println(repoC.buscar(new Cliente("Juan", "Juarez", "1", "2")));
        
        Cliente c = new Cliente("Juan", "Juarez", "1", "2");

        System.out.println(c.equals(new Cliente("Juan", "Juarez", "1", "2")));
    }
}
