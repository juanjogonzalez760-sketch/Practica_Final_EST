package Validaciones;

import java.util.Scanner;

public class ValidacionesCliente {

    public String ValidarCedula(Scanner sc) {
        String dato = sc.nextLine().trim();
        boolean valido = !dato.isEmpty();

        for (int i = 0; i < dato.length(); i++) {
            char c = dato.charAt(i);
            if (!Character.isLetter(c) && (c < '0' || c > '9')) {
                valido = false;
            }
        }

        if (!valido) {
            System.out.println("Ingrese la cedula sin espacios ni caracteres especiales:");
            return ValidarCedula(sc);
        }
        return dato;
    }

    public String ValidarNombre(Scanner sc) {
        String dato = sc.nextLine().trim();
        boolean valido = !dato.isEmpty();

        for (int i = 0; i < dato.length(); i++) {
            char c = dato.charAt(i);
            if (!Character.isLetter(c) && c != ' ') {
                valido = false;
            }
        }

        if (!valido) {
            System.out.println("Ingrese solo letras y espacios, sin dejar el campo vacio:");
            return ValidarNombre(sc);
        }
        return dato;
    }

    public String ValidarTelefono(Scanner sc) {
        String dato = sc.nextLine().trim();
        boolean valido = !dato.isEmpty();

        for (int i = 0; i < dato.length(); i++) {
            char c = dato.charAt(i);
            if (c < '0' || c > '9') {
                valido = false;
            }
        }

        if (!valido) {
            System.out.println("Ingrese el telefono solo con numeros:");
            return ValidarTelefono(sc);
        }
        return dato;
    }

    public String ValidarTexto(Scanner sc) {
        String dato = sc.nextLine().trim();
        if (dato.isEmpty()) {
            System.out.println("El campo no puede estar vacio. Ingrese el dato:");
            return ValidarTexto(sc);
        }
        return dato;
    }
}
