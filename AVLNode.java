public class AVLNode {
    int valor;
    int altura;
    AVLNode izquierda;
    AVLNode derecha;

    public AVLNode(int valor) {
        this.valor = valor;
        this.altura = 1;
    }
}