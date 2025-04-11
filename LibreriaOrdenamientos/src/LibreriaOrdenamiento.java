/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ivone
 */
public class LibreriaOrdenamiento {
    
    //ordenamiento burbuja
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
    
    //ordenamiento por seleccion 
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
     
     //ordenamiento por insercion 
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
    
    //ordenamiento por monticulos 
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

    //ordenamiento shell 
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
    
    //metodo para intercambiar 
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
}



