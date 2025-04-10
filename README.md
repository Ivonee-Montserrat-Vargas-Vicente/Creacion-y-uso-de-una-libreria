# Creacion-y-uso-de-una-libreria-

    Instrucciones Generales:
Desarrollar una librería en Java que contenga métodos abstractos. Esta librería deberá ser funcional, clara y reutilizable.
El objetivo es aplicar principios de programación orientada a objetos, crear un archivo .jar, documentarlo correctamente y demostrar su uso en otro proyecto.


---A continuacion breve descripción de la librería y su propósito:---


     DESCRIPCION: 
Lenguaje: Java
Entorno: NetBeans (exportable a JAR)
 
    PROPOSITO:
Esta librería proporciona una colección de algoritmos de ordenamiento implementados en Java, que permiten:
*  Ordenar arrays de cualquier tipo de dato que implemente Comparable (números, strings,nbjetos).
*  Incluye métodos de ordenamiento como Burbuja, Selección, Inserción, Montículos y Shell Sort.
*  Funciona tanto en proyectos de consola como en interfaces gráficas (como el JFrame que se desarrollo aqui mismo y que veremos a continuacion).

 ## Estructura de la Librería

 | Método          | Tipo       | Descripción                              | Parametros             | Retorno | 
 |-----------------|------------|------------------------------------------|------------------------|---------|
 | `burbuja`       | `static`   | Ordenamiento clásico por intercambio     |T[] arreglo (genérico)  |void     |
 | `seleccion`     | `static`   | Selecciona el menor en cada iteración    |T[] arreglo (genérico)  |void     |
 | `insercion`     | `static`   | Inserta elementos en posición correcta   |T[] arreglo (genérico)  |void     |
 | `monticulos`    | `static`   | Usa un heap para ordenar                 |T[] arreglo (genérico)  |void     |
 | `shell`         | `static`   | Mejora del insertion sort con gaps       |T[] arreglo (genérico)  |void     |
 | `intercambiar`  | `private`  | Función auxiliar para swaps              |T[] arreglo, int i, int j|void     |
 |`heapify`        |`private`   |Función auxiliar para Heap Sort (construye/mantiene el montículo)|T[] arreglo, int n, int i|void|
 |`imprimirArreglo`|`static`    |Imprime los elementos de un arreglo (para depuración)|T[] arreglo (genérico)|void|

## Estructura Detallada

| Componente        | Tipo       | Parámetros                     | Retorno | 
|-------------------|------------|--------------------------------|---------|
| `burbuja(T[])`    | `static`   | `T[] arreglo` (genérico)       | `void`  | 
| `seleccion(T[])`  | `static`   | `T[] arreglo`                  | `void`  |
| `heapify(T[], int, int)` | `private` | `T[] arreglo`, `n`, `i`        | `void`  | 


###  Métodos Privados
- `intercambiar()`: Intercambia dos elementos
  ```java
  private void intercambiar(T[] arr, int i, int j)

##   Especificaciones Técnicas Adicionales

|Característica	|        Detalle     |
|-------------------|--------------------|
|Tipo Genérico	     |<T extends Comparable<T>> (Acepta cualquier objeto que implemente Comparable)|
|Manejo de Errores	|Validación implícita mediante compareTo (no acepta null)|
|Uso en JFrame	     |Conversión de String a Integer[] con manejo de excepciones|

##  Ejemplo de Uso

###  Ordenamiento Básico
1. **Crear un arreglo desordenado**:
   ```java
   Integer[] numeros = {10, 5, 8, 1, 7};
        Ordenar con Burbuja:
   LibreriaOrdenamiento.burbuja(numeros);
       Imprimir resultado:
   LibreriaOrdenamiento.imprimirArreglo(numeros);
       Salida:
   1 5 7 8 10
