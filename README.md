# Creacion-y-uso-de-una-libreria-

Instrucciones Generales:
Desarrollar una librería en Java que contenga métodos abstractos. Esta librería deberá ser funcional, clara y reutilizable. El objetivo es aplicar principios de programación orientada a objetos, crear un archivo .jar, documentarlo correctamente y demostrar su uso en otro proyecto.
-------------A continuacion breve descripción de la librería y su propósito:--------
DESCRIPCION: 
Lenguaje: Java
Entorno: NetBeans (exportable a JAR)
 
PROPOSITO:
Esta librería proporciona una colección de algoritmos de ordenamiento implementados en Java, que permiten:
*  Ordenar arrays de cualquier tipo de dato que implemente Comparable (números, strings,nbjetos).
*  Incluye métodos de ordenamiento como Burbuja, Selección, Inserción, Montículos y Shell Sort.
*  Funciona tanto en proyectos de consola como en interfaces gráficas (como el JFrame que se desarrollo aqui mismo y que veremos a continuacion).

--------------Explicación del código (clases, métodos, variables, validaciones)----------
1) Creamos un nuevo proyecto del tipo Java Class Library con el nombre LibreriaOrdenamientos
2) ![Captura de pantalla 2025-04-08 164727](https://github.com/user-attachments/assets/f22d7e21-218f-42c2-99b6-4bf62c8920fc)
3) dentro de la libreria contiene todos los algoritmos de ordenamiento implementados como métodos estáticos y genéricos cuando decimos genéricos se refiere a que (<T>): Usa <T extends Comparable<T>> para garantizar que los elementos sean comparables (por ejemplo pueden ser Integer, String, etc.). e inicamos con los metodos de ordenamiento.
4) Burbuja : ![Captura de pantalla 2025-04-08 165747](https://github.com/user-attachments/assets/d44a7f1c-1b40-4875-8593-b6d732d4d1be)
En la primer linea de codigo <T extends Comparable<T>>: Lo que hace es que acepta un arreglo de cualquier tipo T que pueda ser comparado (ejemplo: Integer, String) hace que los elementos se compararen entre sí T[] arreglo: es el arreglo que le vamos a pasar 


