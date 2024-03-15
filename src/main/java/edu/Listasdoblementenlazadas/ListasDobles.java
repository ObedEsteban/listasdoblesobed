package edu.Listasdoblementenlazadas;
import java.util.HashSet;
public class ListasDobles {
    private nodos primero;
    private nodos ultimo;
    private nodos medio;
    public ListasDobles() {
        this.primero = null;
        this.ultimo = null;
    }
    public boolean vacia() {return primero == null;}

    public void agregarinicio(Object dato)
    {
        nodos nuevo = new nodos(dato);
        if (vacia()){
            primero = ultimo = nuevo;

        }else {
            nuevo.setSiguiente(primero);
            primero.setAnterior(nuevo);
            primero = nuevo;
        }
    }
    public void agregarmedio(Object dato) {
        if (vacia()) {agregarinicio(dato);}
        else {
            nodos nuevo = new nodos(dato);
            int tamaño = 0;
            nodos actual = primero;

            while (actual != null) {
                tamaño++;
                actual = actual.getSiguiente();
            }
            int mitad = tamaño / 2;
            actual = primero;
            for (int i = 0; i < mitad -1; i++) {
                actual = actual.getSiguiente();
            }
            nuevo.setSiguiente(actual.getSiguiente());
            if (actual.getSiguiente() != null) {
                actual.getSiguiente().setAnterior(nuevo);
            }
            nuevo.setAnterior(actual);
            actual.setSiguiente(nuevo);
        }
    }
    public void eliminarAlInicio() {
        if (vacia()) {
            if (primero == ultimo) {
                primero = ultimo = null;
            } else {
                primero = primero.getSiguiente();
                primero.setAnterior(null);
            }
        }
    }
    public void eliminarAlFinal() {
        if (vacia()) {
            if (primero == ultimo) {
                primero = ultimo = null;
            } else {
                ultimo = ultimo.getAnterior();
                ultimo.setSiguiente(null);
            }
        }
    }
    public void eliminarMedio() {
        if (!vacia()) {
            int tamaño = 0;
            nodos actual = primero;
            while (actual != null) {
                tamaño++;
                actual = actual.getSiguiente();
            }
            int mitad = tamaño / 2;
            actual = primero;
            for (int i = 0; i < mitad; i++) {
                actual = actual.getSiguiente();
            }
            if (actual == primero) {
                eliminarAlInicio();
            } else if (actual == ultimo) {
                eliminarAlFinal();
            } else {
                actual.getAnterior().setSiguiente(actual.getSiguiente());
                actual.getSiguiente().setAnterior(actual.getAnterior());
            }
        }
    }
    public void listarecorrer(){
        nodos actual = primero;
        while (actual != null){
            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        }
    }
    public void removerduplicado() {
        if (primero == null) {
            return;
        }
        HashSet<Object> set = new HashSet<>();
        nodos actual = primero;
        while (actual != null) {
            if (set.contains(actual.getDato())) {
                nodos siguiente = actual.getSiguiente();
                nodos anterior = actual.getAnterior();

                if (anterior != null) {
                    anterior.setSiguiente(siguiente);
                } else {
                    primero = siguiente;
                }

                if (siguiente != null) {
                    siguiente.setAnterior(anterior);
                } else {
                    ultimo = anterior;
                }
                actual = siguiente;
            } else {
                set.add(actual.getDato());
                actual = actual.getSiguiente();
            }
        }
    }
    public void listaalreves(){
        nodos actual = ultimo;
        while (actual != null){
            System.out.println("\n\t" + actual.getDato());
            actual = actual.getAnterior();
        }
    }
    public void listatamaño(){
        int tamaño = 0;
        nodos actual = primero;
        while (actual != null) {
            tamaño++;
            actual = actual.getSiguiente();
        }
        System.out.println("El tamaño de la lista es de "+tamaño + " nodos");

    }

}
