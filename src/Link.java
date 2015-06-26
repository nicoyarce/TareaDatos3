public class Link {// (could be other items)

    private Libro iData; // data item
    public Link next; // next link in list
    //-------------------------------------------------------------

    public Link(Libro libro) // constructor
    {
        iData = libro;
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
