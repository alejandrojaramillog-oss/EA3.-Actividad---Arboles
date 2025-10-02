// src/Principal.java
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArbolBinario arbol = new ArbolBinario();
        int opcion = 0;

        System.out.println("--- Implementación de Árbol Binario de Búsqueda ---");

        while (opcion != 4) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1.📝 Insertar número");
            System.out.println("2.📖 Mostrar recorrido Inorden");
            System.out.println("3.🔍  Buscar un número");
            System.out.println("4.🚪  Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = scanner.nextInt();
                int numero;

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el número a insertar: ");
                        numero = scanner.nextInt();
                        arbol.insertar(numero);
                        System.out.println("Número " + numero + " insertado.");
                        break;
                    case 2:
                        arbol.recorrerInorden();
                        break;
                    case 3:
                        System.out.print("Ingrese el número a buscar: ");
                        numero = scanner.nextInt();
                        if (arbol.buscar(numero)) {
                            System.out.println("El número " + numero + " SÍ existe en el árbol.");
                        } else {
                            System.out.println("El número " + numero + " NO existe en el árbol.");
                        }
                        break;
                    case 4:
                        System.out.println("Programa finalizado. ¡Adiós!");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese solo números para las opciones y los valores.");
                scanner.next(); // Limpia el buffer del scanner
                opcion = 0;
            }
        }
        scanner.close();
    }
}