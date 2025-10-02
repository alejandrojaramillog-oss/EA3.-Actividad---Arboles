// src/ArbolBinario.java
public class ArbolBinario {
    Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    // --- 1. INSERTAR ---
    // Método público para iniciar la inserción
    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    // Método recursivo privado que realiza la inserción
    private Nodo insertarRecursivo(Nodo actual, int valor) {
        if (actual == null) {
            return new Nodo(valor);
        }

        if (valor < actual.valor) {
            actual.izquierda = insertarRecursivo(actual.izquierda, valor);
        } else if (valor > actual.valor) {
            actual.derecha = insertarRecursivo(actual.derecha, valor);
        }
        // Si el valor es igual, no se inserta (árbol de búsqueda binaria)
        return actual;
    }

    // --- 2. RECORRIDO INORDEN ---
    // Recorre: Izquierda -> Raíz -> Derecha (imprime los números ordenados)
    public void recorrerInorden() {
        System.out.print("Recorrido Inorden: ");
        recorrerInordenRecursivo(raiz);
        System.out.println();
    }

    private void recorrerInordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            recorrerInordenRecursivo(nodo.izquierda);
            System.out.print(nodo.valor + " ");
            recorrerInordenRecursivo(nodo.derecha);
        }
    }

    // --- 3. BUSCAR ---
    // Método público para iniciar la búsqueda
    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    // Método recursivo privado que realiza la búsqueda
    private boolean buscarRecursivo(Nodo actual, int valor) {
        if (actual == null) {
            return false;
        }
        if (valor == actual.valor) {
            return true;
        }
        return valor < actual.valor
          ? buscarRecursivo(actual.izquierda, valor)
          : buscarRecursivo(actual.derecha, valor);
    }
}