### Ordenamiento con Heap Sort:
1. **Usando palabras**:
   ```java
   String[] palabras = {"zapato", "árbol", "banana"};
   LibreriaOrdenamiento.monticulos(palabras);
   LibreriaOrdenamiento.imprimirArreglo(palabras);
        salida:
   árbol banana zapato  

  ### Explicación del código (clases, métodos, variables, validaciones)

1) Creamos un nuevo proyecto del tipo Java Class Library con el nombre **LibreriaOrdenamiento**
2) ![Captura de pantalla 2025-04-08 164727](https://github.com/user-attachments/assets/2b33dbc2-3593-4c75-98b9-f9ffd5dc864d)

3) dentro de la libreria contiene todos los algoritmos de ordenamiento implementados como métodos **estáticos** y **genéricos** cuando decimos genéricos se refiere a que (<T>): Usa <T extends Comparable<T>> para garantizar que los elementos sean comparables (por ejemplo pueden ser Integer, String, etc.). e inicamos con los metodos de ordenamiento.
   
   ### ORDENAMIENTO POR METODO BURBUJA:
   ```java
   public static <T extends Comparable<T>> void burbuja(T[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arreglo[j].compareTo(arreglo[j + 1]) > 0) {
                    intercambiar(arreglo, j, j + 1);
                }
            }
        }
    }
   
1) En la primer linea de codigo
  **<T extends Comparable<T>>:**
   Lo que hace es que acepta un arreglo de cualquier tipo T que pueda ser comparado (ejemplo: Integer, String) esto hace que los elementos se compararen entre sí
   T[] arreglo: es el arreglo que le vamos a pasar 
2) En la linea siguiente n almacena el número de elementos en el arreglo si por ejemplo tenemos = [5, 2, 9], entonces n = 3 tambien contamos con un bucle el cual es
 **(for (int i = 0; i < n - 1; i++)):** se ejecuta n - 1 veces
 (ejemplo: para 3 elementos, hace 2 pasadas) y con el otro bucle interno **(for (int j = 0; j < n - i - 1; j++)):** compara elementos cada que pasa.
 lo que hace n - i - 1 es que reduce el rango en cada iteración.
3) En las siguientes lineas hace una Comparación
  **(if (arreglo[j].compareTo(arreglo[j + 1]) > 0)):** aqui se usa compareTo() para verificar si el elemento actual (arreglo[j]) es mayor que el siguiente (arreglo[j + 1]) en dado caso que si lo que hace compareTo() es retornar > 0, significa que arreglo[j] es mayor y finaliza.
   
   ### METODO DE ORDENAMIENTO POR SELECCION :
    ```java
    public static <T extends Comparable<T>> void seleccion(T[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arreglo[j].compareTo(arreglo[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            intercambiar(arreglo, i, minIndex);
        }
    }

Este otro método es el de ordenamiento por selección, que funciona dividiendo el arreglo en dos partes una parte ordenada al inicio y una parte sin ordenar (el resto) en cada iteración, encuentra el elemento más pequeño de la parte sin ordenar y lo coloca al final de la parte ordenada.

1) **int n = arreglo.length; n:** Tamaño del arreglo hace que recorre el arreglo desde la posición 0 hasta n-1
2) **for (int i = 0; i < n - 1; i++)
    {   int minIndex = i;**
 Suponemos que el elemento más pequeño está en la posición i (inicialmente 0).
3) **i:** marca el inicio de la parte no ordenada.
4) **for (int j = i + 1; j < n; j++) { --j:**
   Recorre la parte no ordenada (desde i+1 hasta n-1).
5) **if (arreglo[j].compareTo(arreglo[minIndex]) < 0)**
6) **compareTo:** Compara el elemento actual con el mínimo actual.
7) **minIndex = j }}**
  si arreglo[j] es menor, actualiza minIndex = j.
8) **intercambiar(arreglo, i, minIndex);**
 intercambiar: Coloca el elemento más pequeño encontrado (arreglo[minIndex]) en su posición correcta (i).
 El elemento en i ahora está ordenado la parte ordenada crece de izquierda a derecha y finaliza.

   ### METODO DE ORDENAMIENTO DE INSERCION:
   ```java
   public static <T extends Comparable<T>> void insercion(T[] arreglo) {
        int n = arreglo.length;
        for (int i = 1; i < n; i++) {
            T clave = arreglo[i];
            int j = i - 1;
            while (j >= 0 && arreglo[j].compareTo(clave) > 0) {
                arreglo[j + 1] = arreglo[j];
                j--;
            }
            arreglo[j + 1] = clave;
        }
    }

1) Este método implementa el algoritmo de ordenamiento por inserción, que funciona construyendo una secuencia ordenada de elementos uno por uno
2) **int n = arreglo.length;** Obtiene la longitud del arreglo para iterar sobre él.
3) **for (int i = 1; i < n; i++) {**
   Inicia en i = 1: porque el primer elemento se considera ya "ordenado" al inicio.
   Recorre hasta i < n: Para procesar todos los elementos del arreglo.
4) **T clave = arreglo[i];**
   clave: Es el elemento actual que se insertará en su posición correcta dentro de la parte ya ordenada del arreglo a la izquierda de i.
