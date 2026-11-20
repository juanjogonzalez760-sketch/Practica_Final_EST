package Vista;

import java.util.LinkedList;
import java.util.Scanner;
import Modelo.CamionetaSUV;
import Modelo.CarroSedan;
import Modelo.Cliente;
import Modelo.ContratoRenting;
import Modelo.Vehiculo;
import Validaciones.ValidacionesCliente;
import Validaciones.ValidacionesContrato;
import Validaciones.ValidacionesMenu;
import Validaciones.ValidacionesVehiculo;

public class MetodosMenu {
    ValidacionesMenu v = new ValidacionesMenu();
    ValidacionesCliente vc = new ValidacionesCliente();
    ValidacionesVehiculo vv = new ValidacionesVehiculo();
    ValidacionesContrato vco = new ValidacionesContrato();

    MetodosCliente mc = new MetodosCliente();
    MetodosVehiculo mv = new MetodosVehiculo();
    MetodosContrato mco = new MetodosContrato();

    // HU6: estructuras dinamicas (crecen al agregar y se reducen al eliminar).
    LinkedList<Cliente> clientes = new LinkedList<>();
    LinkedList<Vehiculo> vehiculos = new LinkedList<>();
    LinkedList<ContratoRenting> contratos = new LinkedList<>();

    public String MenuClientes(Scanner sc) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\nGESTION DE CLIENTES");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Modificar cliente");
            System.out.println("3. Eliminar cliente");
            System.out.println("4. Buscar cliente");
            System.out.println("5. Volver al menu principal");

            switch (v.ValidarOpcion(sc)) {
                case 1:
                    System.out.println(RegistrarCliente(sc));
                    break;
                case 2:
                    System.out.println(ModificarCliente(sc));
                    break;
                case 3:
                    System.out.println(EliminarCliente(sc));
                    break;
                case 4:
                    System.out.println(BuscarCliente(sc));
                    break;
                case 5:
                    continuar = false;
                    break;
            }
        }
        return "Regresando al menu principal";
    }

    public String MenuVehiculos(Scanner sc) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\nGESTION DE VEHICULOS");
            System.out.println("1. Registrar vehiculo");
            System.out.println("2. Modificar vehiculo");
            System.out.println("3. Eliminar vehiculo");
            System.out.println("4. Buscar vehiculo");
            System.out.println("5. Volver al menu principal");

            switch (v.ValidarOpcion(sc)) {
                case 1:
                    System.out.println(RegistrarVehiculo(sc));
                    break;
                case 2:
                    System.out.println(ModificarVehiculo(sc));
                    break;
                case 3:
                    System.out.println(EliminarVehiculo(sc));
                    break;
                case 4:
                    System.out.println(BuscarVehiculo(sc));
                    break;
                case 5:
                    continuar = false;
                    break;
            }
        }
        return "Regresando al menu principal";
    }

    public String MenuContratos(Scanner sc) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\nGESTION DE CONTRATOS DE RENTING");
            System.out.println("1. Registrar nuevo contrato");
            System.out.println("2. Modificar contrato");
            System.out.println("3. Finalizar contrato (devolucion)");
            System.out.println("4. Buscar contrato");
            System.out.println("5. Volver al menu principal");

            switch (v.ValidarOpcion(sc)) {
                case 1:
                    System.out.println(RegistrarContrato(sc));
                    break;
                case 2:
                    System.out.println(ModificarContrato(sc));
                    break;
                case 3:
                    System.out.println(FinalizarContrato(sc));
                    break;
                case 4:
                    System.out.println(BuscarContrato(sc));
                    break;
                case 5:
                    continuar = false;
                    break;
            }
        }
        return "Regresando al menu principal";
    }

    // ---------------- Clientes ----------------

    public String RegistrarCliente(Scanner sc) {
        System.out.println("Ingrese la cedula:");
        String cedula = vc.ValidarCedula(sc);
        System.out.println("Ingrese el nombre:");
        String nombre = vc.ValidarNombre(sc);
        System.out.println("Ingrese el apellido:");
        String apellido = vc.ValidarNombre(sc);
        System.out.println("Ingrese el telefono:");
        String telefono = vc.ValidarTelefono(sc);
        System.out.println("Ingrese la direccion:");
        String direccion = vc.ValidarTexto(sc);
        System.out.println("Ingrese la licencia de conduccion:");
        String licencia = vc.ValidarTexto(sc);
        return mc.RegistrarCliente(clientes, cedula, nombre, apellido, telefono, direccion, licencia);
    }

    public String ModificarCliente(Scanner sc) {
        System.out.println("Ingrese la cedula del cliente a modificar:");
        String cedula = vc.ValidarCedula(sc);
        if (mc.BuscarCliente(clientes, cedula) == null) {
            return "El cliente no existe";
        }
        System.out.println("Ingrese el nuevo nombre:");
        String nombre = vc.ValidarNombre(sc);
        System.out.println("Ingrese el nuevo apellido:");
        String apellido = vc.ValidarNombre(sc);
        System.out.println("Ingrese el nuevo telefono:");
        String telefono = vc.ValidarTelefono(sc);
        System.out.println("Ingrese la nueva direccion:");
        String direccion = vc.ValidarTexto(sc);
        System.out.println("Ingrese la nueva licencia de conduccion:");
        String licencia = vc.ValidarTexto(sc);
        return mc.ModificarCliente(clientes, cedula, nombre, apellido, telefono, direccion, licencia);
    }

    public String EliminarCliente(Scanner sc) {
        System.out.println("Ingrese la cedula del cliente a eliminar:");
        String cedula = vc.ValidarCedula(sc);
        return mc.EliminarCliente(clientes, contratos, vehiculos, cedula);
    }

    public String BuscarCliente(Scanner sc) {
        System.out.println("Ingrese la cedula del cliente a buscar:");
        String cedula = vc.ValidarCedula(sc);
        return mc.ConsultarCliente(clientes, cedula);
    }

    // ---------------- Vehiculos ----------------

    public String RegistrarVehiculo(Scanner sc) {
        System.out.println("Tipo de vehiculo: 1. Carro sedan  2. Camioneta SUV");
        int tipo = v.ValidarOpcion(sc);
        if (tipo != 1 && tipo != 2) {
            return "Tipo de vehiculo no valido";
        }
        System.out.println("Ingrese la placa:");
        String placa = vv.ValidarPlaca(sc);
        System.out.println("Ingrese la marca:");
        String marca = vv.ValidarMarca(sc);
        System.out.println("Ingrese el modelo (anio):");
        int modelo = vv.ValidarModelo(sc);
        System.out.println("Ingrese el precio diario:");
        float precio = vv.ValidarPrecioDiario(sc);

        Vehiculo nuevo;
        if (tipo == 1) {
            System.out.println("Ingrese el tipo de combustible (gasolina, diesel o electrico):");
            String combustible = vv.ValidarTipoCombustible(sc);
            System.out.println("Ingrese la transmision (automatica o manual):");
            String transmision = vv.ValidarTransmision(sc);
            CarroSedan sedan = new CarroSedan();
            sedan.setTipoCombustible(combustible);
            sedan.setTransmision(transmision);
            nuevo = sedan;
        } else {
            System.out.println("Ingrese la traccion (4x2 o 4x4):");
            String traccion = vv.ValidarTraccion(sc);
            System.out.println("Ingrese la capacidad del maletero en litros:");
            float maletero = vv.ValidarCapacidadMaletero(sc);
            CamionetaSUV suv = new CamionetaSUV();
            suv.setTraccion(traccion);
            suv.setCapacidadMaletero(maletero);
            nuevo = suv;
        }
        nuevo.setPlaca(placa);
        nuevo.setMarca(marca);
        nuevo.setModelo(modelo);
        nuevo.setPrecioDiario(precio);
        nuevo.setEstado("disponible"); // un vehiculo nuevo siempre queda disponible
        return mv.RegistrarVehiculo(vehiculos, nuevo);
    }

    public String ModificarVehiculo(Scanner sc) {
        System.out.println("Ingrese la placa del vehiculo a modificar:");
        String placa = vv.ValidarPlaca(sc);
        if (mv.BuscarVehiculo(vehiculos, placa) == null) {
            return "El vehiculo no existe";
        }
        System.out.println("Ingrese la nueva marca:");
        String marca = vv.ValidarMarca(sc);
        System.out.println("Ingrese el nuevo modelo (anio):");
        int modelo = vv.ValidarModelo(sc);
        System.out.println("Ingrese el nuevo precio diario:");
        float precio = vv.ValidarPrecioDiario(sc);
        return mv.ModificarVehiculo(vehiculos, placa, marca, modelo, precio);
    }

    public String EliminarVehiculo(Scanner sc) {
        System.out.println("Ingrese la placa del vehiculo a eliminar:");
        String placa = vv.ValidarPlaca(sc);
        return mv.EliminarVehiculo(vehiculos, contratos, placa);
    }

    public String BuscarVehiculo(Scanner sc) {
        System.out.println("Ingrese la placa del vehiculo a buscar:");
        String placa = vv.ValidarPlaca(sc);
        return mv.ConsultarVehiculo(vehiculos, placa);
    }

    // ---------------- Contratos ----------------

    public String RegistrarContrato(Scanner sc) {
        System.out.println("Ingrese el identificador del contrato:");
        String id = vco.ValidarTexto(sc);
        System.out.println("Ingrese la cedula del cliente:");
        String cedula = vc.ValidarCedula(sc);
        if (mc.BuscarCliente(clientes, cedula) == null) {
            return "El cliente no existe: registrelo antes de crear el contrato";
        }
        System.out.println("Ingrese la placa del vehiculo:");
        String placa = vv.ValidarPlaca(sc);
        System.out.println("Ingrese la fecha de inicio (AAAA-MM-DD):");
        String inicio = vco.ValidarFecha(sc);
        System.out.println("Ingrese la fecha de fin (AAAA-MM-DD):");
        String fin = vco.ValidarFecha(sc);
        return mco.RegistrarContrato(contratos, vehiculos, id, cedula, placa, inicio, fin);
    }

    public String ModificarContrato(Scanner sc) {
        System.out.println("Ingrese el identificador del contrato a modificar:");
        String id = vco.ValidarTexto(sc);
        System.out.println("Ingrese la nueva fecha de inicio (AAAA-MM-DD):");
        String inicio = vco.ValidarFecha(sc);
        System.out.println("Ingrese la nueva fecha de fin (AAAA-MM-DD):");
        String fin = vco.ValidarFecha(sc);
        return mco.ModificarContrato(contratos, id, inicio, fin);
    }

    public String FinalizarContrato(Scanner sc) {
        System.out.println("Ingrese el identificador del contrato a finalizar:");
        String id = vco.ValidarTexto(sc);
        return mco.FinalizarContrato(contratos, vehiculos, id);
    }

    public String BuscarContrato(Scanner sc) {
        System.out.println("Ingrese el identificador del contrato a buscar:");
        String id = vco.ValidarTexto(sc);
        return mco.ConsultarContrato(contratos, id);
    }

    public String ImprimirInformeGeneral() {
        return "Informe general: funcionalidad pendiente de conectar.";
    }
}