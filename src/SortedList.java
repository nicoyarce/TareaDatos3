
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
