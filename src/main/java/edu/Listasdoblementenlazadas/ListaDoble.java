package edu.Listasdoblementenlazadas;

public class ListaDoble {
    public static void main(String[] args) {

        ListasDobles lista = new ListasDobles();
        lista.agregarinicio("a");
        lista.agregarinicio("b");
        lista.agregarinicio("4");
        lista.agregarinicio("5");
        lista.agregarinicio("a");

        lista.removerduplicado();
        lista.listarecorrer();

    }
}
