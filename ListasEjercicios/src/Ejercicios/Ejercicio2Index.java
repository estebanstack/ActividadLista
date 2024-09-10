package Ejercicios;

import Ejercicios.lista.ListaEncadenada;
import Ejercicios.lista.Nodo;

public class Ejercicio2Index {
    static ListaEncadenada<Integer> lista = new ListaEncadenada<>();
    public static void main(String[] args) {
        llenarLista();
        lista.mostrar();
        sumarParesEImpares();
        lista.mostrar();
    }

    public static void llenarLista() {
        for(int i=0;i<6;i++) {
            int numero = (int) (Math.random() * 30);

            if (lista.esVacia()) {
                System.out.println("Lista vacía, agregando el primer elemento.");
                lista.agregarInicio(numero);
            } else {
                Nodo aux = lista.getInicio();
                int indice = 0;
                boolean agregado = false;

                while (aux != null) {
                    Integer dato = (Integer) aux.getElemento();

                    if (numero < dato) {
                        lista.agregarEntreNodo(numero, indice);
                        agregado = true;
                        break;
                    }
                    aux = aux.getSiguiente();
                    indice++;
                }
                if (!agregado) {
                    lista.agregarFinal(numero);
                }
            }

        }

    }

    public static void sumarParesEImpares() {
        Nodo aux = lista.getInicio();  // Obtenemos el nodo inicial
        int sumaPosicionesPares = 0, sumaPosicionesImpares = 0;
        int posicion = 0;  // Contador de posición, empezando desde 0 (que sería par)

        // Recorremos la lista
        while (aux != null) {
            Integer dato = (Integer) aux.getElemento(); // Obtenemos el valor del nodo actual

            // Si la posición es par, sumamos a sumaPosicionesPares
            if (posicion % 2 == 0) {
                sumaPosicionesPares += dato;
            }
            // Si la posición es impar, sumamos a sumaPosicionesImpares
            else {
                sumaPosicionesImpares += dato;
            }

            // Avanzamos al siguiente nodo
            aux = aux.getSiguiente();
            posicion++; // Incrementamos la posición en cada iteración
        }

        // Imprimimos las sumas
        System.out.println("Suma de posiciones pares: " + sumaPosicionesPares);
        System.out.println("Suma de posiciones impares: " + sumaPosicionesImpares);

        if(sumaPosicionesPares!=sumaPosicionesImpares){
            borrarPares();
        }else{
            borrarImpares();
        }
    }

    public static void borrarPares() {
        int posicion = 0;
        int indice = 0;

        Nodo aux = lista.getInicio();


        while (aux != null) {
            Nodo siguiente = aux.getSiguiente();

            if (posicion % 2 == 0) {
                lista.borrar(indice);
            } else {
                indice++;
            }

            aux = siguiente;
            posicion++;
        }

    }

    public static void borrarImpares() {
        int posicion = 0;
        int indice = 0;

        Nodo aux = lista.getInicio();

        while (aux != null) {
            Nodo siguiente = aux.getSiguiente();

            if (posicion % 2 != 0) {
                lista.borrar(indice);
            } else {
                indice++;
            }

            aux = siguiente;
            posicion++;
        }
    }
}
