package Validaciones;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class ValidacionesContrato {
    public boolean TextoValido(String dato) {
        return dato != null && !dato.trim().isEmpty();
    }

    public boolean FechaValida(String dato) {
        if (!TextoValido(dato)) {
            return false;
        }
        try {
            LocalDate fecha = LocalDate.parse(dato);
            return dato.length() == 10 && fecha.getYear() >= 1;
        } catch (DateTimeParseException e) {
            return false;
        }
    }


    public int CalcularDias(String inicio, String fin) {
        if (!FechaValida(inicio) || !FechaValida(fin)) {
            return 0;
        }
        long dias = ChronoUnit.DAYS.between(LocalDate.parse(inicio), LocalDate.parse(fin));
        if (dias <= 0 || dias > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) dias;
    }

    public String ValidarTexto(Scanner sc) {
        String dato = sc.nextLine().trim();
        if (!TextoValido(dato)) {
            System.out.println("Ingrese un dato que no este vacio:");
            return ValidarTexto(sc);
        }
        return dato;
    }

    public String ValidarFecha(Scanner sc) {
        String dato = sc.nextLine().trim();
        if (!FechaValida(dato)) {
            System.out.println("Ingrese una fecha real con formato AAAA-MM-DD:");
            return ValidarFecha(sc);
        }
        return dato;
    }
    
        public String ValidarFechaFin(Scanner sc, String inicio) {
        String fin = ValidarFecha(sc);
        if (CalcularDias(inicio, fin) == 0) {
            System.out.println("La fecha final debe ser posterior a " + inicio + ". Ingrese otra fecha:");
            return ValidarFechaFin(sc, inicio);
        }
        return fin;
    }
}
