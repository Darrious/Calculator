package solution;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * @author Darrious Barger
 * @version 1
 */

public class Calculator
{
    private JFrame calculator;
    private JTextField rightOperand;
    private JTextField leftOperand;
    private JLabel resultLabel;
    private JPanel buttonPanel;
    private JButton addButton;
    private JButton subButton;
    private JButton divButton;
    private JButton multButton;
    private JPanel resultPanel;
    private JPanel textFieldPanel;

    
    public Calculator()
    {
        calculator = new JFrame();
        calculator.setVisible(true);
        calculator.setSize(420,170);
        calculator.setTitle("Calculator");
        
        buttonPanel = new JPanel();
        resultPanel = new JPanel();
        textFieldPanel = new JPanel();
        buttonPanel.setVisible(true);
        resultPanel.setVisible(true);
        textFieldPanel.setVisible(true);
        
        addButton = new JButton("ADD");
        subButton = new JButton("SUB");
        multButton = new JButton("MULT");
        divButton = new JButton("DIV");
        
        addButton.setVisible(true);
        subButton.setVisible(true);
        multButton.setVisible(true);
        divButton.setVisible(true);
        
        addButton.setName("addButton");
        subButton.setName("subButton");
        multButton.setName("multButton");
        divButton.setName("divButton");
        
        resultLabel = new JLabel("Result");
        resultLabel.setVisible(true);
  
        leftOperand = new JTextField(15);
        rightOperand = new JTextField(15);
        leftOperand.setVisible(true);
        rightOperand.setVisible(true);
        
        calculator.setVisible(true);
        calculator.setSize(420,170);
        calculator.setTitle("Calculator");
       
       //Creating action listeners
        addButton.addActionListener(new ActionListener()
           {
               @Override
               public void actionPerformed(ActionEvent e)
               {
                   String num1 =  getField1().getText();
                   String num2 =  getField2().getText();
                   
                   System.out.println(num1);
                   
                   if ( isNumeric(num1) &&  isNumeric(num2)) 
                   {
                       double numD1 = Double.parseDouble(num1);
                       double numD2 = Double.parseDouble(num2);
                       
                        getLabel().setText("Result = " + (numD1 + numD2));
                   }
                   
                   else
                   {
                        getLabel().setText("Result = Error");
                   }      
                   
               }
           });
       
       
 
       
       subButton.addActionListener(new ActionListener()
       {

           @Override
           public void actionPerformed(ActionEvent e)
           {
               String num1 =  getField1().getText();
               String num2 =  getField2().getText();
               
               System.out.println(num1);
               
               if (isNumeric(num1) && isNumeric(num2)) 
               {
                   double numD1 = Double.parseDouble(num1);
                   double numD2 = Double.parseDouble(num2);
                   
                    getLabel().setText("Result = " + (numD1 - numD2));
               }
               
               else
               {
                    getLabel().setText("Result = Error");
               } 
               
           }
       
       });
       
       divButton.addActionListener(new ActionListener()
       {

           @Override
           public void actionPerformed(ActionEvent e)
           {
               String num1 =  getField1().getText();
               String num2 =  getField2().getText();
               
               System.out.println(num1);
               
               if (isNumeric(num1) && isNumeric(num2)) 
               {
                   double numD1 = Double.parseDouble(num1);
                   double numD2 = Double.parseDouble(num2);
                   
                   if (numD2 != 0)
                   {
                        getLabel().setText("Result = " + (numD1 / numD2));
                   }
                   
                   else
                   {
                        getLabel().setText("Result = Error");
                   }
               }
               else
               {
                    getLabel().setText("Result = Error");
               }
               
           }
       
       });
       
       multButton.addActionListener(new ActionListener()
       {

           @Override
           public void actionPerformed(ActionEvent e)
           {
               String num1 =  getField1().getText();
               String num2 =  getField2().getText();
               
               System.out.println(num1);
               
               if (isNumeric(num1) && isNumeric(num2)) 
               {
                   double numD1 = Double.parseDouble(num1);
                   double numD2 = Double.parseDouble(num2);
                   
                    getLabel().setText("Result = " + (numD1 * numD2));
               }
               
               else
               {
                    getLabel().setText("Result = Error");
               }
           }
       
       });
       
       
       //Set button names
       
        addButton.setVisible(true);
        subButton.setVisible(true);
        multButton.setVisible(true);
        divButton.setVisible(true);
       
       
       // Adding buttons to button panel
        buttonPanel.add( addButton);
        buttonPanel.add( subButton);
        buttonPanel.add( multButton);
        buttonPanel.add( divButton);
        calculator.add( buttonPanel, BorderLayout.PAGE_END);
       
       
       //Make Results panel
        resultLabel.setName("resultLabel");
        resultPanel.add( resultLabel);
        calculator.add( resultPanel, BorderLayout.CENTER);
       
       // Setting up text field
        leftOperand.setName("leftOperand");
        rightOperand.setName("rightOperand");
      
       //Adding text field panel
        textFieldPanel.add( leftOperand);
        textFieldPanel.add( rightOperand);
       
        calculator.add( textFieldPanel, BorderLayout.PAGE_START);
       
        calculator.setVisible(true);
       
       //String num = leftOperand.getText();
       //double num1 = Double.parseDouble(num);
    }
    
    public static void main(String[] args)
    {
        Calculator calc = new Calculator();
    }
    
    public JTextField getField1()
    {  
        return leftOperand;
    }
    
    public JTextField getField2()
    {  
        return rightOperand;
    }
    
    public JLabel getLabel()
    {
        return resultLabel;
    }
    
    public JFrame getFrame()
    {
        calculator.setVisible(true);
        return calculator;
    }
    
    public static boolean isNumeric(String s)
    {
        try
        {
            Double.parseDouble(s);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        } 
    }
}


