import java.util.Queue;
import java.util.LinkedList;

public class AVLTree {
    private AVLNode raiz;
    private String ultimaRotacion;

    public void insertar(int valor) {
        ultimaRotacion = "Ninguna";
        raiz = insertarRec(raiz, valor);
    }

    private AVLNode insertarRec(AVLNode nodo, int valor) {
        if (nodo == null) return new AVLNode(valor);
        if (valor < nodo.valor) nodo.izquierda = insertarRec(nodo.izquierda, valor);
        else if (valor > nodo.valor) nodo.derecha = insertarRec(nodo.derecha, valor);
        else return nodo;
        nodo.altura = 1 + Math.max(getAltura(nodo.izquierda), getAltura(nodo.derecha));
        return balancear(nodo);
    }

    private int getAltura(AVLNode nodo) {
        return nodo == null ? 0 : nodo.altura;
    }

    private int getFactorBalance(AVLNode nodo) {
        return getAltura(nodo.izquierda) - getAltura(nodo.derecha);
    }

    private AVLNode balancear(AVLNode nodo) {
        int fb = getFactorBalance(nodo);
        if (fb > 1 && getFactorBalance(nodo.izquierda) >= 0) {
            ultimaRotacion = "Rotación Derecha (LL)";
            return rotarDerecha(nodo);
        }
        if (fb < -1 && getFactorBalance(nodo.derecha) <= 0) {
            ultimaRotacion = "Rotación Izquierda (RR)";
            return rotarIzquierda(nodo);
        }
        if (fb > 1 && getFactorBalance(nodo.izquierda) < 0) {
            ultimaRotacion = "Rotación Izquierda-Derecha (LR)";
            nodo.izquierda = rotarIzquierda(nodo.izquierda);
            return rotarDerecha(nodo);
        }
        if (fb < -1 && getFactorBalance(nodo.derecha) > 0) {
            ultimaRotacion = "Rotación Derecha-Izquierda (RL)";
            nodo.derecha = rotarDerecha(nodo.derecha);
            return rotarIzquierda(nodo);
        }
        return nodo;
    }

    private AVLNode rotarDerecha(AVLNode y) {
        AVLNode x = y.izquierda;
        AVLNode T2 = x.derecha;
        x.derecha = y;
        y.izquierda = T2;
        actualizarAltura(y);
        actualizarAltura(x);
        return x;
    }

    private AVLNode rotarIzquierda(AVLNode x) {
        AVLNode y = x.derecha;
        AVLNode T2 = y.izquierda;
        y.izquierda = x;
        x.derecha = T2;
        actualizarAltura(x);
        actualizarAltura(y);
        return y;
    }

    private void actualizarAltura(AVLNode nodo) {
        nodo.altura = 1 + Math.max(getAltura(nodo.izquierda), getAltura(nodo.derecha));
    }

    public void imprimirArbol() {
        if (raiz == null) {
            System.out.println("Árbol vacío");
            return;
        }
        int altura = getAltura(raiz);
        int ancho = (int)(Math.pow(2, altura + 1) * 1); 
        String[][] grid = new String[altura * 2][ancho];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < ancho; j++) grid[i][j] = " ";
        }
        llenarGrid(grid, raiz, 0, 0, ancho - 1);
        for (String[] fila : grid) {
            for (String s : fila) System.out.print(s);
            System.out.println();
        }
        System.out.println("Factor de Balance (raíz): " + getFactorBalance(raiz));
        System.out.println("Última rotación: " + ultimaRotacion);
    }

    private void llenarGrid(String[][] grid, AVLNode nodo, int nivel, int izq, int der) {
        if (nodo == null) return;
        int medio = (izq + der) / 2;
        String val = String.valueOf(nodo.valor);
        int offset = val.length() / 2;
        for (int i = 0; i < val.length(); i++) {
            grid[nivel * 2][medio - offset + i] = String.valueOf(val.charAt(i));
        }
        if (nodo.izquierda != null) {
            int posConn = (izq + medio) / 2;
            grid[nivel * 2 + 1][posConn] = "/";
            llenarGrid(grid, nodo.izquierda, nivel + 1, izq, medio - 1);
        }
        if (nodo.derecha != null) {
            int posConn = (medio + der) / 2;
            grid[nivel * 2 + 1][posConn] = "\\";
            llenarGrid(grid, nodo.derecha, nivel + 1, medio + 1, der);
        }
    }
}