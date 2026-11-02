package HU1;
public class Menu {
    /**
     Metodo principal que inicia el sistema de gestión de clientes, vehículos y contratos.
     Aqui vamos a tener un menú principal que permitirá al usuario elegir
     entre gestionar clientes, vehículos, contratos o imprimir un informe general.
     */
    public static void main(String[] args) {

        Sistema sistema = new Sistema(); //Conecta el menú principal con los metodos.

        int opcion;
        do {
            System.out.println("\n=== SISTEMA DE RENTING DE CARROS ===");
            System.out.println("1. Gestionar Clientes");
            System.out.println("2. Gestionar Vehículos");
            System.out.println("3. Gestionar Contratos");
            System.out.println("4. Imprimir Informe General");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Validaciones.leerEntero("Seleccione una opción: (1-5)", 1, 5);

            switch (opcion) {
                case 1:
                    sistema.gestionarClientes();
                    break;
                case 2:
                    sistema.gestionarVehiculos();
                    break;
                case 3:
                    sistema.gestionarContratos();
                    break;
                case 4:
                    sistema.imprimirInforme();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...¡Hasta luego!");
                    break;
            }
        } while (opcion != 5);
    }
}
