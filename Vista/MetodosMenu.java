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
    Informe inf = new Informe();
    
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
                    System.out.println(RegistrarCliente());
                    break;
                case 2:
                    System.out.println(ModificarCliente());
                    break;
                case 3:
                    System.out.println(EliminarCliente());
                    break;
                case 4:
                    System.out.println(BuscarCliente());
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
                    System.out.println(RegistrarVehiculo());
                    break;
                case 2:
                    System.out.println(ModificarVehiculo());
                    break;
                case 3:
                    System.out.println(EliminarVehiculo());
                    break;
                case 4:
                    System.out.println(BuscarVehiculo());
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
                    System.out.println(RegistrarContrato());
                    break;
                case 2:
                    System.out.println(ModificarContrato());
                    break;
                case 3:
                    System.out.println(FinalizarContrato());
                    break;
                case 4:
                    System.out.println(BuscarContrato());
                    break;
                case 5:
                    continuar = false;
                    break;
            }
        }
        return "Regresando al menu principal";
    }



    public String RegistrarCliente() {
        return "Registrar cliente: funcionalidad pendiente de conectar.";
    }

    public String ModificarCliente() {
        return "Modificar cliente: funcionalidad pendiente de conectar.";
    }

    public String EliminarCliente() {
        return "Eliminar cliente: funcionalidad pendiente de conectar.";
    }

    public String BuscarCliente() {
        return "Buscar cliente: funcionalidad pendiente de conectar.";
    }

    public String RegistrarVehiculo() {
        return "Registrar vehiculo: funcionalidad pendiente de conectar.";
    }

    public String ModificarVehiculo() {
        return "Modificar vehiculo: funcionalidad pendiente de conectar.";
    }

    public String EliminarVehiculo() {
        return "Eliminar vehiculo: funcionalidad pendiente de conectar.";
    }

    public String BuscarVehiculo() {
        return "Buscar vehiculo: funcionalidad pendiente de conectar.";
    }

    public String RegistrarContrato() {
        return "Registrar nuevo contrato: funcionalidad pendiente de conectar.";
    }

    public String ModificarContrato() {
        return "Modificar contrato: funcionalidad pendiente de conectar.";
    }

    public String FinalizarContrato() {
        return "Finalizar contrato (devolucion): funcionalidad pendiente de conectar.";
    }

    public String BuscarContrato() {
        return "Buscar contrato: funcionalidad pendiente de conectar.";
    }

    public String ImprimirInformeGeneral() {
        return inf.InformeGeneral(clientes, vehiculos, contratos);
    }
}
