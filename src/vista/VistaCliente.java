package vista;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

import logica.LogicaCliente;
import persistencia.entidad.Almacenable;
import persistencia.entidad.Cliente;

public class VistaCliente extends Vista{
    public VistaCliente() throws IOException{
        teclado = new Scanner(System.in);
        logica = new LogicaCliente();
        leyendaUsuario = "cliente";
    }

    // Captura los datos por consola para crear un 
    // cliente nuevo y retorna este objeto
    @Override
    public Cliente capturarUsuario(){
        String nombre, apellidos, telefono, email;

        System.out.println("Ingresa el nombre: ");
        nombre = teclado.next();
        System.out.println("Ingresa los apellidos: ");
        apellidos = teclado.next();
        System.out.println("Ingresa el telefono: ");
        telefono = teclado.next();
        System.out.println("Ingresa el email: ");
        email = teclado.next();

        /* Es lo mismo que:
         * Cliente c = new Cliente();
         * return c;
         */
        return new Cliente(nombre, apellidos, telefono, email);
    }

    // Funcion que te permite elegir la funcion de búsqueda de 
    // lógica queremos elegir, y captura los datos necesarios
    // que necesita la funcion
    @Override
    public List<Almacenable> buscar(){
        int i = 0;
        String nombre, apellido, email;
        List<Almacenable> resBusqueda = new ArrayList<>();

        System.out.println("\nBienvenido a los gorditos morenitos");
        System.out.println("Buscar un cliente");
        System.out.println("1. Buscar por nombre y apellido");
        System.out.println("2. Buscar por email");
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
                email = teclado.next();
                resBusqueda = logica.buscar(email);
            default:
                break;
        }
        
        if(resBusqueda.isEmpty()){
            System.out.println("No se encontraron resultados");
            return null;
        }


        // Mostramos los resultados
        i = 1;
        System.out.println("Se encontraron:");
        for(Almacenable c:resBusqueda){
            System.out.println(i+") "+c+"\n");
            i++;
        }

        // Y retornamos la lista de busqueda, es una mausquerramienta
        // misteriosa que usaremos más tarde
        return resBusqueda;
    }

    @Override
    public void modificar() throws IOException {
        int opc;
        // Reutilizar la funcion de busqueda
        List<Almacenable> busqueda = buscar();

        if(busqueda == null){
            return;
        }

        //Dar a elegir cuál de los resultados quiere
        System.out.println("0) Cancelar");
        while(true){
            System.out.println("Ingrese el cliente a modificar: ");
            opc = teclado.nextInt();
            System.out.println(busqueda.size());
            if(opc<0 || opc>busqueda.size()) System.out.println("Opción no válida");
            if(opc==0) return;
            else break;
        }
        
        // Tomamos la referencia al objeto que queremos modificar
        String input;
        Cliente c = (Cliente) busqueda.get(opc-1);
        
        // Sobreescribimo
        do{
            System.out.println("\nIngresa el campo a modificar");
            System.out.println("0) Salir");
            System.out.println("1) Nombre");
            System.out.println("2) Apellido");
            System.out.println("3) Telefono");
            System.out.println("4) Email");
            opc = teclado.nextInt();

            switch (opc) {
                case 0:
                    return;
                case 1:
                    System.out.println("Ingresa el nuevo nombre: ");
                    input = teclado.next();
                    c.setNombre(input);
                    break;
                case 2:
                    System.out.println("Ingresa los nuevos apellidos: ");
                    input = teclado.next();
                    c.setApellidos(input);
                    break;
                case 3:
                    System.out.println("Ingresa el nuevo teléfono: ");
                    input = teclado.next();
                    c.setTelefono(input);
                    break;
                case 4:
                    System.out.println("Ingresa el nuevo email: ");
                    input = teclado.next();
                    c.setEmail(input);
                    break;
                default:
                    break;
            }
        }while(opc != 0);
        // Actualizamos el csv
        logica.getRepo().guardar();
    }
}
