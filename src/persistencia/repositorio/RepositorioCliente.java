package persistencia.repositorio;

import persistencia.entidad.Cliente;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.io.File;
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
public class RepositorioCliente extends Repositorio{
    public RepositorioCliente() throws IOException{
        lista = new ArrayList<>();
        pathArchivo = "Clientes.csv";

        try{
            File archivo = new File(pathArchivo);
            List<String> lineasArch = Files.readAllLines(archivo.toPath());

            for(String registro:lineasArch){
                String[] registroSplit = registro.split(";");
                Cliente cliente = new Cliente(
                    registroSplit[0],
                    registroSplit[1],
                    registroSplit[2],
                    registroSplit[3]);

                lista.add(cliente);
            }
        }
        catch(NoSuchFileException ex){
            System.out.println(ex);
            this.guardar();
        }
    }
}
