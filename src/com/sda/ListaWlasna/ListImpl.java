package com.sda.ListaWlasna;

/* Created by Artur Rózgowski on 3/6/17 */
public class ListImpl {

        private Node listTail; // pierwszy node listy
        private Node listHead;  // ostatni node listy

        public ListImpl () {
            this.listTail = null;
            this.listHead = null;
        }

        public void addElement (String value) {
            // node obiekt, ktory mamy wstawic w ogon kolejki
            Node node = new Node(value, null, null);
            // tworzenie nowego elementu
            if (checkIsEmpty()) { // jesli piewszego node nie ma
                listTail = node;     // poczatek i koniec listy wskazuja na ten sam node
                listHead = node;
            } else {
                Node temp = listTail;  // tworzenie pomocniczego node wskazujace na ogon

                while (temp != null) {  // dopoki temp istnieje
                    //temp.getNext();     // ?? sprawdz co jest w getNext

                    if(temp == listTail) {  // jesli temp jest tail
                        node.setNext(temp);  // przesun temp w miejsce za node
                        temp.setPrev(node);  // a node w miejsce temp
                        listTail = node;     // listTail wskazuje na node
                        break;
                    }else {                 // jesli temp nie jest na poczatku
                        node.setNext(temp);  // temp przesuwamy za node
                        node.setPrev(temp.getPrev()); // tam gdzie temp pokazywał prev
                                                      // teraz musi pokazywac node
                        temp.getPrev().setPrev(node); //
                        temp.setPrev(node); // teraz mozna obiekt node przypisac w miejsce temp
                        break;
                    }

                } // end while
                if (temp == null) {
                    listHead.setNext(node);
                    node.setPrev(listHead);
                    listHead = node;
                }
            }
        }
        public boolean checkIsEmpty () { return (listTail == null); } // lista jest pusta jesli ogon nie jest ustawiony == null


    public void printFromTheEnd() {
        Node temp = listHead;

        System.out.println("Lista w odwrotnej kolejności:");
        while (temp != null) {
            System.out.println(temp.getValue());
            temp = temp.getPrev();
        }
    }

    public void printFromTheStart() {
        Node temp = listTail;

        System.out.println("Lista w kolejności:");
        while (temp !=null) {
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
    }

    public int listSize () {
        Node temp = listTail;
        int counter = 0;
        while (temp != null) {
            temp = temp.getNext();
            counter++;
        }
        return counter;
    }
    

    /*
    public void removeElement (String value) {
        Node node = new Node (value, null, null);
        Node temp = node;

        if (temp.getNext() == null) {      // sprawdzamy czy usuwamy list head
            node.setPrev(temp.getPrev());
            temp = null;
            node = null;
        }
        else if (temp.getPrev() == null) {  // sprawdzamy czy usuwamy pierwszy element
            temp.setNext(listTail);
            temp = null;
            node = null;
        }
        else {                          // usuwamy srodkowy element listy
            temp.setPrev(temp.getNext());
            temp.setNext(temp.getPrev());
            temp = null;
            node = null;
        }
        System.out.println("Lista po usunieciu");
        printFromTheStart();

    } /*
    public void showList () {

        Node list = listTail;
        while (list != null) {
            System.out.println(list.getValue());
            list = list.getNext();
        }

    }*/
}
