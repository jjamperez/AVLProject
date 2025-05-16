import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        AVLTree arbol = new AVLTree();
        Scanner sc = new Scanner(System.in);
        System.out.println("Árbol AVL Dinámico - Inserción de números");
        System.out.println("'exit' o '-1' para terminar.");
        while (true) {
            System.out.print("Número > ");
            String in = sc.nextLine().trim();
            if (in.equalsIgnoreCase("exit") || in.equals("-1")) break;
            try {
                arbol.insertar(Integer.parseInt(in));
                System.out.println("Árbol:"); arbol.imprimirArbol();
            } catch (Exception e) {
                System.out.println("Entrada inválida");
            }
        }
        sc.close();
    }
}