package solution;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.Stack;
/**
 * 
 * @author Darrious Barger
 * @version 1
 * 
 */
public class ExpressionEvaluator
{

    public static final Pattern UNSIGNED_DOUBLE =
            Pattern.compile("((\\d+\\.?\\d*)|(\\.\\d+))([Ee][-+]?\\d+)?.*?");
    public static final Pattern CHARACTER = Pattern.compile("\\S.*?");

    
    public boolean precedence(String a, String b)
    {
        
        int value1 = 0;
        int value2 = 0;
        
        
        if (!b.equals("+") && !b.equals("-") && !b.equals("*") && !b.equals("/"))
        {
            return true;
        }
        
        
        else
        {
            if(a.equals("+") || a.equals("-") )
            {
                value1 = 1;
            }

            if(a.equals("*") || a.equals("/") )
            {
                value1 = 2;
            }

            
            if(b.equals("+") || b.equals("-") )
            {
                value2 = 1;
            }

            if(b.equals("*") || b.equals("/") )
            {
                value2 = 2;
            }

        }
        
        if (value1 == value2)
        {
            return true;
        }
        return value1 < value2;
    }
    
    public String conversionAlgo(Stack<String> nums ,Boolean x)
    {
        
        
        return "";
    }
    
    /**
     * Takes an infix expression and converts it to postfix.
     * 
     * @param expression
     *            The infix expression.
     * @return the postfix expression.
     */
    public String toPostfix(String expression)
    {
        
        // ... other local variables
        boolean check = true;
        Scanner input = new Scanner(expression);
        String next;
        char symbol;
        String postfixExpression = "";
        Stack<String> nums = new Stack<String>();
     
        while (input.hasNext())
        {            
             
            if (input.hasNext(UNSIGNED_DOUBLE))
            {
                next = input.findInLine(UNSIGNED_DOUBLE);
                System.out.println("Pushed: " + next);
                nums.push(next);
            }
            else
            {
                next = input.findInLine(CHARACTER);
                symbol = next.charAt(0);

                if (!nums.isEmpty())
                {
                    check = precedence(Character.toString(symbol), nums.peek());
                }
                
                switch(symbol)
                {                                       
                    case '+':
                        while(!nums.isEmpty() && check != false) 
                        {
                            
                            if (nums.peek().equals("("))
                            {
                                System.out.println("Left paranthesis");
                                break;
                            }
                            
                            System.out.println("Popped: " + nums.peek());
                            postfixExpression += nums.pop();
                            postfixExpression += " ";
                            if (!nums.isEmpty())
                            {
                                check = precedence(Character.toString(symbol), nums.peek());
                            }
                            
                            
                        }
                        
                        System.out.println("Pushed: " + symbol);
                        nums.push(Character.toString(symbol));
                        break;
                        
                        
                    case '-':
                       while(!nums.isEmpty() && check != false) 
                        {
                           if (nums.peek().equals("("))
                           {
                               System.out.println("Left paranthesis");
                               break;
                           }
                         
                            System.out.println("Popped: " + nums.peek());
                            postfixExpression += nums.pop();
                            postfixExpression += " ";
                            if (!nums.isEmpty())
                            {
                                check = precedence(Character.toString(symbol), nums.peek());
                            }
                        }
                        
                        System.out.println("Pushed: " + symbol);
                        nums.push(Character.toString(symbol));
                        break;
                       
                        
                    case '/':
                        while(!nums.isEmpty() && check != false) 
                        {
                            if (nums.peek().equals("("))
                            {
                                System.out.println("Left paranthesis");
                                break;
                            }
                                                                               
                            System.out.println("Popped: " + nums.peek());
                            postfixExpression += nums.pop();
                            postfixExpression += " ";
                            if (!nums.isEmpty())
                            {
                                check = precedence(Character.toString(symbol), nums.peek());
                            }

                        }
                        
                        System.out.println("Pushed: " + symbol);
                        nums.push(Character.toString(symbol));
                        break;
                        
                        
                    case '*':
                        
                        while(!nums.isEmpty() && check != false) 
                        {
                            if (nums.peek().equals("("))
                            {
                                System.out.println("Left paranthesis");
                                break;
                            }
                            
                            System.out.println("Popped: " + nums.peek());
                            postfixExpression += nums.pop();
                            postfixExpression += " ";
                            if (!nums.isEmpty())
                            {
                                check = precedence(Character.toString(symbol), nums.peek());
                            }
                        }
                        
                        System.out.println("Pushed: " + symbol);
                        nums.push(Character.toString(symbol));
                        break;
                        
                    case '(':
                        System.out.println("Pushed: " + symbol);
                        nums.push(Character.toString(symbol));
                        break;
                        
                        
                        
                    case ')':
                        while(!nums.isEmpty()) 
                        {
                            if (nums.peek().equals("("))
                            {
                                System.out.println("Popped: " + nums.peek());

                                nums.pop();
      
                                
                                break;
                            }
                            
                            System.out.println("Popped: " + nums.peek());
                            postfixExpression += nums.pop();
                            postfixExpression += " ";                            
                            
                        }

                        break;
                        
                    default:
                        
                }
            }
        }
                       
        while (!nums.isEmpty())
        {
            System.out.println("Popped: " + nums.peek());
            postfixExpression += nums.pop();
            postfixExpression += " ";
           
        }
        
        input.close();
        return postfixExpression;
    }

    /**
     * Evaluates a postfix expression and returns the result.
     * 
     * @param postfixExpression
     *            The postfix expression.
     * @return The result of the expression.
     */
    public double evaluate(String postfixExpression)
    {
        // other local variables you may need
        Scanner input = new Scanner(postfixExpression);
        String next;
        char operator;
        double answer = 0;
        Stack<String> nums = new Stack<String>();

        while (input.hasNext())
        {
            if (input.hasNext(UNSIGNED_DOUBLE))
            {
                next = input.findInLine(UNSIGNED_DOUBLE);
                System.out.println("Pushed: " + next);
                nums.push(next);
            }
            else
            {
                next = input.findInLine(CHARACTER);
                operator = next.charAt(0);
                double num1 = 0;
                double num2 = 0;
                
                if (!nums.isEmpty())
                    num1 = Double.parseDouble(nums.pop());
                if (!nums.isEmpty())
                    num2 = Double.parseDouble(nums.pop());
                
                switch(operator)
                {
                    case '+':              
                        answer = num1 + num2;
                        break;
                        
                    case '-':
                        answer = num2 - num1;
                        break;
                        
                    case '*':
                        answer = num1 * num2;
                        break;
                        
                    case '/':
                        answer = num2 / num1;
                        break;
                }
                
                nums.push(Double.toString(answer));
            }
        }
        
        input.close();
        
        if (answer == 0)
        {
            return Double.parseDouble(postfixExpression);
        }
        return answer;

    }

}
