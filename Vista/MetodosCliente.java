package Vista;

import java.util.LinkedList;
import Modelo.Cliente;
import Modelo.ContratoRenting;
import Modelo.Vehiculo;

public class MetodosCliente {
    MetodosVehiculo mv = new MetodosVehiculo();

    public Cliente BuscarCliente(LinkedList<Cliente> l, String cedula) {
        for (Cliente o : l) {
            if (o.getCedula().equalsIgnoreCase(cedula)) {
                return o;
            }
        }
        return null;
    }

    public String RegistrarCliente(LinkedList<Cliente> l, String cedula, String nombre, String apellido,
            String telefono, String direccion, String licencia) {
        if (BuscarCliente(l, cedula) != null) {
            return "Ya existe un cliente con esa cedula";
        }
        Cliente o = new Cliente();
        o.setCedula(cedula);
        o.setNombre(nombre);
        o.setApellido(apellido);
        o.setTelefono(telefono);
        o.setDireccion(direccion);
        o.setLicenciaConduccion(licencia);
        l.add(o);
        return "Cliente registrado";
    }

    public String ModificarCliente(LinkedList<Cliente> l, String cedula, String nombre, String apellido,
            String telefono, String direccion, String licencia) {
        Cliente o = BuscarCliente(l, cedula);
        if (o == null) {
            return "El cliente no existe";
        }
        o.setNombre(nombre);
        o.setApellido(apellido);
        o.setTelefono(telefono);
        o.setDireccion(direccion);
        o.setLicenciaConduccion(licencia);
        return "Cliente modificado";
    }

    public String EliminarCliente(LinkedList<Cliente> l, LinkedList<ContratoRenting> contratos,
            LinkedList<Vehiculo> vehiculos, String cedula) {
        Cliente o = BuscarCliente(l, cedula);
        if (o == null) {
            return "El cliente no existe";
        }
        int i = 0;
        while (i < contratos.size()) {
            ContratoRenting c = contratos.get(i);
            if (c.getCedulaCliente().equalsIgnoreCase(cedula)) {
                if (c.getActivo()) {
                    Vehiculo v = mv.BuscarVehiculo(vehiculos, c.getPlacaVehiculo());
                    if (v != null) {
                        v.setEstado("disponible");
                    }
                }
                contratos.remove(i);
            } else {
                i++;
            }
        }
        l.remove(o);
        return "Cliente eliminado";
    }

    public String ConsultarCliente(LinkedList<Cliente> l, String cedula) {
        Cliente o = BuscarCliente(l, cedula);
        if (o == null) {
            return "El cliente no existe";
        }
        return "Cedula: " + o.getCedula() + "\nNombre: " + o.getNombre() + "\nApellido: " + o.getApellido()
                + "\nTelefono: " + o.getTelefono() + "\nDireccion: " + o.getDireccion() + "\nLicencia: "
                + o.getLicenciaConduccion();
    }
}