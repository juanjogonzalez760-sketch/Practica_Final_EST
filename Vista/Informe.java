package Vista;

import java.util.LinkedList;
import java.util.Locale;
import Modelo.Cliente;
import Modelo.ContratoRenting;
import Modelo.Vehiculo;

public class Informe {
    //metodos de imprimir para clientes, vehiculos y contratos

    public String Imprimir(Cliente c) {
        return "  Cedula: " + c.getCedula() + " | Nombre: " + c.getNombre() + " " + c.getApellido()
                + " | Telefono: " + c.getTelefono()
                + "\n    Direccion: " + c.getDireccion() + " | Licencia: " + c.getLicenciaConduccion();
    }


    public String Imprimir(Vehiculo v) {
        return "  [" + v.getTipo() + "] Placa: " + v.getPlaca() + " | Marca: " + v.getMarca()
                + " | Modelo: " + v.getModelo()
                + "\n    Precio diario: " + moneda(v.getPrecioDiario()) + " | Estado: " + v.getEstado()
                + " | " + v.detalleEspecifico();
    }

    public String Imprimir(ContratoRenting c) {
        String estado = "finalizado";
        if (c.getActivo()) {
            estado = "activo";
        }
        return "  Contrato: " + c.getIdContrato() + " | Estado: " + estado
                + " | Cliente: " + c.getCedulaCliente() + " | Vehiculo: " + c.getPlacaVehiculo()
                + "\n    Desde: " + c.getFechaInicio() + " | Hasta: " + c.getFechaFin()
                + " | Dias: " + c.getTotalDias() + " | Valor total: " + moneda(c.getValorTotal());
    }

    public String InformeGeneral(LinkedList<Cliente> clientes, LinkedList<Vehiculo> vehiculos,
            LinkedList<ContratoRenting> contratos) {
        StringBuilder s = new StringBuilder();
        s.append("\n==================================================");
        s.append("\n           INFORME GENERAL DE RENTING");
        s.append("\n==================================================");

        s.append("\n\nCLIENTES (").append(clientes.size()).append(")");
        s.append("\n--------------------------------------------------");
        for (Cliente c : clientes) {
            s.append("\n").append(Imprimir(c));
        }

        s.append("\n\nVEHICULOS (").append(vehiculos.size()).append(")");
        s.append("\n--------------------------------------------------");
        for (Vehiculo v : vehiculos) {
            s.append("\n").append(Imprimir(v));
        }

        s.append("\n\nCONTRATOS ACTIVOS");
        s.append("\n--------------------------------------------------");
        for (ContratoRenting c : contratos) {
            if (c.getActivo()) {
                s.append("\n").append(Imprimir(c));
            }
        }

        s.append("\n\nCONTRATOS FINALIZADOS");
        s.append("\n--------------------------------------------------");   
        for (ContratoRenting c : contratos) {
                if (!c.getActivo()) {
                    s.append("\n").append(Imprimir(c));
                }
        }

        double total = 0;
        for (ContratoRenting c : contratos) {
            total += c.getValorTotal();
        }
        s.append("\n\n==================================================");
        s.append("\nTOTAL DE INGRESOS POR RENTING: " + moneda(total));
        s.append("\n==================================================");

        return s.toString();
    }

    private static String moneda(double valor) {
        return String.format(Locale.forLanguageTag("es-CO"), "$%,.0f", valor);
    }
}
