import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class StackChar
{
    private int maxSize;
    private char[] stackArray;
    private int top;

    public StackChar(int max){
        maxSize = max;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char j)
    {
        stackArray[++top] = j;
    }

    public char pop()
    {
        return stackArray[top--];
    }

    public char peek()
    {
        return stackArray[top];
    }

    public boolean isEmpty()
    {
        return (top == -1);
    }
}
public class Reverser {
    private String input;
    private String output;

    public Reverser(String in)
    {
        input = in;
    }

    public String doRev(){
        int stackSize = input.length();
        StackChar theStack = new StackChar(stackSize);

        for(int j=0; j<input.length(); j++)
        {
            char ch = input.charAt(j);
            theStack.push(ch);
        }

        output = "";
        while(!theStack.isEmpty())
        {
            char ch = theStack.pop();
            output = output + ch;
        }
        return output;
    }
}

class ReverserApp{
    public static void main(String[] args) throws IOException
    {
        String input, output;
        while(true){
            System.out.println("Enter a string: ");
            System.out.flush();
            input = getString();
            if(input.equals("")){
                break;
            }

            Reverser theReverser = new Reverser(input);
            output = theReverser.doRev();
            System.out.println("Reversed: " + output);
        }
    }

    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s1 = br.readLine();
        return s1;

    }
}
