import java.io.IOException;
import persistencia.entidad.Cliente;
import persistencia.repositorio.RepositorioCliente;

/**@author rubenor*/
public class Main {
    public static void main(String[] args) throws IOException {
        RepositorioCliente repoC = new RepositorioCliente(); 
        
        for(int i = 0; i<3; i++){
            Cliente c1 = new Cliente("Juan", "Perez", Integer.toString(i), "rsro220228@upemor.edu.mx");
            repoC.getListaClientes().add(c1);
        }
        
        repoC.guardar();
    }
}
