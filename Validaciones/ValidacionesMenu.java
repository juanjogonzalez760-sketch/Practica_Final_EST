package Validaciones;

import java.util.Scanner;

public class ValidacionesMenu {
    public int ValidarEntero(Scanner sc) {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un numero entero:");
            return ValidarEntero(sc);
        }
    }

    public int ValidarOpcion(Scanner sc) {
        int opcion = ValidarEntero(sc);
        if (opcion < 1 || opcion > 5) {
            System.out.println("Esta opcion no existe. Ingrese un numero entre 1 y 5:");
            return ValidarOpcion(sc);
        }
        return opcion;
    }
}
