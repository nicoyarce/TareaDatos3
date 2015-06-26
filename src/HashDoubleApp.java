//hashDouble.java
//demonstrates hash table with double hashing
//to run this program: C:>java HashDoubleApp

import java.io.*;
////////////////////////////////////////////////////////////////

class DataItemX { // (could have more items)

    private int iData; // data item (key)
    //--------------------------------------------------------------

    public DataItemX(int ii) // constructor
    {
        iData = ii;
    }

    //--------------------------------------------------------------

    public int getKey() {
        return iData;
    }
	//--------------------------------------------------------------
} // end class DataItemX
////////////////////////////////////////////////////////////////

class HashTableX {

    private DataItemX[] hashArray; // array is the hash table
    private int arraySize;
    private DataItemX nonItem; // for deleted items
//-------------------------------------------------------------

    HashTableX(int size) // constructor
    {
        arraySize = size;
        hashArray = new DataItemX[arraySize];
        nonItem = new DataItemX(-1);
    }
//-------------------------------------------------------------

    public void displayTable() {
        System.out.print("Tabla: ");
        for (int j = 0; j < arraySize; j++) {
            if (hashArray[j] != null) {
                System.out.print(hashArray[j].getKey() + " ");
            } else {
                System.out.print("** ");
            }
        }
        System.out.println("");
    }
//-------------------------------------------------------------

    public int hashFunc1(int key) {
        return key % arraySize;
    }
//-------------------------------------------------------------

    public int hashFunc2(int key) {
	//non-zero, less than array size, different from hF1
        //array size must be relatively prime to 5, 4, 3, and 2
        return 5 - key % 5;
    }
//-------------------------------------------------------------
//insert a DataItemX

    public void insert(int key, DataItemX item) //(assumes table not full)
    {
        int hashVal = hashFunc1(key); // hash the key
        int stepSize = hashFunc2(key); // get step size
        //until empty cell or -1
        while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
            hashVal += stepSize; // add the step
            hashVal %= arraySize; // for wraparound
        }
        hashArray[hashVal] = item; // insert item
    } // end insert()
//-------------------------------------------------------------

    public DataItemX delete(int key) // delete a DataItemX
    {
        int hashVal = hashFunc1(key); // hash the key
        int stepSize = hashFunc2(key); // get step size
        while (hashArray[hashVal] != null) // until empty cell,
        { // is correct hashVal?
            if (hashArray[hashVal].getKey() == key) {
                DataItemX temp = hashArray[hashVal]; // save item
                hashArray[hashVal] = nonItem; // delete item
                return temp; // return item
            }
            hashVal += stepSize; // add the step
            hashVal %= arraySize; // for wraparound
        }
        return null; // can't find item
    } // end delete()
//-------------------------------------------------------------

    public DataItemX find(int key) // find item with key
    //(assumes table not full)
    {
        int hashVal = hashFunc1(key); // hash the key
        int stepSize = hashFunc2(key); // get step size
        while (hashArray[hashVal] != null) // until empty cell,
        { // is correct hashVal?
            if (hashArray[hashVal].getKey() == key) {
                return hashArray[hashVal]; // yes, return item
            }
            hashVal += stepSize; // add the step
            hashVal %= arraySize; // for wraparound
        }
        return null; // can't find item
    }
//-------------------------------------------------------------
} // end class HashTableX
////////////////////////////////////////////////////////////////

/*class HashDoubleApp {

    public static void main(String[] args) throws IOException {
        int aKey;
        DataItemX aDataItemX;
        int size, n;
        //get sizes
        System.out.print("Ingrese tama�o tabla de hash: ");

        size = getInt();
        System.out.print("Ingrese numero inicial de items: ");
        n = getInt();
        //make table
        HashTableX theHashTableX = new HashTableX(size);
        for (int j = 0; j < n; j++) // insert data
        {
            aKey = (int) (java.lang.Math.random() * 2 * size);
            aDataItemX = new DataItemX(aKey);
            theHashTableX.insert(aKey, aDataItemX);
        }
        while (true) // interact with user
        {
            System.out.print("Ingrese la primera letra de ");
            System.out.print("mostrar, insertar, eliminar o buscar: ");
            char choice = getChar();
            switch (choice) {
                case 'm':
                    theHashTableX.displayTable();
                    break;
                case 'i':
                    System.out.print("Ingrese la llave a insertar: ");
                    aKey = getInt();
                    aDataItemX = new DataItemX(aKey);
                    theHashTableX.insert(aKey, aDataItemX);
                    break;
                case 'e':
                    System.out.print("Ingrese llave a eliminar: ");
                    aKey = getInt();
                    theHashTableX.delete(aKey);
                    break;
                case 'b':
                    System.out.print("Ingrese llave a buscar: ");
                    aKey = getInt();
                    aDataItemX = theHashTableX.find(aKey);
                    if (aDataItemX != null) {
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
//--------------------------------------------------------------

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
} // end class HashDoubleApp
////////////////////////////////////////////////////////////////
*/