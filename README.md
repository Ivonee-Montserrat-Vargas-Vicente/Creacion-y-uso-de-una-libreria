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

   Explicación del código (clases, métodos, variables, validaciones)

1) Creamos un nuevo proyecto del tipo Java Class Library con el nombre LibreriaOrdenamientos
2) ![Captura de pantalla 2025-04-08 164727](https://github.com/user-attachments/assets/f22d7e21-218f-42c2-99b6-4bf62c8920fc)
3) dentro de la libreria contiene todos los algoritmos de ordenamiento implementados como métodos estáticos y genéricos cuando decimos genéricos se refiere a que (<T>): Usa <T extends Comparable<T>> para garantizar que los elementos sean comparables (por ejemplo pueden ser Integer, String, etc.). e inicamos con los metodos de ordenamiento.
   
4) ### ORDENAMIENTO POR METODO BURBUJA:
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
   
* En la primer linea de codigo <T extends Comparable<T>>: Lo que hace es que acepta un arreglo de cualquier tipo T que pueda ser comparado (ejemplo: Integer, String) hace que los elementos se compararen entre sí T[] arreglo: es el arreglo que le vamos a pasar 
* En la linea siguiente n almacena el número de elementos en el arreglo si por ejemplo tenemos = [5, 2, 9], entonces n = 3 tambien contamos con un bucle (for (int i = 0; i < n - 1; i++)): se ejecuta n - 1 veces (ej: para 3 elementos, hace 2 pasadas) y con el otro bucle interno (for (int j = 0; j < n - i - 1; j++)): compara elementos cada que pasa.
n - i - 1 reduce el rango en cada iteración.
* En las siguientes lineas hace una Comparación (if (arreglo[j].compareTo(arreglo[j + 1]) > 0)): aqui se usa compareTo() para verificar si el elemento actual (arreglo[j]) es mayor que el siguiente (arreglo[j + 1]) en dado caso que si lo que hace compareTo() es retornar > 0, significa que arreglo[j] es mayor.
5) SELECCION :
   ![image](https://github.com/user-attachments/assets/9015002a-90d4-4d91-abb5-67ab958a620a)
* Este otro método es el de ordenamiento por selección, que funciona dividiendo el arreglo en dos partes una parte ordenada al inicio y una parte sin ordenar (el resto) en cada iteración, encuentra el elemento más pequeño de la parte sin ordenar y lo coloca al final de la parte ordenada.
* int n = arreglo.length; n: Tamaño del arreglo hace que recorre el arreglo desde la posición 0 hasta n-1
* for (int i = 0; i < n - 1; i++) {
  int minIndex = i; Suponemos que el elemento más pequeño está en la posición i (inicialmente 0).
  i: marca el inicio de la parte no ordenada.
* for (int j = i + 1; j < n; j++) { --j: Recorre la parte no ordenada (desde i+1 hasta n-1).
    if (arreglo[j].compareTo(arreglo[minIndex]) < 0) {--compareTo: Compara el elemento actual con el mínimo actual.
        minIndex = j }}
  si arreglo[j] es menor, actualiza minIndex = j.
* intercambiar(arreglo, i, minIndex);
 intercambiar: Coloca el elemento más pequeño encontrado (arreglo[minIndex]) en su posición correcta (i).
 El elemento en i ahora está ordenado la parte ordenada crece de izquierda a derecha.
6) INSERCION:
  ![image](https://github.com/user-attachments/assets/d4c67267-75aa-4578-a3dd-bd2966d95be5)
* Este método implementa el algoritmo de ordenamiento por inserción, que funciona construyendo una secuencia ordenada de elementos uno por uno
* int n = arreglo.length; --Obtener la longitud del arreglo para iterar sobre él.
* for (int i = 1; i < n; i++) {
Inicia en i = 1: porque el primer elemento se considera ya "ordenado" al inicio.
Recorre hasta i < n: Para procesar todos los elementos del arreglo.
* T clave = arreglo[i]; --clave: Es el elemento actual que se insertará en su posición correcta dentro de la parte ya ordenada del arreglo a la izquierda de i.
* int j = i - 1;
while (j >= 0 && arreglo[j].compareTo(clave) > 0) { -- la condición while: j >= 0: Evita índices negativos el aarreglo[j].compareTo(clave) > 0: Mueve los elementos mayores una posición a la derecha.
arreglo[j + 1] = arreglo[j];
    j--;}
  j = i - 1: Comienza comparando con el elemento anterior a clave.
* arreglo[j + 1] = arreglo[j]; -- Desplaza el elemento mayor
j--;  -- Retrocede para comparar con el siguiente elemento a la izquierda
* arreglo[j + 1] = clave;
Cuando el while termina, j + 1 es la posición donde clave debe insertarse (ya no hay elementos mayores a su izquierda).
7) Monticulos: ![Captura de pantalla 2025-04-09 075343](https://github.com/user-attachments/assets/2fbaf07b-850f-4ac7-ab19-97e50d44af97)
* El Heap Sort conocido tambien como ordenamiento por montículos es un algoritmo de ordenamiento eficiente que utiliza una estructura de datos llamada heap (montículo)
* 









