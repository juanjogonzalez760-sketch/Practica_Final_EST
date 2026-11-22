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
        return ValidarOpcion(sc, 1, 5);
    }

    public int ValidarOpcion(Scanner sc, int minimo, int maximo) {
        int opcion = ValidarEntero(sc);
        if (opcion < minimo || opcion > maximo) {
            System.out.println("Esta opcion no existe. Ingrese un numero entre " + minimo + " y " + maximo + ":");
            return ValidarOpcion(sc, minimo, maximo);
        }
        return opcion;
    }
}
