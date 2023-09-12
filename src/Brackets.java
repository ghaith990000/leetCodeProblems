import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class StackCharacter{
    private int maxSize;
    private char[] stackArray;
    private int top;

    public StackCharacter(int s){
        maxSize = s;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char j)
    {
        stackArray[++top] = j;
    }

    public char pop(){
        return stackArray[top--];
    }

    public char peek()
    {
        return stackArray[top];
    }

    public boolean isEmpty(){
        return (top == -1);
    }
}


public class Brackets {
    private String input;

    public Brackets(String in){
        input = in;
    }

    public void check()
    {
        int stackSize = input.length();
        StackCharacter theStack = new StackCharacter(stackSize);

        for(int j=0; j<input.length(); j++)
        {
            char ch = input.charAt(j);
            switch(ch)
            {
                case '{':

                case '[':

                case '(':
                    theStack.push(ch);
                    break;

                case '}':

                case ']':

                case ')':
                    if(!theStack.isEmpty())
                    {
                        char chx = theStack.pop();
                        if(
                                (ch=='}' && chx!='{')
                                || (ch==']' && chx != '[')
                                || (ch==')' && chx!='(')
                        )
                            System.out.println("Error: " + ch + " at " + j);
                    }else
                        System.out.println("Error: "+ch+ " at " + j);
                    break;
                default:
                    break;
            }
        }
        if(!theStack.isEmpty()){
            System.out.println("Error: Missing right delimiter");
        }
    }
}

class BracketsApp
{
    public static void main(String[] args) throws IOException
    {
        String input;
        while(true)
        {
            System.out.print("Enter string containing delimiters: ");
            System.out.flush();
            input = getString();
            if(input.equals(""))
                break;

            Brackets theChecker = new Brackets(input);
            theChecker.check();
        }
    }

    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}
