import java.io.IOException;
import persistencia.entidad.Cliente;
import persistencia.repositorio.RepositorioCliente;

/**@author rubenor*/
public class Main {
    public static void main(String[] args) throws IOException {
        RepositorioCliente repoC = new RepositorioCliente();
        
        Cliente c1 = new Cliente("Juan", "Perez", "7772496713", "rsro220228@upemor.edu.mx");
        
        for(int i = 0; i<3; i++){
            repoC.getListaClientes().add(c1);
        }
        
        repoC.guardar();
    }
}
