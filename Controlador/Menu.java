package Controlador;

import java.util.Scanner;
import Vista.MetodosMenu;
import Validaciones.ValidacionesMenu;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MetodosMenu m = new MetodosMenu();
        ValidacionesMenu v = new ValidacionesMenu();
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nSISTEMA DE RENTING DE CARROS");
            System.out.println("1. GESTION DE CLIENTES");
            System.out.println("2. GESTION DE VEHICULOS");
            System.out.println("3. GESTION DE CONTRATOS DE RENTING");
            System.out.println("4. IMPRIMIR INFORME GENERAL");
            System.out.println("5. SALIR DEL SISTEMA");

            switch (v.ValidarOpcion(sc)) {
                case 1:
                    System.out.println(m.MenuClientes(sc));
                    break;
                case 2:
                    System.out.println(m.MenuVehiculos(sc));
                    break;
                case 3:
                    System.out.println(m.MenuContratos(sc));
                    break;
                case 4:
                    System.out.println(m.ImprimirInformeGeneral());
                    break;
                case 5:
                    continuar = false;
                    System.out.println("Hasta luego");
                    break;
            }
        }
    }
}