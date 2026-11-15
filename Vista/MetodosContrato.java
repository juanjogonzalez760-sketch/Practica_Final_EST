package Vista;

import java.util.LinkedList;
import Modelo.ContratoRenting;
import Modelo.Vehiculo;
import Validaciones.ValidacionesContrato;

public class MetodosContrato {
    ValidacionesContrato v = new ValidacionesContrato();

    public ContratoRenting BuscarContrato(LinkedList<ContratoRenting> contratos, String id) {
        if (!v.TextoValido(id)) {
            return null;
        }
        for (ContratoRenting o : contratos) {
            if (o.getIdContrato().equalsIgnoreCase(id.trim())) {
                return o;
            }
        }
        return null;
    }

    public Vehiculo BuscarVehiculo(LinkedList<Vehiculo> vehiculos, String placa) {
        if (!v.TextoValido(placa)) {
            return null;
        }
        for (Vehiculo o : vehiculos) {
            if (placa.trim().equalsIgnoreCase(o.getPlaca())) {
                return o;
            }
        }
        return null;
    }

    public String RegistrarContrato(LinkedList<ContratoRenting> contratos,
            LinkedList<Vehiculo> vehiculos, String id, String cedula,
            String placa, String inicio, String fin) {
        if (!v.TextoValido(id) || !v.TextoValido(cedula) || !v.TextoValido(placa)) {
            return "El identificador, la cedula y la placa son obligatorios";
        }
        if (BuscarContrato(contratos, id) != null) {
            return "Ya existe un contrato con ese identificador";
        }
        for (ContratoRenting o : contratos) {
            if (o.getActivo() && o.getCedulaCliente().equalsIgnoreCase(cedula.trim())) {
                return "El cliente ya tiene un contrato activo";
            }
            if (o.getActivo() && o.getPlacaVehiculo().equalsIgnoreCase(placa.trim())) {
                return "El vehiculo ya tiene un contrato activo";
            }
        }
        Vehiculo carro = BuscarVehiculo(vehiculos, placa);
        if (carro == null) {
            return "El vehiculo no existe";
        }
        if (!"disponible".equalsIgnoreCase(carro.getEstado())) {
            return "El vehiculo no esta disponible";
        }
        int dias = v.CalcularDias(inicio, fin);
        if (dias == 0) {
            return "Fechas invalidas: el fin debe ser posterior al inicio";
        }
        float precio = carro.getPrecioDiario();
        float total = dias * precio;
        if (precio <= 0 || !Float.isFinite(precio) || total <= 0 || !Float.isFinite(total)) {
            return "El precio o el valor total no es valido";
        }
        ContratoRenting o = new ContratoRenting(id.trim(), cedula.trim(), carro.getPlaca());
        o.setFechaInicio(inicio);
        o.setFechaFin(fin);
        o.setTotalDias(dias);
        o.setValorTotal(total);
        contratos.add(o);
        carro.setEstado("alquilado");
        return "Contrato registrado correctamente";
    }

    public String ModificarContrato(LinkedList<ContratoRenting> contratos,
            String id, String inicio, String fin) {
        ContratoRenting o = BuscarContrato(contratos, id);
        if (o == null) {
            return "El contrato no existe";
        }
        if (!o.getActivo()) {
            return "El contrato ya esta finalizado";
        }
        int dias = v.CalcularDias(inicio, fin);
        if (dias == 0) {
            return "Fechas invalidas: el fin debe ser posterior al inicio";
        }
        if (o.getTotalDias() <= 0) {
            return "La duracion anterior no es valida";
        }

        float tarifa = o.getValorTotal() / o.getTotalDias();
        float total = dias * tarifa;
        if (total <= 0 || !Float.isFinite(total)) {
            return "El valor total no es valido";
        }
        o.setFechaInicio(inicio);
        o.setFechaFin(fin);
        o.setTotalDias(dias);
        o.setValorTotal(total);
        return "Contrato modificado correctamente";
    }

    public String FinalizarContrato(LinkedList<ContratoRenting> contratos,
            LinkedList<Vehiculo> vehiculos, String id) {
        ContratoRenting o = BuscarContrato(contratos, id);
        if (o == null) {
            return "El contrato no existe";
        }
        if (!o.getActivo()) {
            return "El contrato ya esta finalizado";
        }
        Vehiculo carro = BuscarVehiculo(vehiculos, o.getPlacaVehiculo());
        if (carro == null) {
            return "No se puede devolver: el vehiculo no existe";
        }
        o.setActivo(false);
        carro.setEstado("disponible");
        return "Contrato finalizado y vehiculo devuelto correctamente";
    }

    public String ConsultarContrato(LinkedList<ContratoRenting> contratos, String id) {
        ContratoRenting o = BuscarContrato(contratos, id);
        if (o == null) {
            return "El contrato no existe";
        }
        String estado = "finalizado";
        if (o.getActivo()) {
            estado = "activo";
        }
        return "Contrato: " + o.getIdContrato()
                + "\nCedula: " + o.getCedulaCliente()
                + "\nPlaca: " + o.getPlacaVehiculo()
                + "\nInicio: " + o.getFechaInicio()
                + "\nFin: " + o.getFechaFin()
                + "\nDias: " + o.getTotalDias()
                + "\nValor total: " + o.getValorTotal()
                + "\nEstado: " + estado;
    }
}
