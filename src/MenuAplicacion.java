import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class MenuAplicacion {
    private static final int TAMANO_HASH = 11;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcionPrimera;

        do {
            try {
                System.out.println("\nSeleccione una opción del primer menú:");
                System.out.println("1. Algoritmos Cuadráticos de Ordenamiento de Peor Caso");
                System.out.println("2. Algoritmos de Ordenamiento de Caso Promedio o Peor Caso");
                System.out.println("3. Búsqueda Lineal y Búsqueda Binaria");
                System.out.println("4. Hashing y Resolución de Colisiones");
                System.out.println("5. Arrays Unidimensionales y Bidimensionales");
                System.out.println("0. Salir");
                System.out.print("Opción: ");
                opcionPrimera = Integer.parseInt(scanner.nextLine());

                switch (opcionPrimera) {
                case 1:
                manejarMenuAlgoritmosCuadraticos(scanner);
                break;
            case 2:
                manejarMenuAlgoritmosCasoPromedio(scanner);
                break;
            case 3:
                manejarMenuBusqueda(scanner);
                break;
            case 4:
                manejarMenuHashing(scanner);
                break;
            case 5:
                manejarMenuArrays(scanner);
            break;
            case 0:
                System.out.println("Saliendo de la aplicación...");
                break;
                default:
                System.out.println("Opción no válida. Intente de nuevo.");
                }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada no válida. Por favor, ingrese un número correspondiente a una opción del menú.");
                    opcionPrimera = -1; // Mantenerse en el menú principal
                }
                } while (opcionPrimera != 0);
                scanner.close();
                }



private static void manejarMenuAlgoritmosCuadraticos(Scanner scanner) {
    boolean salir = false;
    while (!salir) {
        System.out.println("\nSeleccione el algoritmo de ordenamiento cuadrático que desea utilizar:");
        System.out.println("1.1 Bubble Sort");
        System.out.println("1.2 Insertion Sort");
        System.out.println("1.3 Selection Sort");
        System.out.println("1.4 Bucket Sort");
        System.out.println("1.5 Counting Sort");
        System.out.println("1.6 Radix Sort");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        
        int opcion = Integer.parseInt(scanner.nextLine());
        
        switch (opcion) {
            case 1:
                bubbleSort();
                break;
            case 2:
                insertionSort();
                break;
            case 3:
                selectionSort();
                break;
            case 4:
                bucketSort();
                break;
            case 5:
                countingSort();
                break;
            case 6:
                radixSort();
                break;
            case 0:
                System.out.println("Saliendo del menú de algoritmos cuadráticos...");
                salir = true;
                break;
            default:
                System.out.println("Opción no válida. Intente nuevamente.");
        }
    }
}


private static void bubbleSort() {
    int[] arr = generarListaAleatoria(10);
    System.out.println("\n-----------Menu 3----------");
    System.out.println("Array creado aleatoriamente: " + Arrays.toString(arr));
    System.out.println("\n-----------Inicio----------");
    for (int i = 0; i < arr.length - 1; i++) {
        for (int j = 0; j < arr.length - 1 - i; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
            System.out.println(Arrays.toString(arr));
        }
    }
    System.out.println("-----------Final----------");
    System.out.println("Array ordenado:");
    imprimirArreglo(arr);
}

private static void insertionSort() {
    int[] arr = generarListaAleatoria(10);
    System.out.println("\n-----------Menu 3----------");
    System.out.println("Array creado aleatoriamente: " + Arrays.toString(arr));
    System.out.println("\n-----------Inicio----------");
    for (int i = 1; i < arr.length; i++) {
        int key = arr[i];
        int j = i - 1;
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j = j - 1;
            System.out.println(Arrays.toString(arr)); // Muestra el arreglo en cada paso
        }
        arr[j + 1] = key;
        System.out.println(Arrays.toString(arr)); // Muestra el arreglo después de colocar el valor
    }
    System.out.println("-----------Final----------");
    System.out.println("Array ordenado:");
    imprimirArreglo(arr);
}

