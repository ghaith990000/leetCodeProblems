

public class LinkList {
    private Link first;

    public void LinkList()
    {
        first = null;
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public void insertFirst(int id, double dd)
    {
        Link newLink = new Link(id, dd);
        newLink.next = first;
        first = newLink;
    }

    public Link deleteFirst()
    {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void insert(int key, double dd)
    {
        Link newLink = new Link(key, dd);
        Link previous = null;
        Link current = first;

        while(current != null && key > current.dData){
            previous = current;
            current = current.next;
        }

        if(previous == null)
            first = newLink;
        else
            previous.next = newLink;
        newLink.next = current;
    }

    public Link find(int key)
    {
        Link current = first;
        while(current.iData != key)
        {
            if(current.next == null)
                return null;
            else
                current = current.next;
        }
        return current;
    }

    public Link delete(int key)
    {
        Link current = first;
        Link previous = first;
        while(current.iData != key)
        {
            if(current.next == null)
                return null;
            else{
                previous = current;
                current = current.next;
            }
        }

        if(current == first)
            first = first.next;
        else
            previous.next = current.next;
        return current;
    }



    public void displayList()
    {
        System.out.print("List (first-->last): ");
        Link current = first;
        while(current != null)
        {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }



}

class LinkedListApp
{
    public static void main(String[] args)
    {
        LinkList theList = new LinkList();

        theList.insertFirst(22, 2.99);
        theList.insertFirst(44, 4.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(88, 8.99);

        theList.displayList();

        Link f = theList.find(44);
        if(f != null)
            System.out.println("Found link with key " + f.iData);
        else
            System.out.println("Can't find link.");

        Link d = theList.delete(66);
        if(d != null)
            System.out.println("Deleted Link with key " + d.iData);
        else
            System.out.println("Can't delete link");

        theList.displayList();
    }
}
