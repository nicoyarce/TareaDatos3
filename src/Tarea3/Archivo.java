package Tarea3;


import java.io.*;

public class Archivo {

    HashTableC tablaC;
    HashDoubleD tablaD;
    HashDoubleE tablaE;
    HashDoubleF tablaF;

    public Archivo() {
        this.tablaC = new HashTableC(131);
        this.tablaD = new HashDoubleD(131);
        this.tablaE = new HashDoubleE(131);
        this.tablaF = new HashDoubleF(131);
    }

    public void insertarLibro(Libro nuevo) {
        try {
            File f = new File("archivo.txt");
            FileWriter fw;
            BufferedWriter bw;
            if (f.exists()) {
                fw = new FileWriter(f, true);
                bw = new BufferedWriter(fw);
                bw.newLine();
                bw.write(nuevo.codlibro + "\t" + nuevo.codISBN + "\t" + nuevo.autor
                        + "\t" + nuevo.titulo + "\t" + nuevo.anno + "\t" + nuevo.editorial
                        + "\t" + nuevo.materia + "\t" + nuevo.copias + "\t" + nuevo.estado);
            } else {
                fw = new FileWriter(f);
                bw = new BufferedWriter(fw);
                bw.write(nuevo.codlibro + "\t" + nuevo.codISBN + "\t" + nuevo.autor
                        + "\t" + nuevo.titulo + "\t" + nuevo.anno + "\t" + nuevo.editorial
                        + "\t" + nuevo.materia + "\t" + nuevo.copias + "\t" + nuevo.estado);
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void abrirArchivo() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("archivo.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            // String linea;
            String linea;
            String codlibro, codISBN, autor, titulo, anno, editorial, materia;
            int copias;
            boolean estado;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void hashingEncadenado() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("archivo.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            // String linea;
            String linea;
            String codlibro, codISBN, autor, titulo, anno, editorial, materia;
            int copias;
            boolean estado;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split("\t");
                Libro l = new Libro(campos[0], campos[1], campos[2], campos[3], campos[4], campos[5], campos[6], Integer.parseInt(campos[7]), Boolean.parseBoolean(campos[8]));
                Link thelink = new Link(l);
                tablaC.insert(thelink);
                tablaC.displayTable();

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void dobleHashD() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("archivo.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            // String linea;
            String linea;
            String codlibro, codISBN, autor, titulo, anno, editorial, materia;
            int copias;
            boolean estado;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split("\t");
                Libro l = new Libro(campos[0], campos[1], campos[2], campos[3], campos[4], campos[5], campos[6], Integer.parseInt(campos[7]), Boolean.parseBoolean(campos[8]));
                tablaD.insert(l.transformaCodigo(), l);
                tablaD.displayTable();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    
    public void dobleHashE() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("archivo.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            // String linea;
            String linea;
            String codlibro, codISBN, autor, titulo, anno, editorial, materia;
            int copias;
            boolean estado;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split("\t");
                Libro l = new Libro(campos[0], campos[1], campos[2], campos[3], campos[4], campos[5], campos[6], Integer.parseInt(campos[7]), Boolean.parseBoolean(campos[8]));
                tablaE.insert(l.transformaCodigo(), l);
                tablaE.displayTable();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    
    public void dobleHashF() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("archivo.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            // String linea;
            String linea;
            String codlibro, codISBN, autor, titulo, anno, editorial, materia;
            int copias;
            boolean estado;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split("\t");
                Libro l = new Libro(campos[0], campos[1], campos[2], campos[3], campos[4], campos[5], campos[6], Integer.parseInt(campos[7]), Boolean.parseBoolean(campos[8]));
                tablaF.insert(l.transformaCodigo(), l);
                tablaF.displayTable();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
