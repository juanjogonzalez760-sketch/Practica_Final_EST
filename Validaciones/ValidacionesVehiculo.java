package Validaciones;

import java.util.Scanner;

public class ValidacionesVehiculo {

    public String ValidarPlaca(Scanner sc) {
        String dato = sc.nextLine().trim();
        boolean valido = !dato.isEmpty();
        for (int i = 0; i < dato.length(); i++) {
            char c = dato.charAt(i);
            if (!Character.isLetter(c) && (c < '0' || c > '9')) {
                valido = false;
            }
        }
        if (!valido) {
            System.out.println("Ingrese la placa sin espacios ni caracteres especiales:");
            return ValidarPlaca(sc);
        }
        return dato;
    }

    public String ValidarMarca(Scanner sc) {
        String dato = sc.nextLine().trim();
        boolean valido = !dato.isEmpty();
        for (int i = 0; i < dato.length(); i++) {
            char c = dato.charAt(i);
            if (!Character.isLetter(c) && c != ' ') {
                valido = false;
            }
        }
        if (!valido) {
            System.out.println("Ingrese la marca solo con letras y espacios:");
            return ValidarMarca(sc);
        }
        return dato;
    }

    public int ValidarModelo(Scanner sc) {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un numero entero para el modelo:");
            return ValidarModelo(sc);
        }
    }

    public float ValidarPrecioDiario(Scanner sc) {
        try {
            float dato = Float.parseFloat(sc.nextLine().trim());
            if (dato <= 0 || Float.isNaN(dato) || Float.isInfinite(dato)) {
                System.out.println("Ingrese un precio diario positivo y finito:");
                return ValidarPrecioDiario(sc);
            }
            return dato;
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un precio numerico. Use punto para decimales:");
            return ValidarPrecioDiario(sc);
        }
    }

    public String ValidarEstado(Scanner sc) {
        String dato = sc.nextLine().trim();
        if (dato.equalsIgnoreCase("disponible")) {
            return "disponible";
        }
        if (dato.equalsIgnoreCase("alquilado")) {
            return "alquilado";
        }
        System.out.println("Ingrese disponible o alquilado:");
        return ValidarEstado(sc);
    }

    public String ValidarTipoCombustible(Scanner sc) {
        String dato = sc.nextLine().trim();
        if (dato.equalsIgnoreCase("gasolina")) {
            return "gasolina";
        }
        if (dato.equalsIgnoreCase("diésel") || dato.equalsIgnoreCase("diesel")) {
            return "diésel";
        }
        if (dato.equalsIgnoreCase("eléctrico") || dato.equalsIgnoreCase("electrico")) {
            return "eléctrico";
        }
        System.out.println("Ingrese gasolina, diésel o eléctrico:");
        return ValidarTipoCombustible(sc);
    }

    public String ValidarTransmision(Scanner sc) {
        String dato = sc.nextLine().trim();
        if (dato.equalsIgnoreCase("automática") || dato.equalsIgnoreCase("automatica")) {
            return "automática";
        }
        if (dato.equalsIgnoreCase("manual")) {
            return "manual";
        }
        System.out.println("Ingrese automática o manual:");
        return ValidarTransmision(sc);
    }

    public String ValidarTraccion(Scanner sc) {
        String dato = sc.nextLine().trim();
        if (dato.equalsIgnoreCase("4x2")) {
            return "4x2";
        }
        if (dato.equalsIgnoreCase("4x4")) {
            return "4x4";
        }
        System.out.println("Ingrese 4x2 o 4x4:");
        return ValidarTraccion(sc);
    }

    public float ValidarCapacidadMaletero(Scanner sc) {
        try {
            float dato = Float.parseFloat(sc.nextLine().trim());
            if (dato <= 0 || Float.isNaN(dato) || Float.isInfinite(dato)) {
                System.out.println("Ingrese una capacidad positiva y finita en litros:");
                return ValidarCapacidadMaletero(sc);
            }
            return dato;
        } catch (NumberFormatException e) {
            System.out.println("Ingrese una capacidad numerica. Use punto para decimales:");
            return ValidarCapacidadMaletero(sc);
        }
    }
}
