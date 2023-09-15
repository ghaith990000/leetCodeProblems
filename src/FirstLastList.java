// demonstrates list with first and last references
class Node
{
    public long dData;
    public Node next;

    public Node(long d)
    {
        dData = d;
    }

    public void displayLink(){
        System.out.print(dData + " ");
    }
}
public class FirstLastList {
    private Node first;
    private Node last;

    public FirstLastList(){
        first = null;
        last = null;
    }

    public boolean isEmpty()
    {
        return first==null;
    }

    public void insertFirst(long dd)
    {
        Node newLink = new Node(dd);

        if(isEmpty())
            last = newLink;
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(long dd)
    {
        Node newLink = new Node(dd);
        if(isEmpty())
            first = newLink;
        else
            last.next = newLink;
        last = newLink;
    }

    public long deleteFirst()
    {
        long temp = first.dData;
        if(first.next == null)
            last=null;
        first = first.next;
        return temp;
    }

    public void displayList()
    {
        System.out.print("List (first-->last): ");
        Node current = first;
        while(current != null)
        {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}

class FirstLastApp
{
    public static void main(String[] args){
        FirstLastList theList = new FirstLastList();

        theList.insertFirst(22);
        theList.insertFirst(44);
        theList.insertFirst(66);

        theList.insertLast(11);
        theList.insertLast(33);
        theList.insertLast(55);


        theList.displayList();

        theList.deleteFirst();
        theList.deleteFirst();

        theList.displayList();

    }
}
