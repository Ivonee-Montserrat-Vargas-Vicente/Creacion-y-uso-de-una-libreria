/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ivone
 */
public class PruebaLibreriaOrdenamiento {
    public static void main(String[] args) {
        // EJEMPLO CON NÚMEROS 
        Integer[] numeros = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("===== ORDENAMIENTO DE NUMEROS =====");
        System.out.print("Original: ");
        LibreriaOrdenamiento.imprimirArreglo(numeros);

        // Ordenamiento Burbuja
        Integer[] numerosBurbuja = numeros.clone();
        LibreriaOrdenamiento.burbuja(numerosBurbuja);
        System.out.print("Burbuja:  ");
        LibreriaOrdenamiento.imprimirArreglo(numerosBurbuja);
        
        // Ordenamiento por Selección
        Integer[] numerosSeleccion = numeros.clone();
        LibreriaOrdenamiento.seleccion(numerosSeleccion);
        System.out.print("Seleccion:");
        LibreriaOrdenamiento.imprimirArreglo(numerosSeleccion);

        // Ordenamiento por Inserción
        Integer[] numerosInsercion = numeros.clone();
        LibreriaOrdenamiento.insercion(numerosInsercion);
        System.out.print("Insercion:");
        LibreriaOrdenamiento.imprimirArreglo(numerosInsercion);

        // Ordenamiento por Montículos 
        Integer[] numerosMonticulos = numeros.clone();
        LibreriaOrdenamiento.monticulos(numerosMonticulos);
        System.out.print("Monticulos:");
        LibreriaOrdenamiento.imprimirArreglo(numerosMonticulos);
        
        // Ordenamiento Shell
        Integer[] numerosShell = numeros.clone();
        LibreriaOrdenamiento.shell(numerosShell);
        System.out.print("Shell:    ");
        LibreriaOrdenamiento.imprimirArreglo(numerosShell);

        //EJEMPLO CON LETRAS 
        String[] palabras = {"zorro", "manzana", "perro", "gato", "arbol"};
        
        System.out.println("\n===== ORDENAMIENTO DE LETRAS =====");
        System.out.print("Original: ");
        LibreriaOrdenamiento.imprimirArreglo(palabras);

        // Ordenamiento Burbuja
        String[] palabrasBurbuja = palabras.clone();
        LibreriaOrdenamiento.burbuja(palabrasBurbuja);
        System.out.print("Burbuja:  ");
        LibreriaOrdenamiento.imprimirArreglo(palabrasBurbuja);
        
        
        // Ordenamiento Shell
        String[] palabrasShell = palabras.clone();
        LibreriaOrdenamiento.shell(palabrasShell);
        System.out.print("Shell:    ");
        LibreriaOrdenamiento.imprimirArreglo(palabrasShell);
    }
}

    

