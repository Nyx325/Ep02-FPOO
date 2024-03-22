package logica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import persistencia.entidad.Almacenable;
import persistencia.entidad.Cliente;
import persistencia.repositorio.Repositorio;

public abstract class Logica{
    protected Repositorio repo;

    public Repositorio getRepo() {
        return repo;
    }

    // Definimos la busqueda por nombre porque ambos funcionan similar,
    // además al empleado ser hijo de cliente los agrega correctamente
    // a la búsqueda
    public List<Almacenable> buscar(String nombre, String apellidos){
        List<Almacenable> resultBusq = new ArrayList<>();

        for(Almacenable c:repo.getLista()){
            Cliente busqueda = (Cliente) c;
            if(
                busqueda.getNombre().equals(nombre) &&
                busqueda.getApellidos().equals(apellidos)
            ){
                resultBusq.add(c);
            }
        }

        return resultBusq;
    }

    // En la clase abstracta de vista llamo a la funcion buscar(Stting), 
    // pero esta varía en implementacion según el tipo de vista, por lo que
    // se queda como func abstracta
    public abstract List<Almacenable> buscar(String campo);

    // Funcion que valida antes de agregar directamente al repo si hay un
    // usuario exactamente igual o si reptiren email o teléfono
    public void agregar(Cliente c) throws IOException {
        for(Almacenable cliente:repo.getLista()){
            Cliente c2 = (Cliente)cliente;
            if(c.equals(c2)){
                System.out.println("Usuario existente");
                return;
            }

            if(c.getEmail().equals(c2.getEmail())){
                System.out.println("Otro usuario ya cuenta con este email");
                return;
            }

            if(c.getTelefono().equals(c2.getTelefono())){
                System.out.println("Otro usuario ya cuenta con este telefono");
                return;
            }
        }

        repo.add(c);
        repo.guardar();
    }
}
