import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class StackCustom
{
    private int maxSize;
    private char[] stackArray;
    private int top;

    public StackCustom(int s){
        maxSize = s;
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

    public int size()
    {
        return top+1;
    }

    public char peekN(int n)
    {
        return stackArray[n];
    }

    public void displayStack(String s)
    {
        System.out.print(s);
        System.out.print("Stack (bottom-->top): ");
        for(int j=0; j<size(); j++)
        {
            System.out.print(peekN(j));
            System.out.print(' ');
        }
        System.out.println("");
    }
}
public class InfToPost {
    private StackCustom theStack;
    private String input;
    private String output = "";

    public InfToPost(String in)
    {
        input = in;
        int stackSize = input.length();
        theStack = new StackCustom(stackSize);
    }

    public String doTrans(){
        for(int j=0; j<input.length(); j++)
        {
            char ch = input.charAt(j);
            theStack.displayStack("For " + ch + " ");
            switch(ch)
            {
                case '+':
                case '-':
                    gotOper(ch, 1);
                    break;
                case '*':
                case '/':
                    gotOper(ch, 2);
                    break;
                case '(':
                    theStack.push(ch);
                    break;
                case ')':
                    gotParen(ch);
                    break;
                default:
                    output = output + ch;
                    break;
            }
        }

        while(!theStack.isEmpty())
        {
            theStack.displayStack("While ");
            output = output + theStack.pop();
        }

        theStack.displayStack("End ");
        return output;
    }

    public void gotOper(char opThis, int prec1)
    {
        while(!theStack.isEmpty())
        {
            char opTop = theStack.pop();

            if(opTop == '(')
            {
                theStack.push(opTop);
                break;
            }else {
                int prec2;

                if(opTop == '+' || opTop=='-')
                    prec2 = 1;
                else
                    prec2 = 2;

                if(prec2 < prec1)
                {
                    theStack.push(opTop);
                    break;
                }else
                    output = output + opTop;
            }
        }
        theStack.push(opThis);
    }

    public void gotParen(char ch){
        while(!theStack.isEmpty())
        {
            char chx = theStack.pop();
            if(chx == '(')
                break;
            else
                output = output + chx;
        }
    }
}

class InfixApp
{
    public static void main(String[] args) throws IOException{
        String input, output;
        while(true)
        {
            System.out.print("Enter infix: ");
            System.out.flush();
            input = getString();
            if(input.equals(""))
                break;

            InfToPost theTrans = new InfToPost(input);
            output = theTrans.doTrans();
            System.out.println("Posfix is " + output + "\n");
        }
    }

    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }
}
