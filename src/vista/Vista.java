package vista;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import logica.Logica;
import persistencia.entidad.Almacenable;
import persistencia.entidad.Cliente;


public abstract class Vista{
    protected Scanner teclado;
    protected Logica logica;
    //Leyenda para Cliente, Empleado, Perro, etc, en singular
    protected String leyendaUsuario;

    /** Imprimir todos los elementos del repositorio */
    public void consultar() throws IOException{
        long i=1;

        if(logica.getRepo().getLista().isEmpty()){
            System.out.println("No existen clientes");
            return;
        }

        for(Almacenable c:logica.getRepo().getLista()){
            System.out.println(i+") "+c);
            i++;
        }
    }

    public abstract void modificar() throws IOException;
    /** Funcion que después de capturar mediante consola los datos
     * retorna una instancia de Cliente*/
    public abstract Cliente capturarUsuario();
    /** Implementacion de busqueda según sus criterios retorna una
     * lista de los elementos que concuerdan con la busqueda */
    public abstract  List<Almacenable> buscar();

    public void agregar() throws IOException {
        Cliente nuevo = capturarUsuario();
        logica.agregar(nuevo);
    }

    public void eliminar() throws IOException{
        int opc;
        List<Almacenable> busqueda = buscar();

        if(busqueda == null){
            return;
        }

        System.out.println("0) Cancelar");
        while(true){
            System.out.println("Ingrese el registro a eliminar: ");
            opc = teclado.nextInt();
            if(opc<0 || opc>busqueda.size()) System.out.println("Opción no válida");
            if(opc==0) return;
            else break;
        }
        
        Almacenable c = busqueda.get(opc-1);
        logica.getRepo().getLista().remove(c);
        logica.getRepo().guardar();
    }

    public void menu() throws IOException {
        int opc;
        do {
            System.out.println("\nBienvenido a los gorditos morenitos");
            System.out.println("Gestion de "+leyendaUsuario);
            System.out.println("1. Agregar "+leyendaUsuario);
            System.out.println("2. Consultar "+leyendaUsuario+"s");
            System.out.println("3. Buscar "+leyendaUsuario);
            System.out.println("4. Modificar "+leyendaUsuario);
            System.out.println("5. Eliminar "+leyendaUsuario);
            System.out.println("6. Menú anterior");
            System.out.println("Elija una opción: ");
            opc = teclado.nextInt();
            switch(opc){
                case 1:
                    agregar();
                    break;
                case 2:
                    consultar();
                    break;
                case 3:
                    buscar();
                    break;
                case 4: 
                    modificar();
                    break;
                case 5:
                    eliminar();
                    break;
            }
        } while (opc != 6);
    }
}
