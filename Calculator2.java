package solution;

import java.awt.BorderLayout;
import java.awt.Color;
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
            zeroButton;
    private JPanel buttonPanel;
    private JPanel textFieldPanel;
    private JPanel resultPanel;
    private ExpressionEvaluator eval;

    
    public Calculator2()
    {
        numberListener numList = new numberListener();
        
        //Setting up frame
        calculator = new JFrame();
        calculator.setVisible(true);
        calculator.setSize(420,250);
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

        
        calculateButton = new JButton("=");
        
        
        clearButton = new JButton("C");
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
        
        
        buttonPanel.add(clearButton);
        buttonPanel.add(new JButton("+/-"));
        buttonPanel.add(new JButton("%"));
        buttonPanel.add(divButton);
        
        buttonPanel.add(sevenButton);
        buttonPanel.add(eightButton);
        buttonPanel.add(nineButton);
        buttonPanel.add(multButton);
        
        buttonPanel.add(fourButton);
        buttonPanel.add(fiveButton);
        buttonPanel.add(sixButton);
        buttonPanel.add(subButton);
        
        buttonPanel.add(oneButton);
        buttonPanel.add(twoButton);
        buttonPanel.add(threeButton);
        buttonPanel.add(addButton);
        
        buttonPanel.add(new JButton(""));
        buttonPanel.add(zeroButton);
        buttonPanel.add(dotButton);
        buttonPanel.add(calculateButton);
        
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

        
        
        calculateButton.setBackground(Color.ORANGE);
        subButton.setBackground(Color.ORANGE);
        addButton.setBackground(Color.ORANGE);
        multButton.setBackground(Color.ORANGE);
        divButton.setBackground(Color.ORANGE);
        
        buttonPanel.setLayout(new GridLayout(5, 5));
       
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
    
    
    
    // We need to find a way to get text form button name
    private class numberListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent arg0)
        {
               infixExpression.setText(infixExpression.getText() + ((JButton) arg0.getSource()).getText());
        }
        
    }
}
