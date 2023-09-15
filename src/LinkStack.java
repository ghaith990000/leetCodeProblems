class StackLink
{
    public long dData;
    public StackLink next;

    public StackLink(long dd)
    {
        dData = dd;
    }

    public void displayLink(){
        System.out.print(dData + " ");
    }

}

class StackLinkedList
{
    private StackLink first;

    public StackLinkedList(){
        first = null;
    }

    public boolean isEmpty(){
        return (first==null);
    }

    public void insertFirst(long dd)
    {
        StackLink newLink = new StackLink(dd);
        newLink.next = first;
        first= newLink;
    }

    public long deleteFirst()
    {
        StackLink temp = first;
        first = first.next;
        return temp.dData;
    }

    public void displayList()
    {
        StackLink current = first;
        while(current != null)
        {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}
public class LinkStack {
    private StackLinkedList theList;

    public LinkStack()
    {
        theList = new StackLinkedList();
    }

    public void push(long j)
    {
        theList.insertFirst(j);
    }

    public long pop()
    {
        return theList.deleteFirst();
    }

    public boolean isEmpty(){
        return (theList.isEmpty());
    }

    public void displayStack()
    {
        System.out.print("Stack (top-->bottom): ");
        theList.displayList();
    }

}

class LinkStackApp
{
    public static void main(String[] args){
        LinkStack theStack= new LinkStack();

        theStack.push(20);
        theStack.push(40);

        theStack.displayStack();

        theStack.push(60);
        theStack.push(80);

        theStack.displayStack();

        theStack.pop();
        theStack.pop();

        theStack.displayStack();

    }
}
