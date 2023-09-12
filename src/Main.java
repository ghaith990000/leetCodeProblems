// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        StackX theStack = new StackX(10);
        theStack.push(20);
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);

        while(!theStack.isEmpty())
        {
            long value = theStack.pop();
            System.out.print(value);
            System.out.print(" ");

        }
        System.out.println("");

    }
}