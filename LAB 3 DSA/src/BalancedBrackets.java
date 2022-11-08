
import java.util.*;
 
public class BalancedBrackets {
 
    static boolean BracketsBalanced(String expr)
    {
        
        Deque<Character> operator = new ArrayDeque<Character>();
 
        
        for (int i = 0; i < expr.length(); i++) {
            char x = expr.charAt(i);
 
            if (x == '(' || x == '[' || x == '{') {
                
            	operator.push(x);
                continue;
            }
 
            
            if (operator.isEmpty())
                return false;
            char check;
            switch (x) {
            case ')':
                check = operator.pop();
                if (check == '{' || check == '[')
                    return false;
                break;
 
            case '}':
                check = operator.pop();
                if (check == '(' || check == '[')
                    return false;
                break;
 
            case ']':
                check = operator.pop();
                if (check == '(' || check == '{')
                    return false;
                break;
            }
        }
 
        
        return (operator.isEmpty());
    }
 
    
    public static void main(String[] args)
    {
        String expr = "([{}])";
 
        
        if (BracketsBalanced(expr))
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");
    }
}