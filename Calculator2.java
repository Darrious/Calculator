package solution;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.text.JTextComponent;

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
    private JButton clearButton, dotButton;
    private JButton addButton;
    private JButton subButton;
    private JButton divButton;
    private JButton multButton;
    private JButton oneButton, twoButton, threeButton, fourButton,
            fiveButton, sixButton, sevenButton, eightButton, nineButton,
            zeroButton, backButton, percentButton;
    private JPanel buttonPanel;
    private JPanel textFieldPanel;
    //private JPanel resultPanel;
    private ExpressionEvaluator eval;

    
    public Calculator2()
    {
        numberListener numList = new numberListener();
        
        //Setting up frame
        calculator = new JFrame();
        calculator.setVisible(true);
        calculator.setSize(420,225);
        calculator.setTitle("Calculator");
        
        
        
        // Initializing fields
        buttonPanel = new JPanel();
        textFieldPanel = new JPanel();
        
        addButton = new JButton("+");
        subButton = new JButton("-");
        multButton = new JButton("x");
        divButton = new JButton("/");
        oneButton = new JButton("1");
        twoButton = new JButton("2");
        threeButton = new JButton("3");
        fourButton = new JButton("4");
        fiveButton = new JButton("5");
        sixButton = new JButton("6");
        sevenButton = new JButton("7");
        eightButton = new JButton("8");
        nineButton = new JButton("9");
        zeroButton = new JButton("0");
        dotButton = new JButton(".");
        backButton = new JButton("Back");
        percentButton = new JButton("%");
        calculateButton = new JButton("=");
        JButton pmButton = new JButton("+/-");
        
        clearButton = new JButton("C");
        infixExpression = new JTextField(15);
        resultLabel = new JLabel("Result");
        //resultPanel = new JPanel();
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
                    infixExpression.setText("ERROR");

                }
                
                else
                {
                    infixExpression.setText(Double.toString(answer));
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
        
        backButton.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                infixExpression.setText(infixExpression.getText().substring(0, infixExpression.getText().length() - 1));
                
            }
            
        
        });
        
        pmButton.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                String exp = infixExpression.getText();
                
                if (exp.charAt(0) == '-')
                {
                    infixExpression.setText(infixExpression.getText().substring(1, infixExpression.getText().length()));
                }
                else
                {
                    infixExpression.setText("-" + exp);
                }
                
            }
            
        });
        
        
        buttonPanel.add(clearButton);
        buttonPanel.add(pmButton);
        buttonPanel.add(percentButton);
        buttonPanel.add(backButton);
                
        buttonPanel.add(sevenButton);
        buttonPanel.add(eightButton);
        buttonPanel.add(nineButton);
        buttonPanel.add(divButton);

               
        buttonPanel.add(fourButton);
        buttonPanel.add(fiveButton);
        buttonPanel.add(sixButton);
        buttonPanel.add(multButton);
        
        buttonPanel.add(oneButton);
        buttonPanel.add(twoButton);
        buttonPanel.add(threeButton);
        buttonPanel.add(subButton);
        buttonPanel.add(addButton);
        
        buttonPanel.add(zeroButton);
        buttonPanel.add(dotButton);
        buttonPanel.add(calculateButton);
        buttonPanel.add(addButton);
        
        // Adding action listeners to some buttons
        oneButton.addActionListener(numList);
        twoButton.addActionListener(numList);
        threeButton.addActionListener(numList);
        fourButton.addActionListener(numList);
        fiveButton.addActionListener(numList);
        sixButton.addActionListener(numList);
        sevenButton.addActionListener(numList);
        eightButton.addActionListener(numList);
        nineButton.addActionListener(numList);
        zeroButton.addActionListener(numList);
        addButton.addActionListener(numList);
        subButton.addActionListener(numList);
        divButton.addActionListener(numList);
        multButton.addActionListener(numList);

        
        
        backButton.setBackground(Color.ORANGE);
        subButton.setBackground(Color.ORANGE);
        addButton.setBackground(Color.ORANGE);
        multButton.setBackground(Color.ORANGE);
        divButton.setBackground(Color.ORANGE);
        
        buttonPanel.setLayout(new GridLayout(5, 5));
       
        calculator.add(buttonPanel, BorderLayout.PAGE_END);
    
        
        
        Font font = new Font("Verdana", Font.BOLD, 25);
        infixExpression.setFont(font);
        textFieldPanel.add(infixExpression);
        
        
        calculator.add(textFieldPanel, BorderLayout.PAGE_START);
        
        //resultPanel.add( resultLabel);
        //calculator.add( resultPanel, BorderLayout.CENTER);
        
        
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
    
    
   
    
    private class numberListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent arg0)
        {      
               
               String symbol = ((JButton) arg0.getSource()).getText();
               
               if (symbol == "x") symbol = "*";
               
               infixExpression.setText(infixExpression.getText() + symbol);
        }
        
    }
}
