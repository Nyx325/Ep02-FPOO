package logica;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import persistencia.entidad.Almacenable;
import persistencia.entidad.Empleado;
import persistencia.repositorio.RepositorioEmpleado;

public class LogicaEmpleado extends Logica{
    public LogicaEmpleado() throws IOException {
        repo = new RepositorioEmpleado();
    }

    public List<Almacenable> buscar(String departamento){
        List<Almacenable> resultBusq = new ArrayList<>();

        for(Almacenable e:repo.getLista()){
            Empleado busqueda = (Empleado) e;
            if(busqueda.getDepartamento().equals(departamento)){
                resultBusq.add(e);
            }
        }

        return resultBusq;
    }
}
