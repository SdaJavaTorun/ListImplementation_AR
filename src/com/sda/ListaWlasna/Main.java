package com.sda.ListaWlasna;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ListImpl lista = new ListImpl();

        lista.addElement("test");
        lista.addElement("drugi test");
        lista.addElement("trzeci test");
        lista.addElement("czwarty test");

        System.out.println(lista.toString());

        lista.printFromTheEnd();
        lista.printFromTheStart();

        System.out.print("Rozmiar listy wynosi: " + lista.listSize());
        lista.removeElement("drugi test");
        lista.removeElement("trzeci test");
        System.out.print("Rozmiar listy wynosi: " + lista.listSize());
    }
}
