package Tarea3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Archivo a = new Archivo();
        System.out.println("Ingrese opcion");
        System.out.println("1: Mostrar archivo");
        System.out.println("2: Insertar en tabla de Hashing Abierto enunciado C");
        System.out.println("3: Insertar en tabla de Doble Hashing enunciado D");
        System.out.println("4: Insertar en tabla de Doble Hashing enunciado E");
        System.out.println("5: Insertar en tabla de Doble Hashing enunciado F");
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        switch(opcion){
            case 1:
                a.abrirArchivo();
                break;
            case 2:
                a.hashingEncadenado();
                break;
            case 3:
                a.dobleHashD();
                break;
            case 4:
                a.dobleHashE();
                break;
            case 5:
                a.dobleHashF();
                break;
            default:
                System.out.println("Elige opción correcta");
                break; 
        }    
    }
}