5) **int j = i - 1;
while (j >= 0 && arreglo[j].compareTo(clave) > 0) {**
 la condición while: j >= 0: Evita índices negativos el arreglo[j].compareTo(clave) > 0: Mueve los elementos mayores una posición a la derecha.
 arreglo[j + 1] = arreglo[j];
 j--;}
 j = i - 1: Comienza comparando con el elemento anterior a clave.
6) **arreglo[j + 1] = arreglo[j];** Desplaza el elemento mayor
   **j--;**  Retrocede para comparar con el siguiente elemento a la izquierda
7) **arreglo[j + 1] = clave;**
Cuando el while termina, j + 1 es la posición donde clave debe insertarse (ya no hay elementos mayores a su izquierda y finaliza)

   ### METODO DE ORDENAMIENTO MONTICULO:
    ```java
    public static <T extends Comparable<T>> void monticulos(T[] arreglo) {
        int n = arreglo.length;

        
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arreglo, n, i);
        }

        
        for (int i = n - 1; i > 0; i--) {
            intercambiar(arreglo, 0, i);
            heapify(arreglo, i, 0);
        }
    }

    private static <T extends Comparable<T>> void heapify(T[] arreglo, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arreglo[left].compareTo(arreglo[largest]) > 0) {
            largest = left;
        }

        if (right < n && arreglo[right].compareTo(arreglo[largest]) > 0) {
            largest = right;
        }

        if (largest != i) {
            intercambiar(arreglo, i, largest);
            heapify(arreglo, n, largest);
        }
    }

1) El Heap Sort conocido tambien como ordenamiento por montículos es un algoritmo de ordenamiento eficiente que utiliza una estructura de datos llamada heap (montículo)
2) **for (int i = n / 2 - 1; i >= 0; i--) {
    heapify(arreglo, n, i);}**
   Convertiete el arreglo en un montículo máximo (donde el valor de cada nodo padre es mayor o igual que el de sus hijos).
**i = n / 2 - 1**  Los nodos desde n/2 - 1 hasta 0 son nodos no hoja (los últimos padres en el árbol).
**Ejemplo:Si n = 6** empezamos en i = 2 (tercer nodo).
Para cada nodo padre, se llama a **heapify** para asegurar que sea mayor que sus hijos.
3) **for (int i = n - 1; i > 0; i--) {
    intercambiar(arreglo, 0, i);
    heapify(arreglo, i, 0);
}**
Intercambio: Mueve el elemento raíz (máximo) al final del arreglo (posición i).
Ejemplo: Si el arreglo es [10, 5, 3, ...], intercambia 10 con el último elemento.
Reducción del heap: **heapify(arreglo, i, 0):** Reconstruye el heap con los elementos restantes (i disminuye en cada iteración).
Resultado:Los elementos máximos se colocan al final uno por uno, dejando el arreglo ordenado.

### Explicación del Método heapify
        
        private static <T extends Comparable<T>> void heapify(T[] arreglo, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arreglo[left].compareTo(arreglo[largest]) > 0) {
            largest = left;
        }

        if (right < n && arreglo[right].compareTo(arreglo[largest]) > 0) {
            largest = right;
        }

        if (largest != i) {
            intercambiar(arreglo, i, largest);
            heapify(arreglo, n, largest);
        }
    }

**arreglo:** Arreglo a ordenar.
**n:** Tamaño del heap actual (puede ser menor que el arreglo original).
**i:** Nodo padre actual.Encontrar el "mayor" entre padre e hijos:

Calcula los índices de los hijos izquierdo **(2*i + 1)** y derecho **(2*i + 2)**.
Si un hijo es mayor que el padre, actualiza largest.
**Intercambio y recursión:** Si el mayor no es el padre **(largest != i)** , intercambia los valores.
Llama a heapify recursivamente en el subárbol afectado (para mantener la propiedad del heap).

         EJEMPLO:
1) Arreglo inicial: **[3, 8, 2, 10, 5]**
2) Construir heap máximo:
3) resultante: **[10, 8, 2, 3, 5]** (donde 10 es la raíz).
4) Extraer máximos: Intercambia 10 y 5 → **[5, 8, 2, 3, 10]** (10 ya está ordenado).
5) Re-heapify **[5, 8, 2, 3]** → **[8, 5, 2, 3].**
6) Intercambia 8 y 3 → **[3, 5, 2, 8, 10].**
7) Repite hasta obtener **[2, 3, 5, 8, 10].**


   ### METODO DE ORDENAMIENTO SHELL:
    ```java
        public static <T extends Comparable<T>> void shell(T[] arreglo) {
        int n = arreglo.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                T temp = arreglo[i];
                int j;
                for (j = i; j >= gap && arreglo[j - gap].compareTo(temp) > 0; j -= gap) {
                    arreglo[j] = arreglo[j - gap];
                }
                arreglo[j] = temp;
            }
        }
    }
   
