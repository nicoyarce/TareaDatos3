package javaapplication1;

//hashChain.java
//demonstrates hash table with separate chaining
//to run this program: C:>java HashChainApp
import java.io.*;
////////////////////////////////////////////////////////////////

class Link { // (could be other items)

    private Libro iData; // data item
    public Link next; // next link in list
    //-------------------------------------------------------------

    public Link(Libro it) // constructor
    {
        iData = it;
    }

    //-------------------------------------------------------------
    public Libro getKey() {
        return iData;
    }

    //-------------------------------------------------------------
    public void displayLink() // display this link
    {
        System.out.print(iData + " ");
    }
} // end class Link
////////////////////////////////////////////////////////////////

class SortedList {

    private Link first; // ref to first list item
    //-------------------------------------------------------------

    public SortedList() // constructor
    {
        first = null;
    }

    //-------------------------------------------------------------
    public void insert(Link theLink) // insert link, in order
    {
        long key = theLink.getKey().transformaCodigo();
        Link previous = null; // start at first
        Link current = first;
        //until end of list,
        while (current != null && key > current.getKey().transformaCodigo()) { // or current > key,
            previous = current;
            current = current.next; // go to next item
        }
        if (previous == null) // if beginning of list,
        {
            first = theLink; // first --> new link
        } else // not at beginning,
        {
            previous.next = theLink; // prev --> new link
        }
        theLink.next = current; // new link --> current
    } // end insert()
    //-------------------------------------------------------------

    public void delete(int key) // delete link
    { // (assumes non-empty list)
        Link previous = null; // start at first
        Link current = first;
        //until end of list,
        while (current != null && key != current.getKey().transformaCodigo()) { // or key == current,
            previous = current;
            current = current.next; // go to next link
        }
        //disconnect link
        if (previous == null) // if beginning of list
        {
            first = first.next; // delete first link
        } else // not at beginning
        {
            previous.next = current.next; // delete current link
        }
    } // end delete()
    //-------------------------------------------------------------

    public Link find(int key) // find link
    {
        Link current = first; // start at first
        //until end of list,
        while (current != null && current.getKey().transformaCodigo() <= key) { // or key too small,
            if (current.getKey().transformaCodigo() == key) // is this the link?
            {
                return current; // found it, return link
            }
            current = current.next; // go to next item
        }
        return null; // didn't find it
    } // end find()
    //-------------------------------------------------------------

    public void displayList() {
        System.out.print("List (first-->last): ");
        Link current = first; // start at beginning of list
        while (current != null) // until end of list,
        {
            current.displayLink(); // print data
            current = current.next; // move to next link
        }
        System.out.println("");
    }
} // end class SortedList
////////////////////////////////////////////////////////////////

class HashTableY {

    private SortedList[] hashArray; // array of lists
    private int arraySize;
//-------------------------------------------------------------

    public HashTableY(int size) // constructor
    {
        arraySize = size;
        hashArray = new SortedList[arraySize]; // create array
        for (int j = 0; j < arraySize; j++) // fill array
        {
            hashArray[j] = new SortedList(); // with lists
        }
    }
//-------------------------------------------------------------

    public void displayTable() {
        for (int j = 0; j < arraySize; j++) // for each cell,
        {
            System.out.print(j + ". "); // display cell number
            hashArray[j].displayList(); // display list
        }
    }
//-------------------------------------------------------------

    public long hashFunc(long key) // hash function
    {
        return key % arraySize;
    }
//-------------------------------------------------------------

    public void insert(Link theLink) // insert a link
    {
        long key = theLink.getKey().transformaCodigo();
        int hashVal = (int)hashFunc(key); // hash the key
        hashArray[hashVal].insert(theLink); // insert at hashVal
    } // end insert()
//-------------------------------------------------------------

    public void delete(int key) // delete a link
    {
        int hashVal = (int)hashFunc(key); // hash the key
        hashArray[hashVal].delete(key); // delete link
    } // end delete()
//-------------------------------------------------------------

    public Link find(int key) // find link
    {
        int hashVal = (int)hashFunc(key); // hash the key
        Link theLink = hashArray[hashVal].find(key); // get link
        return theLink; // return link
    }
//-------------------------------------------------------------
} // end class HashTableY
////////////////////////////////////////////////////////////////

/*class HashChainApp {

    public static void main(String[] args) throws IOException {
        int aKey;
        Link aDataItem;
        int size, n, keysPerCell = 100;
        //get sizes
        System.out.print("Ingrese tama�o tabla de hash: ");
        size = getInt();
        System.out.print("Ingrese numero inicial de items: ");
        n = getInt();
        //make table
        HashTableY theHashTableY = new HashTableY(size);
        for (int j = 0; j < n; j++) // insert data
        {
            aKey = (int) (java.lang.Math.random()
                    * keysPerCell * size);
            aDataItem = new Link(aKey);
            theHashTableY.insert(aDataItem);
        }
        while (true) // interact with user
        {
            System.out.print("Ingrese la primera letra de ");
            System.out.print("mostrar, insertar, eliminar o buscar: ");
            char choice = getChar();
            switch (choice) {
                case 'm':
                    theHashTableY.displayTable();
                    break;
                case 'i':
                    System.out.print("Ingresar llave a insertar: ");
                    aKey = getInt();
                    aDataItem = new Link(aKey);
                    theHashTableY.insert(aDataItem);
                    break;
                case 'e':
                    System.out.print("Ingresar llave a eliminar: ");
                    aKey = getInt();
                    theHashTableY.delete(aKey);
                    break;
                case 'b':
                    System.out.print("Ingresar llave a buscar: ");
                    aKey = getInt();
                    aDataItem = theHashTableY.find(aKey);
                    if (aDataItem != null) {
                        System.out.println("Encontrada " + aKey);
                    } else {
                        System.out.println("No pude ubicarla " + aKey);
                    }
                    break;
                default:
                    System.out.print("Valor invalido\n");
            } // end switch
        } // end while
    } // end main()
    //--------------------------------------------------------------

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    //-------------------------------------------------------------
    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    //-------------------------------------------------------------
    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
	//--------------------------------------------------------------
} // end class HashChainApp
////////////////////////////////////////////////////////////////
*/