package persistencia.repositorio;

import persistencia.entidad.Cliente;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.NoSuchFileException;

/**
 * @author rubenor
 * El propósito de esta clase es brindar un repositorio en ram siendo una
 * lista en la cual podemos agregar, eliminar, buscar, etc los datos y si
 * nos sentimos generosos, ordenar. Sin embargo tanto para el almacenado 
 * tendremos que usar el constructor que lee el archivo y en casos puntuales
 * unicamente llamar al método guardar() que tal cual tengamos el repositorio
 * almacenará todo el contenido de la lista en el archivo
 */
public class RepositorioCliente {
    private List<Cliente> listaClientes;

    public RepositorioCliente() throws IOException{
        listaClientes = new ArrayList<>();

        try{
            File archivo = new File("Clientes.csv");
            List<String> lineasArch = Files.readAllLines(archivo.toPath());

            for(String registro:lineasArch){
                String[] registroSplit = registro.split(";");
                Cliente cliente = new Cliente(
                    registroSplit[0],
                    registroSplit[1],
                    registroSplit[2],
                    registroSplit[3]
                );

                listaClientes.add(cliente);
            }
        }
        catch(NoSuchFileException ex){
            System.out.println(ex);
            this.guardar();
        }
        
    }
    
    public List<Cliente> getListaClientes(){
        return listaClientes;
    }

    public void guardar() throws IOException {
        File archivo = new File("Clientes.csv");
        FileWriter fwriter = new FileWriter(archivo,false);
        PrintWriter pwriter = new PrintWriter(fwriter);

        for(Cliente cliente:listaClientes){
            String registro = cliente.getNombre()+";"+cliente.getApellidos()+";"+cliente.getTelefono()+";"+cliente.getEmail()+"\n";
            pwriter.append(registro);
        }
        pwriter.close();
        fwriter.close();
    }
}
