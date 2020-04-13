package solution;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * @author Darrious Barger
 * @version 1
 */
public class Calculator2
{
    private JFrame calculator;
    private JTextField infixExpression;
    private JLabel resultLabel;
    private JButton calculateButton;
    private JButton clearButton;
    //private JButton addButton;
    //private JButton subButton;
    //private JButton divButton;
    //private JButton multButton;
    private JPanel buttonPanel;
    private JPanel textFieldPanel;
    private JPanel resultPanel;
    private ExpressionEvaluator eval;

    
    public Calculator2()
    {
        //Setting up frame
        calculator = new JFrame();
        calculator.setVisible(true);
        calculator.setSize(420,170);
        calculator.setTitle("Calculator");
        
        
        // Initializing fields
        buttonPanel = new JPanel();
        textFieldPanel = new JPanel();
        //addButton = new JButton("+");
        //subButton = new JButton("-");
        //multButton = new JButton("*");
        //divButton = new JButton("/");
        calculateButton = new JButton("=");
        clearButton = new JButton("Clear");
        infixExpression = new JTextField(20);
        resultLabel = new JLabel("Result");
        resultPanel = new JPanel();
        eval = new ExpressionEvaluator();
        
        // Setting names for JUnit tests
        infixExpression.setName("infixExpression");
        resultLabel.setName("resultLabel");
        calculateButton.setName("calculateButton");
        clearButton.setName("clearButton");
        
        // Setting visibility
        resultLabel.setVisible(true);
        clearButton.setVisible(true);
        
        calculateButton.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                
                String infix = getField().getText();
                Double answer = eval.evaluate(eval.toPostfix(infix));
                
                if (!Character.isDigit(infix.charAt(infix.length() -1)))
                {
                    resultLabel.setText("Result = error");

                }
                
                else
                {
                    resultLabel.setText("Result = " + Double.toString(answer));
                }
            }
        
        });
        
        clearButton.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
               
                infixExpression.setText("");
                
            }
        
        });

        buttonPanel.add(calculateButton);
        buttonPanel.add(clearButton);
        calculator.add( buttonPanel, BorderLayout.PAGE_END);
    
        
        textFieldPanel.add(infixExpression);
        calculator.add( textFieldPanel, BorderLayout.PAGE_START);
       
        
        resultPanel.add( resultLabel);
        calculator.add( resultPanel, BorderLayout.CENTER);
        
        
        calculator.setVisible(true);
    }
    
    public JFrame getFrame()
    {
        calculator.setVisible(true);
        
        
        return calculator;
    }
    
    public JTextField getField()
    {
        return infixExpression;
    }
    

    
    
    public static void main(String[] args)
    {
        Calculator2 calc = new Calculator2();
    }
}
