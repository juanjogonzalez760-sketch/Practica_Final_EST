package Vista;

import java.util.Iterator;
import java.util.LinkedList;
import Modelo.Cliente;
import Modelo.ContratoRenting;
import Modelo.Vehiculo;

public class MetodosCliente {
    MetodosVehiculo mv = new MetodosVehiculo();

    private boolean Vacio(String dato) {
        return dato == null || dato.trim().isEmpty();
    }

    public Cliente BuscarCliente(LinkedList<Cliente> clientes, String cedula) {
        if (cedula == null || cedula.trim().isEmpty()) {
            return null; // Retorna null si la cedula es nula o vacia
        }
        for (Cliente cliente : clientes) {
            if (cedula.trim().equalsIgnoreCase(cliente.getCedula())) {
                return cliente;
            }
        }
        return null; // Retorna null si no se encuentra el cliente
    }

    public String RegistrarCliente(LinkedList<Cliente> clientes, String cedula, String nombre, String apellido,
            String telefono, String direccion, String licencia) {
        if (Vacio(cedula) || Vacio(nombre) || Vacio(apellido) || Vacio(telefono)
                || Vacio(direccion) || Vacio(licencia)) {
            return "Error: Todos los campos son obligatorios.";
        }

        if (BuscarCliente(clientes, cedula) != null) {
            return "Error: Ya existe un cliente registrado con esa cedula.";
        }

        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setCedula(cedula.trim());
        nuevoCliente.setNombre(nombre.trim());
        nuevoCliente.setApellido(apellido.trim());
        nuevoCliente.setTelefono(telefono.trim());
        nuevoCliente.setDireccion(direccion.trim());
        nuevoCliente.setLicenciaConduccion(licencia.trim());

        clientes.add(nuevoCliente);
        return "Cliente registrado exitosamente.";
    }

    // La cedula no se modifica: es la llave del cliente.
    public String ModificarCliente(LinkedList<Cliente> clientes, String cedula, String nombre, String apellido,
            String telefono, String direccion, String licencia) {
        Cliente cliente = BuscarCliente(clientes, cedula);
        if (cliente == null) {
            return "El cliente no existe";
        }
        if (Vacio(nombre) || Vacio(apellido) || Vacio(telefono) || Vacio(direccion) || Vacio(licencia)) {
            return "Error: Todos los campos son obligatorios.";
        }
        cliente.setNombre(nombre.trim());
        cliente.setApellido(apellido.trim());
        cliente.setTelefono(telefono.trim());
        cliente.setDireccion(direccion.trim());
        cliente.setLicenciaConduccion(licencia.trim());
        return "Cliente modificado correctamente";
    }

    // Sincronizacion: al eliminar un cliente tambien se eliminan sus contratos
    // y los vehiculos de sus contratos activos quedan disponibles.
    public String EliminarCliente(LinkedList<Cliente> clientes, LinkedList<ContratoRenting> contratos,
            LinkedList<Vehiculo> vehiculos, String cedula) {
        Cliente cliente = BuscarCliente(clientes, cedula);
        if (cliente == null) {
            return "El cliente no existe";
        }
        int eliminados = 0;
        Iterator<ContratoRenting> it = contratos.iterator();
        while (it.hasNext()) {
            ContratoRenting o = it.next();
            if (cliente.getCedula().equalsIgnoreCase(o.getCedulaCliente())) {
                if (o.getActivo()) {
                    Vehiculo carro = mv.BuscarVehiculo(vehiculos, o.getPlacaVehiculo());
                    if (carro != null) {
                        carro.setEstado("disponible");
                    }
                }
                it.remove();
                eliminados++;
            }
        }
        clientes.remove(cliente);
        return "Cliente eliminado correctamente. Contratos eliminados: " + eliminados;
    }

    public String ConsultarCliente(LinkedList<Cliente> clientes, String cedula) {
        Cliente cliente = BuscarCliente(clientes, cedula);
        if (cliente == null) {
            return "El cliente no existe";
        }
        return "Cedula: " + cliente.getCedula()
                + "\nNombre: " + cliente.getNombre()
                + "\nApellido: " + cliente.getApellido()
                + "\nTelefono: " + cliente.getTelefono()
                + "\nDireccion: " + cliente.getDireccion()
                + "\nLicencia: " + cliente.getLicenciaConduccion();
    }
}