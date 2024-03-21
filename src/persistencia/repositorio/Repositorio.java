package persistencia.repositorio;

import persistencia.entidad.Almacenable;
import java.util.List;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public abstract class Repositorio{
    protected List<Almacenable> lista;
    protected String pathArchivo;

    public void guardar() throws IOException {
        File archivo = new File(pathArchivo);
        FileWriter fwriter = new FileWriter(archivo,false);
        PrintWriter pwriter = new PrintWriter(fwriter);

        for(Almacenable cliente:lista){
            String registro = cliente.toStringCsv();
            pwriter.append(registro);
        }
        pwriter.close();
        fwriter.close();
    }

    public List<Almacenable> getLista(){
        return lista;
    }

    public void add(Almacenable registro){
        lista.add(registro);
    }

    public void remove(int index){
        lista.remove(index);
    }
}
