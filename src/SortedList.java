class SortedLink {
    public long dData;
    public SortedLink next;

    public SortedLink(long dd)
    {
        dData = dd;
    }

    public void displayLink()
    {
        System.out.print(dData + " ");
    }
}
public class SortedList {
    private SortedLink first;

    public SortedList()
    {
        first = null;
    }

    public boolean isEmpty()
    {
        return (first==null);
    }

    public void insert(long key)
    {
        SortedLink newLink = new SortedLink(key);
        SortedLink previous = null;
        SortedLink current = first;

        while(current != null && key > current.dData){
            previous = current;
            current = current.next;
        }

        if(previous==null)
            first = newLink;
        else
            previous.next = newLink;
        newLink.next= current;
    }

    public SortedLink remove(){
        SortedLink temp = first;
        first= first.next;
        return temp;
    }

    public void displayList()
    {
        System.out.print("List (first-->last): ");
        SortedLink current= first;

        while(current != null)
        {
            current.displayLink();
            current= current.next;
        }
        System.out.println("");
    }
}

class SortedListApp
{
    public static void main(String[] args){
        SortedList theSortedList =  new SortedList();
        theSortedList.insert(20);
        theSortedList.insert(40);

        theSortedList.displayList();

        theSortedList.insert(10);
        theSortedList.insert(30);
        theSortedList.insert(50);

        theSortedList.displayList();

        theSortedList.remove();

        theSortedList.displayList();
    }
}
