package Vista;

import java.util.Iterator;
import java.util.LinkedList;
import Modelo.CamionetaSUV;
import Modelo.CarroSedan;
import Modelo.ContratoRenting;
import Modelo.Vehiculo;

public class MetodosVehiculo {

    private boolean Vacio(String dato) {
        return dato == null || dato.trim().isEmpty();
    }

    public Vehiculo BuscarVehiculo(LinkedList<Vehiculo> vehiculos, String placa) {
        if (Vacio(placa)) {
            return null;
        }
        for (Vehiculo carro : vehiculos) {
            if (placa.trim().equalsIgnoreCase(carro.getPlaca())) {
                return carro;
            }
        }
        return null;
    }

    // Recibe el vehiculo ya armado (CarroSedan o CamionetaSUV): polimorfismo.
    public String RegistrarVehiculo(LinkedList<Vehiculo> vehiculos, Vehiculo nuevo) {
        if (nuevo == null || Vacio(nuevo.getPlaca())) {
            return "Error: El vehiculo no es valido.";
        }
        if (BuscarVehiculo(vehiculos, nuevo.getPlaca()) != null) {
            return "Error: Ya existe un vehiculo con esa placa.";
        }
        vehiculos.add(nuevo);
        return "Vehiculo registrado correctamente";
    }

    // La placa y el estado no se modifican: el estado lo controlan los contratos.
    public String ModificarVehiculo(LinkedList<Vehiculo> vehiculos, String placa, String marca,
            int modelo, float precioDiario) {
        Vehiculo carro = BuscarVehiculo(vehiculos, placa);
        if (carro == null) {
            return "El vehiculo no existe";
        }
        if (Vacio(marca) || modelo <= 0 || precioDiario <= 0 || !Float.isFinite(precioDiario)) {
            return "Error: Marca, modelo y precio deben ser validos.";
        }
        carro.setMarca(marca.trim());
        carro.setModelo(modelo);
        carro.setPrecioDiario(precioDiario);
        return "Vehiculo modificado correctamente";
    }

    // Sincronizacion: al eliminar un vehiculo tambien se eliminan sus contratos.
    public String EliminarVehiculo(LinkedList<Vehiculo> vehiculos, LinkedList<ContratoRenting> contratos,
            String placa) {
        Vehiculo carro = BuscarVehiculo(vehiculos, placa);
        if (carro == null) {
            return "El vehiculo no existe";
        }
        int eliminados = 0;
        Iterator<ContratoRenting> it = contratos.iterator();
        while (it.hasNext()) {
            ContratoRenting o = it.next();
            if (carro.getPlaca().equalsIgnoreCase(o.getPlacaVehiculo())) {
                it.remove();
                eliminados++;
            }
        }
        vehiculos.remove(carro);
        return "Vehiculo eliminado correctamente. Contratos eliminados: " + eliminados;
    }

    public String ConsultarVehiculo(LinkedList<Vehiculo> vehiculos, String placa) {
        Vehiculo carro = BuscarVehiculo(vehiculos, placa);
        if (carro == null) {
            return "El vehiculo no existe";
        }
        String tipo = "Vehiculo";
        String extra = "";
        if (carro instanceof CarroSedan) {
            CarroSedan sedan = (CarroSedan) carro;
            tipo = "Carro Sedan";
            extra = "\nCombustible: " + sedan.getTipoCombustible()
                    + "\nTransmision: " + sedan.getTransmision();
        } else if (carro instanceof CamionetaSUV) {
            CamionetaSUV suv = (CamionetaSUV) carro;
            tipo = "Camioneta SUV";
            extra = "\nTraccion: " + suv.getTraccion()
                    + "\nMaletero (litros): " + suv.getCapacidadMaletero();
        }
        return "Tipo: " + tipo
                + "\nPlaca: " + carro.getPlaca()
                + "\nMarca: " + carro.getMarca()
                + "\nModelo: " + carro.getModelo()
                + "\nPrecio diario: " + carro.getPrecioDiario()
                + "\nEstado: " + carro.getEstado()
                + extra;
    }
}