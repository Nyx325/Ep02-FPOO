import java.io.IOException;
import java.util.Scanner;

import vista.VistaCliente;
import vista.VistaEmpleado;

/**@author rubenor*/
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
        VistaCliente vc = new VistaCliente();
        VistaEmpleado ve = new VistaEmpleado();

        int opcion;
        do {
            System.out.println("Bienvenido a los gorditos morenitos");
            System.out.println("1. Administrar clientes ");
            System.out.println("2. Administrar empleados ");
            System.out.println("3. Salir ");
            System.out.println("Elija una opción: ");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    vc.menu();
                    break;
                case 2:
                    ve.menu();
                    break;
                case 3: 
                    return;
                default:
                    break;
            }
        } while (opcion != 3);

        teclado.close();
    }
}
