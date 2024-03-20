package vista;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import logica.LogicaCliente;
import persistencia.entidad.Almacenable;
import persistencia.entidad.Cliente;

public class VistaCliente {

    private Scanner scanner;
    private LogicaCliente logicaCliente;

    public VistaCliente() throws IOException{
        scanner = new Scanner(System.in);
            scanner.useDelimiter("\\n");
            logicaCliente = new LogicaCliente();
    }

    public void crearMenuOpciones() {
        System.out.println("Menu de opciones de Cliente");
        System.out.println("1. Insertar Cliente");
        System.out.println("2. Actualizar Cliente");
        System.out.println("3. Eliminar Cliente");

        System.out.println("Opcion: ");

        int opcion = scanner.nextInt();
        switch(opcion) {
            case 1:
                menuInsertarCliente();
                break;
            case 2:
                menuActualizarCliente();
                break;
            case 3:
                menuEliminarCliente();
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }

    private void menuInsertarCliente(){
        System.out.println("Ingrese el nombre del cliente: ");
        String nombre = scanner.next();
        System.out.println("Ingrese el apellido del cliente: ");
        String apellido = scanner.next();
        System.out.println("Ingrese el telefono del cliente: ");
        String telefono = scanner.next();
        System.out.println("Ingrese el email del cliente: ");
        String email = scanner.next();

        logicaCliente.agregarCliente(new Cliente(nombre, apellido, telefono, email));
    }

    private void menuActualizarCliente(){
        /* Se necesita una funcion de busqueda(?) */
        
    }

    private void menuEliminarCliente(){
        System.out.println("Ingresa el nombre del cliente: ");
        String nombre = scanner.next();
        System.out.println("Ingresa el apellido del cliente: ");
        String apellidos = scanner.next();
        
        System.out.println("Elije el cliente a eliminar");
        long i = 1;
        List<Almacenable> busqueda = logicaCliente.buscarClientes(nombre, apellidos);
        for (Almacenable cliente : busqueda) {
            System.out.println(i+") "+cliente);
        }
        
    }

}
