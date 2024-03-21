package vista;

import java.io.IOException;
import java.util.Scanner;
import logica.LogicaCliente;

public class Menu{
    Scanner teclado;
    LogicaCliente logicaC;

    public Menu() throws IOException{
        teclado = new Scanner(System.in);
        logicaC = new LogicaCliente();
    }

    public void menuPrincipal(){
        System.out.println("Bienvenido a los gorditos morenitos");
        System.out.println("1. Administrar clientes ");
        System.out.println("2. Administrar empleados ");
        System.out.println("Elija una opción: ");
        int opcion = teclado.nextInt();
        switch (opcion) {
            case 1:
                menuClientes();
                break;

            case 2:

                break;

            default:
                break;
        }
    }

    public void menuClientes(){}
}
