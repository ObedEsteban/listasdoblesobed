package edu.Listasdoblementenlazadas;

public class nodos {

    public Object getDato() {
        return dato;
    }
    public void setDato(Object dato) {
        this.dato = dato;
    }
    public nodos getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(nodos siguiente) {
        this.siguiente = siguiente;
    }
    public nodos getAnterior() {
        return anterior;
    }
    public void setAnterior(nodos anterior) {
        this.anterior = anterior;
    }

    private Object dato;
    private nodos siguiente;
    private nodos anterior;

    public nodos(Object dato){
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }

}