package Tarea3;

public class Libro {

    String codlibro, codISBN, autor, titulo, anno, editorial, materia;
    int copias;
    boolean estado;

    public Libro(String cod) {
        codlibro = cod;
    }

    public Libro(String codlibro, String codISBN, String autor, String titulo, String anno, String editorial,
            String materia, int copias, boolean estado) {
        this.codlibro = codlibro;
        this.codISBN = codISBN;
        this.autor = autor;
        this.anno = anno;
        this.editorial = editorial;
        this.materia = materia;
        this.copias = copias;
        this.estado = false;
    }

    public long transformaCodigo() {
        long suma = 0;
        int exp = codlibro.length() - 1;
        for (int i = 0; i < codlibro.length(); i++) {
            suma = suma + (int) codlibro.charAt(i) * (int) Math.pow(128, exp);
            exp--;
        }
        return suma;
    }

    public static int trunk(long key) {
        String s=Long.toString(key);
        char a=s.charAt(0);
        char b=s.charAt(1);        
        String ab=""+a+b;
        int valor=Integer.parseInt(ab);
        System.out.println(valor);
        return valor;
    }
    
    public static int pleg(long key){
        String s=Long.toString(key);
        int suma=0;
        for (int i = 0; i < s.length(); i++){      	
            suma=suma+Character.getNumericValue(s.charAt(i)); 
        }
        return suma;
    }

    @Override
    public String toString() {

        return codlibro + " " + codISBN + " " + autor + " " + titulo + " " + anno + " " + editorial + " " + materia + " " + copias + " " + estado;
    }

}
