package vista;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import logica.LogicaEmpleado;
import persistencia.entidad.Almacenable;
import persistencia.entidad.Empleado;
import vista.Vista;

public class VistaEmpleado extends Vista{
    Scanner teclado;
    LogicaEmpleado logica;

    public VistaEmpleado() throws IOException {
        teclado = new Scanner(System.in);
        logica = new LogicaEmpleado();
        leyendaUsuario = "empleado";
    }

    public Empleado capturarUsuario(){
        String nombre, apellidos, telefono, email, departamento, cargo;

        System.out.println("Ingresa el nombre: ");
        nombre = teclado.next();
        System.out.println("Ingresa los apellidos: ");
        apellidos = teclado.next();
        System.out.println("Ingresa el telefono: ");
        telefono = teclado.next();
        System.out.println("Ingresa el email: ");
        email = teclado.next();
        System.out.println("Ingresa el departamento: ");
        departamento = teclado.next();
        System.out.println("Ingresa el cargo: ");
        cargo = teclado.next();

        return new Empleado(nombre, apellidos, telefono, email, departamento, cargo);
    }

    public List<Almacenable> buscar(){
        int i = 0;
        String nombre, apellido, departamento;
        List<Almacenable> resBusqueda = new ArrayList<>();

        System.out.println("\nBienvenido a los gorditos morenitos");
        System.out.println("Buscar un "+leyendaUsuario);
        System.out.println("1. Buscar por nombre y apellido");
        System.out.println("2. Buscar por departamento");
        System.out.println("Elija una opción: ");
        i = teclado.nextInt();
        switch (i) {
            case 1:
                System.out.println("Ingrese el nombre del cliente: ");
                nombre = teclado.next();
                System.out.println("Ingrese el apellido del cliente: ");
                apellido = teclado.next();
                resBusqueda = logica.buscar(nombre, apellido);
                break;
            case 2:
                System.out.println("Ingrese el email del cliente: ");
                departamento = teclado.next();
                resBusqueda = logica.buscar(departamento);
            default:
                break;
        }
        
        if(resBusqueda.isEmpty()){
            System.out.println("No se encontraron resultados");
            return null;
        }

        i = 1;
        System.out.println("Se encontraron:");
        for(Almacenable c:resBusqueda){
            System.out.println(i+") "+c+"\n");
        }

        return resBusqueda;
    }
}
