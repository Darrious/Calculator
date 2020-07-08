
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    private JButton clearButton, dotButton;
    private JButton addButton;
    private JButton subButton;
    private JButton divButton;
    private JButton multButton;
    private JButton oneButton, twoButton, threeButton, fourButton,
            fiveButton, sixButton, sevenButton, eightButton, nineButton,
            zeroButton, backButton, hisButton;
    private JPanel buttonPanel;
    private JPanel textFieldPanel;
    //private JPanel resultPanel;
    private ExpressionEvaluator eval;
    private ArrayList<String> hisArr;

    
    public Calculator2()
    {
    	// Action listener for the numbers
        numberListener numList = new numberListener();
        
        //Setting up frame
        calculator = new JFrame();
        calculator.setVisible(true);
        calculator.setSize(420,270);
        calculator.setTitle("Calculator");
        calculator.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        
        // Initializing fields
        hisArr = new ArrayList<String>();
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
        hisButton = new JButton("History");
        calculateButton = new JButton("=");
        JButton pmButton = new JButton("+/-");
        



        clearButton = new JButton("C");
        infixExpression = new JTextField(15);
        resultLabel = new JLabel("Result");
        //resultPanel = new JPanel();
        eval = new ExpressionEvaluator();
        
        
        addButton.setPreferredSize(new Dimension(35, 35));

        // Setting names for JUnit tests
        infixExpression.setName("infixExpression");
        resultLabel.setName("resultLabel");
        calculateButton.setName("calculateButton");
        clearButton.setName("clearButton");
        
        // Setting visibility
        resultLabel.setVisible(true);
        clearButton.setVisible(true);
        

        // Adding action listener for the history button
        hisButton.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                
                History();
            }
            
        });
        
        // Adding action listener for the equals button
        calculateButton.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                String answer;
                String infix = getField().getText();
                try
                {
                    answer = Double.toString(eval.evaluate(eval.toPostfix(infix)));

                }
                catch(Exception e1)
                {
                    answer = "ERROR";
                }
                
                hisArr.add(infixExpression.getText() + " = " + answer);
                infixExpression.setText(answer);
                
            }
        
        });
        
        // Adding action listener for the C button
        clearButton.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
               
                infixExpression.setText("");
                
            }
        
        });
        
        // Adding action listener for the back button
        backButton.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                infixExpression.setText(infixExpression.getText().substring(0, infixExpression.getText().length() - 1));
                
            }
            
        
        });
        
        // Adding action listener for the +/- button
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
        
        
        // Adding the five rows of buttons to the button panel
        buttonPanel.add(clearButton);
        buttonPanel.add(pmButton);
        buttonPanel.add(new JButton());
        buttonPanel.add(hisButton);
        buttonPanel.add(backButton);
        

        buttonPanel.add(sevenButton);
        buttonPanel.add(eightButton);
        buttonPanel.add(nineButton);
        buttonPanel.add(new JButton("("));
        buttonPanel.add(divButton);
               
        buttonPanel.add(fourButton);
        buttonPanel.add(fiveButton);
        buttonPanel.add(sixButton);
        buttonPanel.add(new JButton(")"));
        buttonPanel.add(multButton);
        
        buttonPanel.add(oneButton);
        buttonPanel.add(twoButton);
        buttonPanel.add(threeButton);
        buttonPanel.add(new JButton());
        buttonPanel.add(subButton);
        
        buttonPanel.add(zeroButton);
        buttonPanel.add(dotButton);
        buttonPanel.add(calculateButton);
        buttonPanel.add(new JButton());
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
        dotButton.addActionListener(numList);
        
        // Styling certain buttons
        backButton.setBackground(Color.ORANGE);
        subButton.setBackground(Color.ORANGE);
        addButton.setBackground(Color.ORANGE);
        multButton.setBackground(Color.ORANGE);
        divButton.setBackground(Color.ORANGE);
        
        // Making the button panel 5x5 and adding it the JFrame
        buttonPanel.setLayout(new GridLayout(5, 6));
        calculator.add(buttonPanel, BorderLayout.PAGE_END);
    
        
        // Adding font
        Font font = new Font("Verdana", Font.BOLD, 25);
        infixExpression.setFont(font);
        textFieldPanel.add(infixExpression);
        
        // Adding the textFieldPanel to JFrame
        calculator.add(textFieldPanel, BorderLayout.PAGE_START);
        
        //resultPanel.add( resultLabel);
        //calculator.add( resultPanel, BorderLayout.CENTER);
        
        
        calculator.setVisible(true);
    }
    
    // returns calculator JFrame
    public JFrame getFrame()
    {
        calculator.setVisible(true);
        
        
        return calculator;
    }


    // Returns the expression that is in the box (this will be computed)
    public JTextField getField()
    {
        return infixExpression;
    }
    
    // Main method
    public static void main(String[] args)
    {
        Calculator2 calc = new Calculator2();
    }
    
    
   
    // Generic action listener for the numbered buttons and other misc buttons
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
    

    // This method adds a new JFrame for the history function
    private void History()
    {
        
       //Setting up frame
        JFrame history = new JFrame();
        history.setVisible(true);
        history.setSize(420,225);
        history.setTitle("History");

        JTextArea hisText = new JTextArea();
        JTextArea title = new JTextArea();
        String output = "";
        
        
        // We add each computation the hisArr. That is printed here
        for (int i = 0; i < hisArr.size(); i++  )
        {
            output = output + hisArr.get(i) + "\n" ;
        }


        String titleText = "History";
        Font font = new Font("Verdana", Font.PLAIN, 17);
        Font font2 = new Font("Verdana", Font.BOLD, 20);

        hisText.setFont(font); 
        title.setFont(font2);

        title.setText(titleText);
        hisText.setText(output);
        
        history.add(title);
        history.add(hisText);

        
        
        
        
    }
    
    
}
