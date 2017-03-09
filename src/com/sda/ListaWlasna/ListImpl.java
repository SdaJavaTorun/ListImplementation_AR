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

    public void removeElement (String value) {
        Node node = listTail;  // ustalamy pierwszy node listy
        Node temp = node.getNext(); // i nastepny po pierwszym

        while (temp.getNext() != null) {
            if (temp.getValue() == value) { // jak znaljdziemy szukany node
                node.setNext(temp.getNext()); // do node leci wskaznik do temp next
                temp.getNext().setPrev(node); // do wezla poprzedzajacego temp wskzanik do node
                temp = null;                  // usuwamy obiekt
                break;
            }
            else {          // szukamy dalej zgodnosci - przesuwamy wskazanie wezla
                node = temp;
                temp = temp.getNext();
            }
        }
        System.out.println("\nLista po usunieciu");
        printFromTheStart();
    }
}
