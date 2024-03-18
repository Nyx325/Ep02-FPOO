import java.io.IOException;
import persistencia.entidad.Cliente;
import persistencia.entidad.Empleado;
import persistencia.repositorio.RepositorioCliente;
import persistencia.repositorio.RepositorioEmpleado;

/**@author rubenor*/
public class Main {
    public static void main(String[] args) throws IOException {
        RepositorioCliente repoC = new RepositorioCliente(); 
        RepositorioEmpleado repoE = new RepositorioEmpleado();
        
        for(int i = 0; i<3; i++){
            Cliente c1 = new Cliente("Juan", "Perez", Integer.toString(i), "rsro220228@upemor.edu.mx");
            Empleado e1 = new Empleado("José", "López", "77723430", "a@gmail.com", "RH", "Tesorero");
            repoC.add(c1);
            repoE.add(e1);
        }
        
        repoC.guardar();
        repoE.guardar();
    }
}
