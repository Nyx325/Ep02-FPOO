package persistencia.repositorio;

import persistencia.entidad.Almacenable;
import persistencia.entidad.Empleado;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.io.File;
import java.nio.file.NoSuchFileException;

public class RepositorioEmpleado extends Repositorio{
    public RepositorioEmpleado() throws IOException{
        lista = new ArrayList<>();
        pathArchivo = "Empleados.csv";

        try{
            File archivo = new File(pathArchivo);
            List<String> lineasArch = Files.readAllLines(archivo.toPath());

            for(String registro:lineasArch){
                String[] registroSplit = registro.split(";");
                Empleado empleado = new Empleado(
                    registroSplit[0],
                    registroSplit[1],
                    registroSplit[2],
                    registroSplit[3],
                    registroSplit[4],
                    registroSplit[5]
                );

                lista.add(empleado);
            }
        }
        catch(NoSuchFileException ex){
            System.out.println(ex);
            this.guardar();
        }
    }

    /** Retorna el índice en la lista de empleados en el que se encuentra
     * el objeto buscado */
    public long buscar(Empleado e){
        long i = 0;
        for(Almacenable empleado:lista){
            if(e.equals((Empleado)empleado))
                return i;
            i++;
        }

        return -1;
    }
}
