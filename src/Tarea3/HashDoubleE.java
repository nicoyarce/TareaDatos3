package Tarea3;

import java.io.*;
////////////////////////////////////////////////////////////////

public class HashDoubleE {

    private Libro[] hashArray; // array is the hash table
    private int arraySize;
    private Libro nonItem; // for deleted items
//-------------------------------------------------------------

    HashDoubleE(int size) // constructor
    {
        arraySize = size;
        hashArray = new Libro[arraySize];
        nonItem = new Libro("-1");
    }
//-------------------------------------------------------------

    public void displayTable() {
        System.out.print("Tabla: ");
        for (int j = 0; j < arraySize; j++) {
            if (hashArray[j] != null) {
                System.out.print(hashArray[j].transformaCodigo() + " ");
            } else {
                System.out.print("** ");
            }
        }
        System.out.println("");
    }
//-------------------------------------------------------------

    public long hashFunc1(long key) {
        return Libro.trunk(key*key)%131;
    }
//-------------------------------------------------------------

    public long hashFunc2(long key, int i) {
        //non-zero, less than array size, different from hF1
        //array size must be relatively prime to 5, 4, 3, and 2
        return hashFunc1(key) + i * (key % 127) % 131;
    }
//-------------------------------------------------------------
//insert a DataItemX

    public void insert(long key, Libro item) //(assumes table not full)
    {
        int i = 0;
        long hashVal = hashFunc1(key); // hash the key
        long stepSize = hashFunc2(key, i); // get step size
        //until empty cell or -1
        while (hashArray[(int) hashVal] != null && hashArray[(int) hashVal].transformaCodigo() != -1) {
            i++;
            hashVal += stepSize; // add the step
            hashVal %= arraySize; // for wraparound
        }
        hashArray[(int) hashVal] = item; // insert item
    } // end insert()
//-------------------------------------------------------------

    public Libro delete(int key) // delete a DataItemX
    {
        int i = 0;
        long hashVal = hashFunc1(key); // hash the key
        long stepSize = hashFunc2(key, i); // get step size
        while (hashArray[(int) hashVal] != null) // until empty cell,
        { // is correct hashVal?
            if (hashArray[(int) hashVal].transformaCodigo() == key) {
                Libro temp = hashArray[(int) hashVal]; // save item
                hashArray[(int) hashVal] = nonItem; // delete item
                return temp; // return item
            }
            i++;
            hashVal += stepSize; // add the step
            hashVal %= arraySize; // for wraparound
        }
        return null; // can't find item
    } // end delete()
//-------------------------------------------------------------

    public Libro find(int key) // find item with key
    //(assumes table not full)
    {
        int i = 0;
        long hashVal = hashFunc1(key); // hash the key
        long stepSize = hashFunc2(key, i); // get step size
        while (hashArray[(int) hashVal] != null) // until empty cell,
        { // is correct hashVal?
            if (hashArray[(int) hashVal].transformaCodigo() == key) {
                return hashArray[(int) hashVal]; // yes, return item
            }
            i++;
            hashVal += stepSize; // add the step
            hashVal %= arraySize; // for wraparound
        }
        return null; // can't find item
    }
//-------------------------------------------------------------
} // end class HashTableX
////////////////////////////////////////////////////////////////
