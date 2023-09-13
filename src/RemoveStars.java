import java.util.Stack;
public class RemoveStars {
    public String removeStars(String s){
        Stack<Character> stack = new Stack<Character>();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '*'){
                stack.pop();
            }else {
                stack.push(s.charAt(i));
            }
        }

        for(Character c : stack){
            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }
}
