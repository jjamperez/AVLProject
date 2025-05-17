Árbol AVL Dinámico

Descripción: Programa en Java que permite al usuario insertar números en un árbol AVL de forma dinámica, auto-balanceándose tras cada inserción y mostrando la estructura en consola.

📝 Descripción del problema

El proyecto resuelve la necesidad de mantener un árbol de búsqueda balanceado (AVL) durante inserciones sucesivas. Garantiza complejidad O(log n) en búsquedas, inserciones y eliminaciones gracias a rotaciones que equilibran el árbol automáticamente.

🏗️ Estructura de clases

A continuación se describe la responsabilidad de cada clase del proyecto:

Node (AVLNode.java):

Representa un nodo del árbol AVL.

Atributos:

valor: clave numérica almacenada en el nodo.

altura: altura del subárbol con raíz en este nodo.

izquierda, derecha: referencias a los hijos izquierdo y derecho.

Constructor que inicializa valor y fija altura en 1.

AVLTree (AVLTree.java):

Implementa la lógica de un árbol AVL balanceado.

Responsabilidades principales:

Inserción recursiva de nodos con rebalanceo automático.

Cálculo de altura y factor de balance para cada nodo.

Rotaciones LL, RR, LR y RL para mantener el árbol equilibrado.

Generación de una representación ASCII en consola (imprimirArbol).

Registro de la última rotación realizada.

Main (Main.java):

Interfaz de línea de comandos.

Lee la entrada del usuario en un bucle, solicita números enteros.

Invoca métodos de AVLTree para insertar y mostrar el árbol.

Permite finalizar la ejecución con exit o -1.

EJEMPLOS VISAULES:
Entradas: 50 30 70 20 40 60 80
![image](https://github.com/user-attachments/assets/eedb44b4-11eb-4967-95db-a612a28f90d9)

Salida:
![image](https://github.com/user-attachments/assets/dafe50e2-36ed-4cc0-82dd-164489e1900a)

🚀 Instrucciones de ejecución

Clonar o descargar el repositorio.

Abrir la carpeta del proyecto en VS Code (o tu IDE favorito).

Compilar desde la terminal:

javac *.java

Ejecutar el programa:

java Main

Insertar números uno por uno en el prompt Número >.

Finalizar con exit o -1.

VIDEO EN YOUTUBE
https://youtu.be/4W19qe6trWw