1) Este método implementa el algoritmo Shell Sort, una optimización del Insertion Sort que compara elementos separados por un "gap" (brecha).
2) Inicialización
      **int n = arreglo.length;** Obtiene el tamaño del arreglo para determinar los gaps.
3) Loop de Gaps (Brechas)
**for (int gap = n / 2; gap > 0; gap /= 2)**
gap inicial: **n / 2** (mitad del tamaño del arreglo).
Iteración: Reduce el gap a la mitad en cada ciclo.
4) Loop Principal (por cada gap)
**for (int i = gap; i < n; i++)**
**i:** Comienza en gap y recorre hasta el final del arreglo , procesa cada elemento en subarreglos definidos por el gap.
5) Almacenar el Elemento Actual
**T temp = arreglo[i];**
**temp:** Guarda el valor del elemento en posición i para compararlo después.
6) Comparación y Desplazamiento:
**for (j = i; j >= gap && arreglo[j - gap].compareTo(temp) > 0; j -= gap)**
Condiciones: j >= gap: Evita índices negativos.
**arreglo[j - gap] > temp:**  Compara el elemento actual (temp) con el que está a distancia gap.
Si el elemento a distancia gap es mayor, lo desplaza a la posición j: **arreglo[j] = arreglo[j - gap];**
7) Insertar el Elemento en su Posición Correcta
**arreglo[j] = temp;**
Coloca temp en la posición donde ya no hay elementos mayores anteriores (según el gap actual).

       EJEMPLO:
1) Arreglo inicial: [12, 34, 54, 2, 3]
   gap inicial: 5 / 2 = 2

2) Subarreglos con gap=2: [12, 54, 3] y [34, 2]
3) Ordenamiento por inserción en cada subarreglo: [3, 12, 54] y [2, 34]
4) Arreglo parcial: [3, 2, 12, 34, 54]
5) gap=1 : Ordena el arreglo completo.
6) Resultado final: [2, 3, 12, 34, 54]
   Y asi concluye este metodo.

   ### METODO DE ORDENAMIENTO INTERCAMBIAR :
    ```java
    private static <T> void intercambiar(T[] arreglo, int i, int j) {
        T temp = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = temp;
    }
    public static <T> void imprimirArreglo(T[] arreglo) {
        for (T elemento : arreglo) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }

    
1) Método intercambiar(T[] arreglo, int i, int j):
   **private static <T> void intercambiar(T[] arreglo, int i, int j) {
Intercambia la posición de dos elementos en un arreglo genérico. Es utilizado por todos los algoritmos de ordenamiento cuando necesitan reordenar elementos.
2) **T temp = arreglo[i]** Crea una variable temporal temp del tipo genérico T.
Almacena el valor del elemento en la posición i del arreglo.
3) Ejemplo: Si arreglo = **[3, 5, 1]** e i = 0, entonces temp = 3.
**arreglo[i] = arreglo[j]**
Sobrescribe el elemento en la posición i con el valor del elemento en la posición j.

        EJEMPLO:
1) Si j = 1 y arreglo[j] = 5, ahora arreglo[0] = 5.
2) El arreglo queda: **[5, 5, 1]** (temporalmente).
   **arreglo[j]** = temp
   Asigna el valor original de arreglo[i] (guardado en temp) a la posición j.
3) Ejemplo: temp = 3, entonces arreglo[1] = 3.
4) Resultado final: **[5, 3, 1]**
5) **imprimirArreglo(T[] arreglo)** 
   Imprime los elementos de un arreglo genérico en la consola, separados por espacios. Útil para depurar o verificar el ordenamiento.






 