private static void selectionSort() {
    int[] arr = generarListaAleatoria(10);
    System.out.println("\n-----------Inicio----------");
    System.out.println("Array creado aleatoriamente: " + Arrays.toString(arr));
    System.out.println(Arrays.toString(arr));

    for (int i = 0; i < arr.length - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }
        int temp = arr[minIndex];
        arr[minIndex] = arr[i];
        arr[i] = temp;
        System.out.println(Arrays.toString(arr)); // Muestra el arreglo después de cada intercambio
    }
    System.out.println("-----------Final----------");
    System.out.println("Array ordenado:");
    imprimirArreglo(arr);
}

private static class ArrayDinamico {
    private Object[] array = new Object[0];
    
    public ArrayDinamico() {
    }
    
    public void push(int a) {
        Object[] auxarray = new Object[array.length+1];
        for(int i = 0; i < array.length; i++) {
            auxarray[i] = array[i];
        }
        auxarray[array.length] = a;
        array = auxarray;
    }
    
    public int eliminarElemento(int pos) {
        try {
            int elementoeliminado;
            if(array.length == 0) {
                throw new Exception("No existen elementos en el array");
            }
            if(pos >= array.length) {
                throw new Exception("No existe dicha posicion");
            }
            elementoeliminado = (Integer) array[pos];
            array[pos] = null;
            if(pos != array.length-1) {
                for(int i = pos; i < array.length-1; i++) {
                    array[i] = array[i+1];
                }
                array[array.length-1] = null;
            }
            this.formatting();
            return elementoeliminado;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public int pop() {
        try {
            int elementoeliminado;
            if(array.length == 0) {
                throw new Exception("No existen elementos en el array");
            }
            elementoeliminado = (Integer) array[array.length-1];
            array[array.length-1] = null; 
            this.formatting();
            return elementoeliminado;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public void formatting() {
        Object[] auxarray;
        int dimension = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] == null) {
                 dimension = i;
                 break;
            }
        }
        auxarray = new Object[dimension];
        for(int i = 0; i < dimension; i++) {
            auxarray[i] = array[i];
        }
        array = auxarray;
    }
    
    public int size() {
        return array.length;
    }
    
    public String toString() {
        String salida = "[";
        if(array.length == 0) {
            salida += "]";
        }
        for(int i = 0; i < array.length; i++) {
            if(i == array.length-1) {
                salida += " " + array[i] + "]";
            } else {
                salida += " " + array[i] + ",";
            }
        }
        return salida;
    }
}

private static void bucketSort() {
    int[] arr = generarListaAleatoria(10);
    System.out.println("\n-----------Menu 3 ----------");
    System.out.println("Array creado aleatoriamente: " + Arrays.toString(arr));
    System.out.println("\n-----------Inicio----------");
    System.out.println(Arrays.toString(arr));

    int numBuckets = 5;
    int[][] buckets = new int[numBuckets][arr.length];
    int max = Arrays.stream(arr).max().getAsInt();
    int min = Arrays.stream(arr).min().getAsInt();
    int range = (max - min) / numBuckets + 1;

    for (int i = 0; i < arr.length; i++) {
        int bucketIndex = (arr[i] - min) / range;
        buckets[bucketIndex][i] = arr[i];
    }

    int[] sortedArray = new int[arr.length];
    int index = 0;
    for (int[] bucket : buckets) {
        Arrays.sort(bucket);
        for (int num : bucket) {
            if (num != 0) {
                sortedArray[index++] = num;
            }
        }
    }
    System.out.println("-----------Final----------");
    System.out.println("Array ordenado:");
    imprimirArreglo(sortedArray);
}

private static void countingSort() {
    int[] arr = generarListaAleatoria(10);
    System.out.println("\n-----------Menu 3 ----------");
    System.out.println("Array creado aleatoriamente: " + Arrays.toString(arr));
    System.out.println("\n-----------Inicio----------");
    System.out.println(Arrays.toString(arr));

    int max = Arrays.stream(arr).max().getAsInt();
    int[] count = new int[max + 1];
    int[] sortedArray = new int[arr.length];

    for (int num : arr) {
        count[num]++;
    }

    int index = 0;
    for (int i = 0; i < count.length; i++) {
        while (count[i] > 0) {
            sortedArray[index++] = i;
            count[i]--;
        }
    }

    System.out.println("-----------Final----------");
    System.out.println("Array ordenado:");
    imprimirArreglo(sortedArray);
}

private static void radixSort() {
    int[] arr = generarListaAleatoria(10);
    System.out.println("\n-----------Menu 3 ----------");
    System.out.println("Array creado aleatoriamente: " + Arrays.toString(arr));
    System.out.println("\n-----------Inicio----------");
    System.out.println(Arrays.toString(arr));

    int max = Arrays.stream(arr).max().getAsInt();

    for (int exp = 1; max / exp > 0; exp *= 10) {
        countSortByDigit(arr, exp);
        System.out.println(Arrays.toString(arr)); // Muestra el arreglo después de cada paso
    }

    System.out.println("-----------Final----------");
    System.out.println("Array ordenado:");
    imprimirArreglo(arr);
}

private static void countSortByDigit(int[] arr, int exp) {
    int[] output = new int[arr.length];
    int[] count = new int[10];

    for (int i = 0; i < arr.length; i++) {
        count[(arr[i] / exp) % 10]++;
    }

    for (int i = 1; i < 10; i++) {
        count[i] += count[i - 1];
    }

    for (int i = arr.length - 1; i >= 0; i--) {
        output[count[(arr[i] / exp) % 10] - 1] = arr[i];
        count[(arr[i] / exp) % 10]--;
    }

    System.arraycopy(output, 0, arr, 0, arr.length);
}

private static void imprimirArregloCuadratico(int[] arr) {
    for (int num : arr) {
        System.out.print(num + " ");
    }
    System.out.println();
}

private static void manejarMenuAlgoritmosCasoPromedio(Scanner scanner) {
    boolean salir = false;
    while (!salir) {
        System.out.println("\nSeleccione El algoritmo de caso promedio que desea ordenar");
        System.out.println("1. Ordenar con Merge Sort");
        System.out.println("2. Ordenar con Quick Sort");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
        int opcion = Integer.parseInt(scanner.nextLine());

        switch (opcion) {
            case 1:
                mergeSort();
                break;
            case 2:
                quickSort();
                break;
            case 3:
                System.out.println("Saliendo del programa...");
                salir = true;
                break;
            default:
                System.out.println("Opción no válida. Intente nuevamente.");
        }
    }
}

public static void mergeSort() {
    int[] arr = generarListaAleatoria(10);
    System.out.println("\nGenerador de lista de números:");
    System.out.println("Lista generada: " + Arrays.toString(arr));
    mergeSort(arr, 0, arr.length - 1);
    System.out.println("Arreglo ordenado con Merge Sort:");
    imprimirArreglo(arr);
}

private static void mergeSort(int[] arr, int left, int right) {
    if (left < right) {
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
}

private static void merge(int[] arr, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;

    int[] leftArray = new int[n1];
    int[] rightArray = new int[n2];

    System.arraycopy(arr, left, leftArray, 0, n1);
    System.arraycopy(arr, mid + 1, rightArray, 0, n2);

    int i = 0, j = 0, k = left;
    while (i < n1 && j < n2) {
        if (leftArray[i] <= rightArray[j]) {
            arr[k++] = leftArray[i++];
        } else {
            arr[k++] = rightArray[j++];
        }
    }

    while (i < n1) {
        arr[k++] = leftArray[i++];
    }

    while (j < n2) {
        arr[k++] = rightArray[j++];
    }
}

public static void quickSort() {
    int[] arr = generarListaAleatoria(10);
    System.out.println("\nGenerador de lista de números:");
    System.out.println("Lista generada: " + Arrays.toString(arr));
    quickSort(arr, 0, arr.length - 1);
    System.out.println("Arreglo ordenado con Quick Sort:");
    imprimirArreglo(arr);
}

private static void quickSort(int[] arr, int low, int high) {
    if (low < high) {
        int pivot = partition(arr, low, high);
        quickSort(arr, low, pivot - 1);
        quickSort(arr, pivot + 1, high);
    }
}

private static int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = (low - 1);

    for (int j = low; j < high; j++) {
        if (arr[j] <= pivot) {
            i++;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;
    return i + 1;
}

private static void imprimirArreglo(int[] arr) {
    for (int num : arr) {
        System.out.print(num + " ");
    }
    System.out.println();
}
        private static void manejarMenuBusqueda(Scanner scanner) {
        // Preguntar al usuario qué tipo de búsqueda quiere realizar
        System.out.println("Seleccione el tipo de búsqueda:");
        System.out.println("1. Búsqueda Lineal");
        System.out.println("2. Búsqueda Binaria");
        int opcion = Integer.parseInt(scanner.nextLine());

        // Generar una lista de 10 números aleatorios sin repetidos
        int[] array = generarListaAleatoria(10);
        System.out.println("\nGenerador de lista de números:");
        System.out.println("Lista generada: " + Arrays.toString(array));

        // Preguntar al usuario qué número desea buscar
        System.out.print("Ingrese el número a buscar: ");
        int elementoBuscar = Integer.parseInt(scanner.nextLine());

        switch (opcion) {
            case 1:
                // Realizar búsqueda lineal
                int resultadoLineal = busquedaLineal(array, elementoBuscar);
                if (resultadoLineal != -1) {
                    System.out.println("Elemento encontrado en la posición (búsqueda lineal): " + resultadoLineal);
                } else {
                    System.out.println("Elemento no encontrado (búsqueda lineal)");
                }
                break;

            case 2:
                // Ordenar el array antes de realizar la búsqueda binaria
                Arrays.sort(array);
                System.out.println("Lista ordenada: " + Arrays.toString(array));

                // Realizar búsqueda binaria
                int resultadoBinario = busquedaBinaria(array, elementoBuscar);
                if (resultadoBinario != -1) {
                    System.out.println("Elemento encontrado en la posición (búsqueda binaria): " + resultadoBinario);
                } else {
                    System.out.println("Elemento no encontrado (búsqueda binaria)");
                }
                break;

            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

    // Método para generar lista de números aleatorios sin repetidos
    public static int[] generarListaAleatoria(int tamaño) {
        Random random = new Random();
        Set<Integer> set = new HashSet<>();

        // Generar números aleatorios entre 0 y 99 hasta obtener el tamaño deseado
        while (set.size() < tamaño) {
            set.add(random.nextInt(100));  // Números aleatorios entre 0 y 99
        }

        // Convertir el conjunto en un array
        int[] array = new int[tamaño];
        int index = 0;
        for (int num : set) {
            array[index++] = num;
        }

        return array;
    }

    // Implementación de búsqueda lineal con impresión de comparaciones
    public static int busquedaLineal(int[] array, int elementoBuscar) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Comparando " + array[i] + " con " + elementoBuscar);
            if (array[i] == elementoBuscar) {
                return i;
            }
        }
        return -1;
    }

    // ------------------------------------------------------------
    // |                    BÚSQUEDA BINARIA                       |
    // ------------------------------------------------------------

    // Implementación de búsqueda binaria con impresión de comparaciones
    public static int busquedaBinaria(int[] array, int elementoBuscar) {
        int izq = 0;
        int der = array.length - 1;

        while (izq <= der) {
            int mid = (izq + der) / 2;
            System.out.println("Comparando " + array[mid] + " con " + elementoBuscar);

            if (array[mid] == elementoBuscar) {
                return mid;
            }

            if (array[mid] < elementoBuscar) {
                izq = mid + 1;
                System.out.println("Buscando en la mitad derecha");
            } else {
                der = mid - 1;
                System.out.println("Buscando en la mitad izquierda");
            }
        }
        return -1;
    }



    private static void manejarMenuHashing(Scanner scanner) {
        try {
            int[] numeros = generarListaNumeros();
            System.out.println("Lista de Números Generada:");
            for (int num : numeros) {
                System.out.print(num + " ");
            }
            System.out.println("\n");

            System.out.println("Seleccione método de resolución de colisiones:");
            System.out.println("1. Linear Probing");
            System.out.println("2. Quadratic Probing");
            System.out.print("Opción: ");
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    int[] tablaLinear = linearProbing(numeros);
                    imprimirTablaHash(tablaLinear);
                    break;
                case 2:
                    int[] tablaQuadratic = quadraticProbing(numeros);
                    imprimirTablaHash(tablaQuadratic);
                    break;
                default:
                    System.out.println("Opción no válida. Regresando al menú principal.");
            }
        } catch (Exception e) {
            System.out.println("Error en el manejo de Hashing: " + e.getMessage());
        }
    }

    private static int[] generarListaNumeros() {
        Random random = new Random();
        int[] numeros = new int[TAMANO_HASH];
        boolean[] usado = new boolean[100];
        for (int i = 0; i < TAMANO_HASH; i++) {
            int numero;
            do {
                numero = random.nextInt(100);
            } while (usado[numero]);
            numeros[i] = numero;
            usado[numero] = true;
        }
        return numeros;
    }

    private static int[] linearProbing(int[] numeros) {
        int[] tablaHash = new int[TAMANO_HASH];
        for (int i = 0; i < TAMANO_HASH; i++)
            tablaHash[i] = -1;

        for (int numero : numeros) {
            int indice = numero % TAMANO_HASH;
            while (tablaHash[indice] != -1) {
                indice = (indice + 1) % TAMANO_HASH;
            }
            tablaHash[indice] = numero;
        }
        return tablaHash;
    }

    private static int[] quadraticProbing(int[] numeros) {
        int[] tablaHash = new int[TAMANO_HASH];
        for (int i = 0; i < TAMANO_HASH; i++)
            tablaHash[i] = -1;

        for (int numero : numeros) {
            int indice = numero % TAMANO_HASH;
            int i = 1;
            while (tablaHash[indice] != -1) {
                indice = (indice + i * i) % TAMANO_HASH;
                i++;
            }
            tablaHash[indice] = numero;
        }
        return tablaHash;
    }

    private static void imprimirTablaHash(int[] tablaHash) {
        System.out.println("Tabla Hash:");
        for (int i = 0; i < tablaHash.length; i++) {
            System.out.println("Índice " + i + ": " + (tablaHash[i] == -1 ? "Vacío" : tablaHash[i]));
        }
    }
    private static void manejarMenuArrays(Scanner scanner) {
        ArrayDinamico arrayDinamico = new ArrayDinamico();
        boolean salir = false;
    
        while (!salir) {
            System.out.println("\nSeleccione una opción para Array Dinámico:");
            System.out.println("1. Agregar elemento (push)");
            System.out.println("2. Eliminar último elemento (pop)");
            System.out.println("3. Eliminar elemento por posición");
            System.out.println("4. Mostrar array");
            System.out.println("5. Mostrar tamaño del array");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
    
            try {
                int opcion = Integer.parseInt(scanner.nextLine());
    
                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el elemento a agregar: ");
                        int elementoAgregar = Integer.parseInt(scanner.nextLine());
                        arrayDinamico.push(elementoAgregar);
                        System.out.println("Elemento agregado.");
                        break;
                    case 2:
                        int elementoEliminado = arrayDinamico.pop();
                        if (elementoEliminado != 0) {
                            System.out.println("Elemento eliminado: " + elementoEliminado);
                        }
                        break;
                    case 3:
                        System.out.print("Ingrese la posición del elemento a eliminar: ");
                        int posicion = Integer.parseInt(scanner.nextLine());
                        int elementoEliminadoPorPosicion = arrayDinamico.eliminarElemento(posicion);
                        if (elementoEliminadoPorPosicion != 0) {
                            System.out.println("Elemento eliminado: " + elementoEliminadoPorPosicion);
                        }
                        break;
                    case 4:
                        System.out.println("Contenido del array: " + arrayDinamico.toString());
                        break;
                    case 5:
                        System.out.println("Tamaño del array: " + arrayDinamico.size());
                        break;
                    case 0:
                        salir = true;
                        System.out.println("Saliendo del menú de Array Dinámico...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
            }
        }
    }

}
