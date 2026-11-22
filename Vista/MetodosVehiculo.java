package Vista;

import java.util.LinkedList;
import Modelo.CamionetaSUV;
import Modelo.CarroSedan;
import Modelo.ContratoRenting;
import Modelo.Vehiculo;

public class MetodosVehiculo {

    public Vehiculo BuscarVehiculo(LinkedList<Vehiculo> l, String placa) {
        for (Vehiculo o : l) {
            if (o.getPlaca().equalsIgnoreCase(placa)) {
                return o;
            }
        }
        return null;
    }

    public String RegistrarVehiculo(LinkedList<Vehiculo> l, Vehiculo o) {
        if (BuscarVehiculo(l, o.getPlaca()) != null) {
            return "Ya existe un vehiculo con esa placa";
        }
        l.add(o);
        return "Vehiculo registrado";
    }

    public String ModificarVehiculo(LinkedList<Vehiculo> l, String placa, String marca, int modelo,
            float precio) {
        Vehiculo o = BuscarVehiculo(l, placa);
        if (o == null) {
            return "El vehiculo no existe";
        }
        o.setMarca(marca);
        o.setModelo(modelo);
        o.setPrecioDiario(precio);
        return "Vehiculo modificado";
    }

    public String EliminarVehiculo(LinkedList<Vehiculo> l, LinkedList<ContratoRenting> contratos, String placa) {
        Vehiculo o = BuscarVehiculo(l, placa);
        if (o == null) {
            return "El vehiculo no existe";
        }
        int i = 0;
        while (i < contratos.size()) {
            if (contratos.get(i).getPlacaVehiculo().equalsIgnoreCase(placa)) {
                contratos.remove(i);
            } else {
                i++;
            }
        }
        l.remove(o);
        return "Vehiculo eliminado";
    }

    public String ConsultarVehiculo(LinkedList<Vehiculo> l, String placa) {
        Vehiculo o = BuscarVehiculo(l, placa);
        if (o == null) {
            return "El vehiculo no existe";
        }
        String texto = "Tipo: " + o.getTipo() + "\nPlaca: " + o.getPlaca() + "\nMarca: " + o.getMarca() + "\nModelo: " + o.getModelo()
                + "\nPrecio diario: " + o.getPrecioDiario() + "\nEstado: " + o.getEstado();
        if (o instanceof CarroSedan) {
            CarroSedan s = (CarroSedan) o;
            texto = texto + "\nCombustible: " + s.getTipoCombustible() + "\nTransmision: " + s.getTransmision();
        }
        if (o instanceof CamionetaSUV) {
            CamionetaSUV s = (CamionetaSUV) o;
            texto = texto + "\nTraccion: " + s.getTraccion() + "\nMaletero: " + s.getCapacidadMaletero();
        }
        return texto;
    }
}